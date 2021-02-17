package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberJoinProc2
 */
@WebServlet("/MemberlistCon.do")
public class MemberJoinProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MemberDAO mdao= new MemberDAO();
		
		Vector<MemberBean> v= mdao.allSelectMember();
		
		req.setAttribute("vec", v); //웹에서 el로 사용하려면 일반변수로 안 됨
		RequestDispatcher dis=req.getRequestDispatcher("MemberList.jsp");
		dis.forward(req, res);
		
}
}