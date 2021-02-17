<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <style>
  
  	table,tr,td{border:1px solid gray;}
    #container {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 10%;   /* 테두리와 내용 사이의 패딩 여백 */
    }
     
    #list {
      text-align: center;
    }
   
    #write {
      text-align: right;
    }
     
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;/*애니메이션의 이름*/
      animation-duration: 1.5s;/*애니메이션의 동작 시간('1s','0.5s'와 같은 형식으로 지정)*/
      animation-timing-function: ease; /*애니메이션의 타이밍 : 시작과 종료를 부드럽게*/
      animation-iteration-count: infinite; /* 애니메이션의 동작 회수('infinite'를 지정하면 무한 반복)*/
      /* 위 속성들을 한 줄로 표기하기 */
      /* -webkit-animation: blink 1.5s ease infinite; */
    }
     
    /* 애니메이션 지점 설정하기 */
    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      /* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
    }
  </style>
	
</head>
<body>
	<center>
	<h1>게시판</h1>
	<table class="table">
	<thead>
	<tr>
		<td style="width: 100px; height: 50px;">${bean.num}</td>
		<td style="width: 550px; height: 50px;"> ${bean.subject} </td>
	</tr>
	</thead>
	<tr>
		<td style="width: 100px; height: 50px;">작성자 : </td>
		<td style="width: 550px; height: 50px;">${bean.writer }</td>
	</tr>
	<tr>
		<td style="width: 100px; height: 350px;"> 내용 </td>
		<td style="width: 550px; height: 350px;"> ${bean.contents }</td>
	</tr>
	<tr style="text-align: center" class="table">
	<tbody>
		<td colspan=4><input type="button" value="답글" onclick="location.href='BoardReWriteCon.do?num=${bean.num }&ref=${bean.ref }&re_step=${bean.re_step }&re_level=${bean.re_level }'"> &nbsp; 
		<input type="button" value="수정" onclick="location.href='BoardReUpdateCon.do?num=${bean.num }'"> &nbsp; 
		<input type="button" value="삭제" onclick="location.href='BoardReDeleteCon.do?num=${bean.num }'"> &nbsp; 
		<button onclick="location.href='BoardListCon.do'">전체 게시글 보기 </button>  </td>
		</tbody>
	</tr>
	</table>

</center>
</body>
</html>