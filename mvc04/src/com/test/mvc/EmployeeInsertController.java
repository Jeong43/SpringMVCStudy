/*============================================================
   EmployeeInsertController.java
   - 사용자 정의 컨트롤러
   - 직원 데이터 입력 액션 수행
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

public class EmployeeInsertController implements Controller
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
		
		// 데이터 수신
		Employee employee = new Employee();
		
		try
		{
			employee.setName(request.getParameter("name"));
			employee.setSsn1(request.getParameter("ssn1"));
			employee.setSsn2(request.getParameter("ssn2"));
			employee.setBirthday(request.getParameter("birthday"));
			employee.setLunar(Integer.parseInt(request.getParameter("lunar")));
			employee.setTelephone(request.getParameter("telephone"));
			employee.setDepartmentId(request.getParameter("departmentId"));
			employee.setPositionId(request.getParameter("positionId"));
			employee.setRegionId(request.getParameter("regionId"));
			employee.setBasicPay(Integer.parseInt(request.getParameter("basicPay")));
			employee.setExtraPay(Integer.parseInt(request.getParameter("extraPay")));
			
			dao.employeeAdd(employee);
			
			// check~!!!
			mav.setViewName("redirect:employeelist.action");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;

	}
}
