package Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**

 */
@WebServlet("/BoardReWriteProcCon.do")
public class BoardReWriteProcCon extends HttpServlet {
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
		
		req.setCharacterEncoding("UTF-8");
		
		String writer=req.getParameter("writer");
		String subject=req.getParameter("subject");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String contents=req.getParameter("contents");
		int ref= Integer.parseInt(req.getParameter("ref"));
		System.out.println(ref);
		
		bean.setWriter(writer);
		bean.setSubject(subject);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setContents(contents);
		bean.setRef(Integer.parseInt(req.getParameter("ref")));
		bean.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		bean.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		
		bdao.reInsertBoard(bean);
		
		
		RequestDispatcher dis=req.getRequestDispatcher("/BoardListCon.do");
		dis.forward(req, res);
		
	}

}
