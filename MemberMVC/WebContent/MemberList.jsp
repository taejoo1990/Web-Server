<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <center>
<h2> 전체 회원 보기 </h2>
<table width="600" border="1">
 <tr height="40">
  <td width="120" align="center">아이디</td>
  <td width="120" align="center">이메일</td>
  <td width="120" align="center">전화번호</td>
  <td width="120" align="center">취미</td>
  <td width="120" align="center">직업</td>
 </tr>
 <c:forEach var="bean" items="${vec}">
 <tr height="40">
  <td width="120" align="center">${bean[id]}</td>
  <td width="120" align="center"><a href="MemberInfo.jsp?id = $[bean.email}]">${bean.email }</td>
  <td width="120" align="center">${bean.phone }</td>
  <td width="120" align="center">${bean.job }</td>
  <td width="120" align="center">${bean.hobby }</td>
 </tr>


 </c:forEach>
 </table>
 </center>
 

</body>
</html>