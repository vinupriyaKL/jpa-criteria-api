package com.example.demo.Specification;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.AddressDetails;
import com.example.demo.model.AddressDetails_;
import com.example.demo.model.Student;
import com.example.demo.model.Student_;

public  class ProjectSpecification {

	  @PersistenceContext
	 
	  public static Specification<Student> getEmployeesByPhoneTypeSpec() {
	      return new Specification<Student>() { 
	          @Override
	          public Predicate toPredicate(Root<Student> root,
	                                       CriteriaQuery<?> cq,
	                                       CriteriaBuilder cb) {
	        	  

	            
  	  
//
//	              Predicate equalPredicate = criteriaBuilder.equal(root.get("firstName"), name);
//	              Predicate likePredicate = criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
//	              Predicate PredicateName=criteriaBuilder.and(equalPredicate,likePredicate);
//	              Predicate PredicateFinal=criteriaBuilder.and(PredicateName,criteriaBuilder.ge(root.get("id"), 1));
	        		ListJoin<Student, AddressDetails> stud_address_outer = root.join(Student_.addressDetails, JoinType.INNER);
	        		Predicate cityPred = cb.equal(stud_address_outer.get(AddressDetails_.city), "cbe");
	        		
//	        		Predicate p=cb.equal(root.get(Student_.id),"1");


	        		Predicate datePred = cb
	        				.greaterThan(cb.function("DATEDIFF", Integer.class, cb.currentDate(), root.get(Student_.joiningDate)

	        				), 90);


	        		Subquery<Double> sq = cq.subquery(Double.class);
	        		Root<Student> e5 = sq.from(Student.class);

	        		ListJoin<Student, AddressDetails> stud_address_inner = e5.join(Student_.addressDetails, JoinType.INNER);
	        		Expression<Double> ex = sq.select(cb.max(e5.<Double>get(Student_.totalMarks)));
	        		Predicate cityPredinner = cb.equal(stud_address_inner.get(AddressDetails_.city), "cbe");

	        		Predicate datePredInner = cb
	        				.greaterThan(cb.function("DATEDIFF", Integer.class, cb.currentDate(), e5.get(Student_.joiningDate)

	        				), 90);
	        		Predicate innerFinalPred=cb.and(datePredInner,cityPredinner);
	        		sq.where(innerFinalPred);
	        		
	        		Predicate totalMarkPred = cb.lessThan(root.get(Student_.totalMarks), ex);
	        		Predicate p1 = cb.and(cityPred, totalMarkPred, datePred);
	        	  
	        	  return p1;
	              
	          }
	      };
	  }
	  
	  
	  
	  
	  
}
