package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardWriteProcCon.do")
public class BoardWriterProcCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqProc(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqProc(req, res);
	}

	protected void reqProc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Boardbean bean = new Boardbean();
		req.setCharacterEncoding("UTF-8");
		
		bean.setWriter(req.getParameter("writer"));
		bean.setSubject(req.getParameter("subject"));
		bean.setEmail(req.getParameter("email"));
		bean.setPassword(req.getParameter("password"));
		bean.setContents(req.getParameter("contents"));
		
		BoardDAO mbdao=new BoardDAO();
		
		mbdao.InsertBoard(bean);
		RequestDispatcher dis=req.getRequestDispatcher("/BoardListCon.do");
		dis.forward(req, res);
		
	}
}
