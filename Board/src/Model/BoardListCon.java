package Model;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardListCon.do")
public class BoardListCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//#1 한 화면에 보여지는 글의 갯수(10개씩 끊어서 보기)
		
		int pageSize=10;
		
		//전체보여지고 있는 페이지의 넘버값을 
		String pageNum=req.getParameter(getInitParameter("pageNum"));
	
		//pageNum이 null일 경우
		if(pageNum==null) {
			pageNum="1";
		}
		//총 게시글의 갯수를 지정할 변수
		int count = 0;
		
		//화면에 보여질 글 번호 숫자
		int number=0;
		
		//pageNum을 int로 변환
		int currentPage=Integer.parseInt(pageNum);
		
		//DAO객체
		BoardDAO bdao=new BoardDAO();
		
		//총 게시글의 숫자를 얻어오는 메서드
		count=bdao.getAllcount();
		
		//전체 보여지는 페이지의 시작번호
		int startRow=(currentPage-1)*pageSize+1; //DB에서 가져 올 시작번호
		//페이지의 마지막번호
		int endRow=currentPage*pageSize;
		
		//최신글 10개를 기준으로 게시글을 리턴받는 메서드 호출
		Vector<Boardbean> v=bdao.getAllBoard(startRow,endRow);
		
		//수정 삭제시 비번이 틀리면 메세지로 처리
		
		
		//글번호가져오기
		number = count-(currentPage-1)*pageSize;
		String msg=(String)req.getAttribute("msg");
		//jsp 페이지에서 사용할 값을 req에 붙여서 넘겨줌
		req.setAttribute("v", v);
		req.setAttribute("number",number);
		req.setAttribute("pageSize", pageSize);
		req.setAttribute("count", count);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("msg", msg);
		
		RequestDispatcher dis=req.getRequestDispatcher("boardList.jsp");
		dis.forward(req, res);
		
		
		
	}
	
}
