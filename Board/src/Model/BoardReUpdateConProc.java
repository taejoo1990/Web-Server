package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardReUpdateConProc.do")
public class BoardReUpdateConProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		Boardbean bean = new Boardbean();
		
		
		bean.setNum(Integer.parseInt(req.getParameter("num")));
		bean.setSubject(req.getParameter("subject"));
		bean.setContents(req.getParameter("contents"));
		
		
		BoardDAO bdao=new BoardDAO();
		
		if(req.getParameter("password").equals(req.getParameter("oripassword"))) {
			bdao.correct(bean);
			RequestDispatcher dis= req.getRequestDispatcher("/BoardListCon.do");
			dis.forward(req, res);
		}else {
			RequestDispatcher dis= req.getRequestDispatcher("false.jsp");
			dis.forward(req, res);}
		}
	}

