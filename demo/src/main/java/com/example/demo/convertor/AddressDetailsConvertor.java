package com.example.demo.convertor;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.AddressDetailsDTO;
import com.example.demo.model.AddressDetails;

public class AddressDetailsConvertor {
	public static AddressDetailsDTO entityToDto(AddressDetails addressDetails) {
		AddressDetailsDTO dto = new AddressDetailsDTO();
		dto.setAddressId(addressDetails.getAddressId());
		dto.setArea(addressDetails.getArea());
		dto.setCity(addressDetails.getCity());
		dto.setPincode(addressDetails.getPincode());

		return dto;

	}

	public static AddressDetails DtoToEntity(AddressDetailsDTO dto) {
		AddressDetails entity = new AddressDetails();
		entity.setAddressId(dto.getAddressId());
		entity.setArea(dto.getArea());
		entity.setCity(dto.getCity());
		entity.setPincode(dto.getPincode());
		return entity;

	}

	public static List<AddressDetailsDTO> entityToDto(List<AddressDetails> address) {
		return address.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

}
