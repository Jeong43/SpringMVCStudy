/*==================
  Sample.java
  - 컨트롤러 객체
===================*/

package com.test.mybatis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sample
{
	@RequestMapping(value = "/hello.action", method= RequestMethod.GET)
	public String hello(Model model)
	{
		model.addAttribute("message", "Hello Spring annotation + MVC + mybatis Framework");
		
		// setviewname
		return "/WEB-INF/view/Hello.jsp";
		
		
	}
}

// 블라인드 여부 확인 후 띄워주도록
