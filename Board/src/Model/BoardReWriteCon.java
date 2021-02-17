package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardReWriteCon
 */
@WebServlet("/BoardReWriteCon.do")
public class BoardReWriteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int ref= Integer.parseInt(req.getParameter("ref"));
		int re_step= Integer.parseInt(req.getParameter("re_step"));
		int re_level= Integer.parseInt(req.getParameter("re_level"));
		
		req.setAttribute("ref",ref );
		req.setAttribute("re_step",re_step );
		req.setAttribute("re_level",re_level );
		
		RequestDispatcher dis=req.getRequestDispatcher("BoardReWriteForm.jsp");
		dis.forward(req, res);
	}

}
