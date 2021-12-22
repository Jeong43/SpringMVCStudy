package com.test.mybatis;

import java.util.ArrayList;

public interface IGradeDAO
{
	public int add(GradeDTO dto);
	public ArrayList<GradeDTO> list();
	public int modify(GradeDTO dto);
	public int remove(int sid);
}
