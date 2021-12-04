package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemberDAO
{
	// 주 업무(core concern) 진행을 위한 메소드 선언
	//-- 멤버 추가, 화면 출력(①인원 수, ②전체 목록)
	public int add(MemberDTO dto) throws SQLException;
	public int count() throws SQLException;
	public ArrayList<MemberDTO> lists() throws SQLException;
}
