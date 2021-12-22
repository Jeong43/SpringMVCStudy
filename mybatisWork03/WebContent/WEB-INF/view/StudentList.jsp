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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StudnetList.jsp</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

</head>
<body>

	<div class="panel title">
		<h1>성적 관리(Spring MVC + Annotation + Mybatis 버전)</h1>
	</div>

	<!-- 메인 메뉴 영역 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="" class="navbar-brand">HOME</a>
			</div>
			
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="studentlist.action">학생 관리 <span class="sr-only">(current)</span></a>
					</li>
					<li>
						<a href="gradelist.action">성적 관리</a>
					</li>
				</ul>
			</div> <!-- close .collapse navbar-collapse -->
			
		</div><!-- close .container-fluid -->
	</nav>
	
	
	<!-- 콘텐트 영역 -->
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading row">
					<span class="col-md-3" style="font-size: 17pt; font-weight: bold;">
						학생 리스트 출력
					</span>
					<span class="col-md-9">
						<a href="studentinsertform.action" id="btnAdd" role="button"
						class="btn btn-success btn-xs" style="vertical-align: bottom;">
						학생 추가
						</a>
					</span>
				</div> <!-- close .panel-heading row -->
				
				<div class="panel-body">
					<!-- 전체 학생 수 <span class="badge">100</span> -->
					전체 학생 수 <span class="badge">${count }</span>
				</div>
				
				<div class="panel-body">
					<table class="table table-hover table-striped">
						<thead>
							<tr class="trTitle">
								<th>번호</th>
								<th>이름</th>
								<th>전화번호</th>
								<th>성적 입력 여부</th>
								<th>수정 및 삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${list }">
							<tr>
								<th>${student.sid }</th>
								<th>${student.name }</th>
								<th>${student.tel }</th>
								
								<c:if test="${student.sub==0 }">
								<th>미입력</th>
								</c:if>
								<c:if test="${student.sub==1 }">
								<th>입력완료</th>
								</c:if>
								
								<th>
									<button class="btn btn-success" value="${student.sid }">수정</button>
									<button class="btn btn-danger" value="${student.sid }">삭제</button>
								</th>
							</tr>
							</c:forEach>
							
							
							<!--
							<tr>
								<th>1</th>
								<th>정미화</th>
								<th>010-9999-9999</th>
								<th>0</th>
								<th>
									<button class="btn btn-success">수정</button>
									<button class="btn btn-danger">삭제</button>
								</th>
							</tr>
							<tr>
								<th>2</th>
								<th>채지윤</th>
								<th>010-6666-6666</th>
								<th>0</th>
								<th>
									<button class="btn btn-success">수정</button>
									<button class="btn btn-danger">삭제</button>
								</th>
							</tr>
							-->
							
						</tbody>
					</table>
				</div>
				
			</div> <!-- close .panel panel-default -->
		</div> <!-- close .panel-group -->
	</div> <!-- close .container -->

</body>
</html>