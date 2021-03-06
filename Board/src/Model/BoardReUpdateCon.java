package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardReUpdateCon
 */
@WebServlet("/BoardReUpdateCon.do")
public class BoardReUpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(req.getParameter("num"));
		Boardbean bean = new Boardbean();
		BoardDAO bdao = new BoardDAO();
		
		bean = bdao.getOneBoard(num);
		
		req.setAttribute("bean", bean);
		req.setAttribute("num", num);
		RequestDispatcher dis = req.getRequestDispatcher("Correct.jsp");
		dis.forward(req, res);
	}

	
}
