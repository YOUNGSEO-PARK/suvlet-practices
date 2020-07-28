<%@page import="com.bit2020.emaillist.dao.EmaillistDao"%>
<%@page import="com.bit2020.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	//post 방식일 때는 encoding utf-8
	request.setCharacterEncoding("utf-8");

	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);	
	
	new EmaillistDao().insert(vo);
	
	response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=firstName %><br>
	<%=lastName %><br>
	<%=email %><br>
	
	<h1>성공적으로 등록되었습니다.</h1>
</body>
</html>