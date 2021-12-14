/*==========================
   SampleController.java
   - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegionUpdateFormController implements Controller
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

		Region region = new Region();
		
		try
		{
			region = dao.searchId(request.getParameter("regionId"));

			mav.addObject("region", region);
			mav.setViewName("/WEB-INF/view/RegionUpdateForm.jsp");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
}
