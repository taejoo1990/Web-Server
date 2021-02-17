<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,tr,td { border:1px solid gray}
	table{height : 500px;
		width: 700px;	
</style>

</head>
<body>
	<h1>게시판</h1>
	<center>
	<form action="BoardReUpdateConProc.do" method="post">
	<table >
	<tr>
		<td style="width: 100px; height: 50px;">${bean.num}</td>
		<td style="width: 550px; height: 50px;"><input type="text" name="subject" placeholder="${bean.subject}" /></td>
	</tr>
	<tr>
	<td style="width: 100px; height: 50px;"> 작성자 : </td>
	<td style="width: 550px; height: 50px;">${bean.writer }</td>
	</tr>

	<tr>
		<td style="width: 100px; height: 350px;"> 내용 </td>
		<td style="width: 550px; height: 350px;"><textarea rows="10" cols="60" placeholder="${bean.contents}"  name="contents" ></textarea></td>
	</tr>
	<tr>
		<td style="width: 170px; height: 50px;">비밀번호 : </td>
		<td style="width: 480px; height: 50px;"><input type="password" name="password"/></td>
	</tr>
	<tr style="text-align: center">
		 <input type="hidden" value="${bean.num }" name="num"/>
		 <input type="hidden" value="${bean.password }" name="oripassword" />
		 <td><input type="submit" value="수정"/></td>
		 <td><input type="reset" value="취소"/></td>
	</tr>
	</table>
	</center>
	</form>
</body>
</html>