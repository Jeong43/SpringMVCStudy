/*==========================
   SampleController.java
   - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PositionListController implements Controller
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

		ArrayList<Position> positionList = new ArrayList<Position>();
		
		try
		{
			positionList = dao.list();
			
			mav.addObject("positionList", positionList);
			mav.setViewName("/WEB-INF/view/PositionList.jsp");
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
