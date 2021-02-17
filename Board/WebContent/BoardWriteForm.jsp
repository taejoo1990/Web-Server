<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link type="text/css" rel="stylesheet" href="css/qnaboard.css" />
<body>
<center>
<h2>답변 게시글 입력하기</h2>
<form action="BoardWriteProcCon.do" method="post">
<table width="600" border="1" bordercolor="gray">
   <tr height="40">
       <td width="150" align="center">작성자</td>
       <td width="450" align="left"><input type="text" name="writer" size="60" style="border:none; background:transparent"></td>
   </tr>
   <tr height="40">
       <td width="150" align="center">제목</td>
       <td width="450" align="left"><input type="text" name="subject" size="60" style="border:none; background:transparent"></td>
   </tr>
   <tr height="40">
       <td width="150" align="center">이메일</td>
       <td width="450" align="left"><input type="text" name="email" size="60" style="border:none; background:transparent"></td>
   </tr>
   <tr height="40">
       <td width="150" align="center">비밀번호</td>
       <td width="450" align="left"><input type="password" name="password" size="60" style="border:none; background:transparent"></td>
   </tr>
   <tr height="40">
       <td width="150" align="center">글내용</td>
       <td width="450" align="left"><textarea rows="10" cols="60" name="contents" ></textarea>
   </tr>
   
   <tr height="40">
   		<td align="center" colspan="2">
   			<input type="submit" value="글쓰기">&nbsp;&nbsp;
   			<input type="reset"  value="다시작성">&nbsp;&nbsp;
   			<button onclick="location.href='BoardListCon.do'">전체 게시글 보기 </button>  
   		</td>
   	</tr>	  
</table>
</form>
</body>
</html>

<!-- link : 외부 문서를 연결시키는 태그 
     rel : 스타일 시트 파일 연결
     href : 연결할 곳의 주소(절대주소 상대주소 가능)-->