package control;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/proc.do")
public class MemberJoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqPro(req, res);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberBean bean= new MemberBean();
		bean.setId(req.getParameter("id"));
		String pw1=req.getParameter("pw1");
		String pw2=req.getParameter("pw2");
		bean.setGender(req.getParameter("gender"));
		bean.setEmail(req.getParameter("email"));
		bean.setPhone(req.getParameter("phone"));

		
		//다중선택
		String[] arr=req.getParameterValues("hobby");
		String data="";
		
		for(String str:arr) {
			data+=str+" "; //데이터를 스트림처리하여 data에 저장
			
		}
		bean.setHobby(data);
		bean.setAge(req.getParameter("age"));
		bean.setAddr(req.getParameter("addr"));
		bean.setInfo(req.getParameter("info"));
		bean.setJob(req.getParameter("job"));
		
		if(pw1.equals(pw2)) {
			MemberDAO mdao=new MemberDAO();
			mdao.insertMember(bean);
			
			RequestDispatcher dis=req.getRequestDispatcher("MemberlistCon.do");
			dis.forward(req, res);
		}else {
			req.setAttribute("msg", "패스워드가 일치하지 않습니다.");
			RequestDispatcher dis=req.getRequestDispatcher("LoginError.jsp");
			dis.forward(req, res);
		}
	}
}
