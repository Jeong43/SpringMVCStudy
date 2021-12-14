/*=================================
   MemberListController.java
   - 사용자 정의 컨트롤러
   - 리스트 출력 액션
   - DAO 객체에 대한 의존성 주입
     → setter 메소드 추가
=================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberListController implements Controller
{
	// ※ MemberDAO 객체에 대한 의존성 주입을 위한 준비
	// ① 인터페이스 형태의 데이터 타입을 취하는 속성 구성
	private IMemberDAO dao;

	// ② setter 구성
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}

	// ※ Controller 인터페이스의 메소드 오버라이딩
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		int count = 0;
		ArrayList<MemberDTO> lists = new ArrayList<MemberDTO>();
		
		try
		{
			count = dao.count();
			lists = dao.lists();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

		mav.setViewName("/WEB-INF/view/MemberList.jsp");
		mav.addObject("count", count);
		mav.addObject("lists", lists);
		
		return mav;
		
	}
}
