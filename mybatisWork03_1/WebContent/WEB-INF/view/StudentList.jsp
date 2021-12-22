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


<script type="text/javascript">
	$(function()
	{
		$(".btnUpdate").click(function()
		{
			//alert("test");
			$("#title").text("회원 정보 수정");

			var mid = $(this).parents("tr").find("td:eq(0)").text();
			var name = $(this).parents("tr").find("td:eq(1)").text();
			var telephone = $(this).parents("tr").find("td:eq(2)").text();

			$("#mid").val(mid);
			$("#name").val(name);
			$("#telephone").val(telephone);

			$("form").attr("action", "memberupdate.action");
		});

		$(".btnDelete").click(
				function()
				{
					if (confirm("현재 선택한 데이터를 정말 삭제하시겠습니까?"))
					{
						$(location).attr("href",
								"memberdelete.action?mid=" + $(this).val());
					}
				});
	});
</script>

</head>
<body>


	<div class="container">
		<div class="panel-group">

			<br>
			<div class="panel panel-default">

				<div class="panel-heading">학생 정보 조회</div>

				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<td>SID</td>
								<td>NAME</td>
								<td>TELEPHONE</td>
								<!-- <td>관리</td> -->
							</tr>
						</thead>
						<tbody>
							<!--  
							<tr>
								<td>1</td>
								<td>장진하</td>
								<td>010-1111-1111</td>
							</tr>
							-->

							<c:forEach var="student" items="${list }">
								<tr>
									<td>${student.sid }</td>
									<td>${student.name }</td>
									<td>${student.tel }</td>
									<%-- 
									<td>
										<button type="button" class="btn btn-default btn-xs btnUpdate" value="${student.sid }">수정</button>
										<button type="button" class="btn btn-default btn-xs btnDelete" value="${student.sid }">삭제</button>
									</td> 
									--%>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>

</body>
</html>