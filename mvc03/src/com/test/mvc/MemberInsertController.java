/*=======================================
   MemberInsertController.java
   - 사용자 정의 컨트롤러
   - 회원 데이터 추가 액션 처리 클래스
   - DAO 객체에 대한 의존성 주입 준비
     → setter 메소드 추가
=======================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// 『implements Controller』 혹은 『extends AbstractController』
//-- 서블릿에서 HttpServlet 을 상속받은 서블릿 객체 역할
public class MemberInsertController implements Controller
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
		
		request.setCharacterEncoding("UTF-8");
		
		// ① 멤버 추가 준비
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		
		// ② 작업
		try
		{
			MemberDTO dto = new MemberDTO();
			dto.setName(name);
			dto.setTelephone(telephone);
			
			dao.add(dto);
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

		//mav.setViewName("/WEB-INF/view/MemberList.jsp");	// → X (뷰를 지정했으나 list 에 관한 정보 없음)
		mav.setViewName("redirect:memberlist.action");		// → O (컨트롤러를 통해 요청 → count, list 얻음)
		
		return mav;

	}

}
