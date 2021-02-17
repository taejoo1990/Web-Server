<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%><!-- Post 방식에서는 한글깨짐 방지 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post 방식 요청</title>
</head>
<body>
<!-- JSP 문법 작성 -->
<%
String strName=request.getParameter("name");
String strMajor=request.getParameter("major");

out.println("이름 :"+ strName+"<br/>");
out.println("학과 :"+ strMajor+"<hr/>");
%>
웹 브라우저 URL 주소 입력이 잘못 되었습니다.
</body>
</html>