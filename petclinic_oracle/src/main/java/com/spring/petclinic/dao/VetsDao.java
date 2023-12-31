package com.spring.petclinic.dao;
import java.util.ArrayList;

import com.spring.petclinic.dto.VetsDto;
import com.spring.petclinic.dto.VetspecialtiesDto;

public interface VetsDao {
	
	public ArrayList<VetsDto> vetslistDao();
	public ArrayList<VetspecialtiesDto> vetselectDao(int specialty_id);
	public VetsDto vetselect2Dao(int id);
	public ArrayList<VetsDto> vetselect3Dao(int id);
	
	public void vet_addDao(String first_name, String last_name);
	public void vet_deleteDao(String id);

}
