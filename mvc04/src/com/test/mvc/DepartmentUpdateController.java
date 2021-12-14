/*==========================
   SampleController.java
   - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DepartmentUpdateController implements Controller
{
	private IDepartmentDAO dao;
		
	public void setDao(IDepartmentDAO dao)
	{
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		Department department = new Department();
		department.setDepartmentId(request.getParameter("departmentId"));
		department.setDepartmentName(request.getParameter("departmentName"));

		try
		{
			dao.modify(department);
			
			mav.setViewName("redirect:departmentlist.action");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
