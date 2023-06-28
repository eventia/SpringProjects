package com.spring.iot.dao;

import java.util.ArrayList;

import com.spring.iot.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String stdID);
	public void deleteDao(String bId);

}
