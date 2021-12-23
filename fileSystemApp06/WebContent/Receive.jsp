<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	/* Receive.jsp */

	//String root = request.getRealPath("/");		//-- 예전 방식
	String root = pageContext.getServletContext().getRealPath("/");
	
	String savePath = root + "pds" + "\\" + "saveFile";
	
	File dir = new File(savePath);
	
	// 확인
	System.out.println(savePath);
	
	if(!dir.exists())
		dir.mkdirs();
	
	String encType = "UTF-8";		//-- 인코딩 방식
	int maxFileSize = 5*1024*1024;	//-- 최대 업로드 크기(5MB)
	
	try
	{
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, savePath, maxFileSize, encType, new DefaultFileRenamePolicy());
		//@ 데이터들이 쪼개져서 다중의(Multi) 조각(part)로 나뉘어져 있으므로... request 한 곳만 확인해서는 값을 알 수 없음.
		//　기존: 체리 10개를 한 바구니에... → 현재: 체리에 대한 단서를 여기저기에 나눠서...
		//　따라서 바구니(request)만 봐서는 알 수가 없고, 모든 단서(매개변수)들을 확인해야 알 수 있다.
		
		out.println("작성자: " + multi.getParameter("userName") + "<br>");
		out.println("제목: " + multi.getParameter("subject") + "<br>");
		out.println("서버에 저장된 파일명: " + multi.getFilesystemName("uploadFile") + "<br>");
		out.println("업로드한 파일명: " + multi.getOriginalFileName("uploadFile") + "<br>");
		out.println("파일 타입: " + multi.getContentType("uploadFile") + "<br>");
		
		File file = multi.getFile("uploadFile");
		if(file != null)
		{
			out.println("파일크기: " + file.length() + "<br>");
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}

	
%>