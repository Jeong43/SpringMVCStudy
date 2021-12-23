<%@page import="java.io.DataInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	/* Receive.jsp */

	String contentType = request.getContentType();
	Enumeration e = request.getHeaderNames();
	
	out.println("■■■ 관찰 ■■■<br>");
	out.println("[[ 브라우저로부터 날아오는 헤더 정보들 ]]<br>");
	while (e.hasMoreElements())
	{
		String key = (String) e.nextElement();
		String value = request.getHeader(key);
	
		out.println(key + " " + value + "<br>");
	}
	
	out.println("[[ request로 넘어오는 데이터들 ]]<br>");
	DataInputStream di = new DataInputStream(request.getInputStream());
	String line = null;
	while ((line = di.readLine()) != null)
	{
		//@ "ISO-8859-1" 과 "UTF-8"은 같은 건데 표현방식만 다름 
		out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8") + "<br>");
	}
%>