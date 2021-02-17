package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardInfoControl.do")
public class BoardInfoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		Boardbean bean = new Boardbean();
		BoardDAO bdao = new BoardDAO();
		System.out.println(req.getParameter("num"));
		int num=Integer.parseInt(req.getParameter("num"));
		
		bean = bdao.getOneBoard(num);
		req.setAttribute("bean", bean);
		
		RequestDispatcher ris= req.getRequestDispatcher("detailPage.jsp");
		ris.forward(req, res);
		
		
	}
}
