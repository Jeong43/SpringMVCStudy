<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	String appRoot = "/";
	appRoot = pageContext.getServletContext().getRealPath(appRoot);
	//--==>> C:\SpringMVCStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\fileSystemApp01\
	// 물리적 실제 파일의 위치와, 서버에 올라가서 실행되는 파일의 위치가 다름.

	File newFile = new File(appRoot, "data/test.txt");
	//--==>> C:\SpringMVCStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\fileSystemApp01\data\test.txt
	// 이 경로를 가진 파일 객체가 만들어진 것일 뿐, 실제 파일이 생성된 것은 아님.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppRoot.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
</head>
<body>

<div>
	<h1>관찰</h1>
	<hr />
</div>

<div>
	<h2>웹 어플리케이션 루트: <%=appRoot %></h2>
	<h2>생성할 파일의 위치: <%=newFile %></h2>
</div>

</body>
</html>