/*=======================
   IStudentDAO.java
   - 인터페이스
=======================*/

package com.test.mybatis;

import java.util.ArrayList;

public interface IStudentDAO
{
	// 인원수 확인
	public int count();
	
	// 학생 리스트(목록) 확인
	public ArrayList<StudentDTO> list();
	
	// 학생 데이터 추가
	public int add(StudentDTO dto);
	
	// 학생 데이터 확인
	public StudentDTO search(String sid);
	
	// 학생 데이터 수정
	public int modify(StudentDTO dto);
	
	// 학생 데이터 삭제
	public int remove(String sid);
	
}
