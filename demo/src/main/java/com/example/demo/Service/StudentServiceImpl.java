package com.example.demo.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Service;

import com.example.demo.Repo.StudentRepo;
import com.example.demo.model.AddressDetails;
import com.example.demo.model.AddressDetails_;
import com.example.demo.model.Student;
import com.example.demo.model.Student_;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

	private final StudentRepo studRepo;

	public StudentServiceImpl(StudentRepo studRepo) {
		this.studRepo = studRepo;
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Student> findStudentWithMultipleAddress() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);

		Root<Student> root = cq.from(Student.class);
		
		
//		select s.student_id, s.last_name ,max(s.total_marks) FROM Student s inner join 
//		Address_details a on s.student_id=a.student_id
//		where a.city ='cbe' and datediff(now(),s.joining_date)>90 and 
//		 s.total_marks<(select max(s1.total_marks) from Student s1  inner join 
//		Address_details a on s1.student_id=a.student_id
//		where a.city ='cbe' and datediff(now(),s.joining_date)>90);
		
		
		
		
		
cq.multiselect(root.get(Student_.id), root.get(Student_.joiningDate), root.get(Student_.firstName),
				cb.max(root.get(Student_.totalMarks)),
				cb.selectCase(root.get("lastName"))

						.when("kl", "K.Loganathan").
						when("dg", "Dangerous Guys").
						when("prema", "Prema.Loganathan")
						.otherwise(root.get("lastName")));
		
ListJoin<Student, AddressDetails> stud_address_outer = root.join(Student_.addressDetails, JoinType.INNER);
Predicate cityPred = cb.equal(stud_address_outer.get(AddressDetails_.city), "cbe");
	    
//		Predicate p=cb.equal(root.get(Student_.id),"1");
	    
	Predicate datePred = cb
				.greaterThan(cb.function("DATEDIFF", Integer.class, cb.currentDate(), root.get(Student_.joiningDate)

				), 90);
		
		

		Subquery<Double> sq = cq.subquery(Double.class);
		Root<Student> innerRoot = sq.from(Student.class);

		ListJoin<Student, AddressDetails> stud_address_inner = innerRoot.join(Student_.addressDetails, JoinType.INNER);
		Expression<Double> ex = sq.select(cb.max(innerRoot.get(Student_.totalMarks)));
		
		
		
		Predicate cityPredinner = cb.equal(stud_address_inner.get(AddressDetails_.city), "cbe");

		
		Predicate datePredInner = cb
				.greaterThan(cb.function("DATEDIFF", Integer.class, cb.currentDate(), innerRoot.get(Student_.joiningDate)

				), 90);
		Predicate innerFinalPred = cb.and(datePredInner, cityPredinner);
		
		sq.where(innerFinalPred);
		
		
		Predicate totalMarkPred = cb.lessThan(root.get(Student_.totalMarks), ex);
		
		
		Predicate p1 = cb.and(cityPred, totalMarkPred, datePred);
		cq.where(p1);
		TypedQuery<Student> query = em.createQuery(cq);
		List<Student> lists=query.getResultList();
		
		

//
//lists.forEach(tuple -> {
//    System.out.printf("Name: %s, Salary: %s%n",
//            tuple.get(0, Double.class), tuple.get(1, String.class));
//});

		return query.getResultList();
		

	}

}
