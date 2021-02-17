<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GET 방식 요청 - Submit</title>
</head>
<body>
<!-- JSP 문법 작성 -->
<%
String strName=request.getParameter("name");
String strMajor=request.getParameter("major");

out.println("이름 :"+ strName+"<br/>");
out.println("학과 :"+ strMajor+"<hr/>");
%><!-- <%%>를 자바코드라 한다 -->
</body>
</html>