/*==========================
   SampleController.java
   - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PositionUpdateController implements Controller
{
	private IPositionDAO dao;
	
	public void setDao(IPositionDAO dao)
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
		
		Position position = new Position();
		position.setPositionId(request.getParameter("positionId"));
		position.setPositionName(request.getParameter("positionName"));
		position.setMinBasicPay(Integer.parseInt(request.getParameter("minBasicPay")));
		
		try
		{
			dao.modify(position);
			
			mav.setViewName("redirect:positionlist.action");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
