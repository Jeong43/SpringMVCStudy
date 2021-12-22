package com.test.mybatis;

import java.util.ArrayList;

public interface IStudentDAO
{
	public int add(StudentDTO dto);
	public ArrayList<StudentDTO> list();
	public int modify(StudentDTO dto);
	public int remove(int sid);
	
	public int count(int sid);
}
