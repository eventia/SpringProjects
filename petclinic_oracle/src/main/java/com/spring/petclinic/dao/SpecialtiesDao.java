package com.spring.petclinic.dao;
import java.util.ArrayList;

import com.spring.petclinic.dto.SpecialtiesDto;

public interface SpecialtiesDao {
	public ArrayList<SpecialtiesDto> vetselect_viewDao();
	public ArrayList<SpecialtiesDto> specialtieslistDao();
	
}
