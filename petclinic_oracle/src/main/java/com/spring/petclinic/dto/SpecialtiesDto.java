package com.spring.petclinic.dto;

public class SpecialtiesDto {
	
	private String id;
	private String name;
	
	public SpecialtiesDto() {	}
	public SpecialtiesDto(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
