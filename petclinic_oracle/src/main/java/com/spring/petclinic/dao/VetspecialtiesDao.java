package com.spring.petclinic.dao;
import java.util.ArrayList;

import com.spring.petclinic.dto.VetspecialtiesDto;

public interface VetspecialtiesDao {
	
	public void vetspec_deleteDao(String id);
	public void vetspec_addDao(String vet_id, String specialty_id);
	public ArrayList<VetspecialtiesDto> vetspeslistDao();
	
}
