/*=================================================
  #22. AjaxController.java
   - 사용자 정의 컨트롤러
   - 직위에 따른 기본급 반환
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
     → 인터페이스 형태의 자료형을 속성으로 구성
     → setter 메소드 준비
=================================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AjaxController implements Controller
{
	private IEmployeeDAO dao;
	
	public void setDao(IEmployeeDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();

		// 세션 처리에 따른 추가 구성 ------------------------------------------------
		HttpSession session = request.getSession();
		if (session.getAttribute("name")==null)				//-- 로그인을 하지 못한 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if (session.getAttribute("admin")==null)		//-- 로그인은 되었지만 관리자가 아닌 상황
		{
			mav.setViewName("redirect:logout.action");
			return mav;
			//-- 로그인은 되어있지만 일반직원으로 로그인 되어있는 상황이므로
			//   로그아웃 액션 처리를 하여 다시 관리자로 로그인할 수 있도록 처리
		}
		
		// ------------------------------------------------ 세션 처리에 따른 추가 구성 
		
		String positionId = request.getParameter("positionId");
		int result = 0;
		
		try
		{
			result = dao.getMinBasicPay(positionId);
			mav.addObject("result", result);
			mav.setViewName("/WEB-INF/view/Ajax.jsp");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
