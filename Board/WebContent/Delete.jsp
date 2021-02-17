<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<form action="BoardDeleteProcCon.do">
	<input type="password" name="password" />
	 <input type="hidden" value="${bean.num }" name="num"/>
	<input type="password" name="oripassword" value="${bean.password }" hidden />
	<input type="submit" value="삭제" />
	<input type="reset" value="취소" />
	</form>
	</center>

</body>
</html>