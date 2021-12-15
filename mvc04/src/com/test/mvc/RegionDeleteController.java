/*============================================================
   EmployeeDeleteController.java
   - 사용자 정의 컨트롤러
   - 직원 데이터 삭제 액션 수행
   - 이후 employeelist.action 을 다시 요청할 수 있도록 안내
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
   	 → 인터페이스 형태의 자료형을 속성으로 구성
   	 → setter 메소드 구성
============================================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegionDeleteController implements Controller
{
	private IRegionDAO dao;
	
	public void setDao(IRegionDAO dao)
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

		String regionId = request.getParameter("regionId");
		
		try
		{
			if (dao.delCheck(regionId) == 0)
				dao.remove(regionId);

			mav.setViewName("redirect:regionlist.action");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
