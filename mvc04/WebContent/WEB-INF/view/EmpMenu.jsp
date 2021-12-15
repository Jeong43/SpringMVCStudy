<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeMenu.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/menuStyle.css">
</head>
<body>

<!--------------------------
  EmpMenu.jsp
  - 메인 메뉴 페이지 구성(일반회원)
  - 로그아웃 기능 포함
--------------------------->

<div id="menu">
	<ul>
		<li> 
			<a href="emplist.action" class="menu"> 직원 리스트</a>
		</li>
		<li> 
			<a href="empregionlist.action" class="menu"> 지역 리스트</a>
		</li>
		<li> 
			<a href="empdepartmentlist.action" class="menu"> 부서 리스트</a>
		</li>
		<li> 
			<a href="emppositionlist.action" class="menu"> 직위 리스트</a>
		</li>
		<li> 
			<a href="logout.action" class="menu"> 로그아웃</a>
		</li>
	</ul>
</div>

</body>
</html>