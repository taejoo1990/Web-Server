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
		//#1 �� ȭ�鿡 �������� ���� ����(10���� ��� ����)
		
		int pageSize=10;
		
		//��ü�������� �ִ� �������� �ѹ����� 
		String pageNum=req.getParameter(getInitParameter("pageNum"));
	
		//pageNum�� null�� ���
		if(pageNum==null) {
			pageNum="1";
		}
		//�� �Խñ��� ������ ������ ����
		int count = 0;
		
		//ȭ�鿡 ������ �� ��ȣ ����
		int number=0;
		
		//pageNum�� int�� ��ȯ
		int currentPage=Integer.parseInt(pageNum);
		
		//DAO��ü
		BoardDAO bdao=new BoardDAO();
		
		//�� �Խñ��� ���ڸ� ������ �޼���
		count=bdao.getAllcount();
		
		//��ü �������� �������� ���۹�ȣ
		int startRow=(currentPage-1)*pageSize+1; //DB���� ���� �� ���۹�ȣ
		//�������� ��������ȣ
		int endRow=currentPage*pageSize;
		
		//�ֽű� 10���� �������� �Խñ��� ���Ϲ޴� �޼��� ȣ��
		Vector<Boardbean> v=bdao.getAllBoard(startRow,endRow);
		
		//���� ������ ����� Ʋ���� �޼����� ó��
		
		
		//�۹�ȣ��������
		number = count-(currentPage-1)*pageSize;
		String msg=(String)req.getAttribute("msg");
		//jsp ���������� ����� ���� req�� �ٿ��� �Ѱ���
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
