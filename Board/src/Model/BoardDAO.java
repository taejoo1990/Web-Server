package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import org.apache.catalina.connector.Response;


public class BoardDAO {

	
	Connection con;
	PreparedStatement psmt;
	ResultSet res;
	Boardbean bbean = new Boardbean();
	
	public void getCon() {
	
		try {
			Context initContext = (Context) new InitialContext();
			// JNDI를 이용하여 객체새엇ㅇ
			Context envContext=(Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/orcl");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//#1. 전체 게시글 갯수
	public int getAllcount() {
		getCon();
		int count=0;
		try {
			
			String sql = "select count(*) from board";
			psmt=con.prepareStatement(sql);
			res=psmt.executeQuery();
			
			if(res.next()) {
			count=res.getInt(1);
			}
			
		} catch (Exception e) {
			
		}
		return count;
	}


	
	//#2. 화면에 보여질 데이터 10개씩 추출해서 보여주기
	
	public Vector<Boardbean> getAllBoard(int StartRow,int endRow){
		getCon();
		Vector<Boardbean> v = new Vector<Boardbean>();
		try {
			
			String sql="SELECT * FROM "
					+ "(SELECT A.* ,Rownum Rnum FROM "
					+ "(SELECT * FROM board ORDER BY ref desc, re_step asc) A) "
					+ "WHERE Rnum >= ? and Rnum <= ?";

			psmt=con.prepareStatement(sql);
			psmt.setInt(1, StartRow);
			psmt.setInt(2, endRow);
			
			res=psmt.executeQuery();
			
			while(res.next()) {
				Boardbean bean = new Boardbean();
				
				bean.setNum(res.getInt(1));
				bean.setWriter(res.getString(2));
				bean.setEmail(res.getString(3));
				bean.setSubject(res.getString(4));
				bean.setPassword(res.getString(5));
				bean.setReg_date(res.getDate(6).toString());
				bean.setRef(res.getInt(7));
				bean.setRe_step(res.getInt(8));
				bean.setRe_level(res.getInt(9));
				bean.setReadcount(res.getInt(10));
				bean.setContents(res.getString(11));
				
				v.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	
	}
	public void InsertBoard(Boardbean bean) {
		
			int ref=0;
			int re_step=1; //새 글 ==부모글
			int re_level=1;
			
		try {
		
			getCon();
			String refsql="select max(ref) from board";
			psmt=con.prepareStatement(refsql);
			res=psmt.executeQuery();
			if(res.next()) {
				ref=res.getInt(1)+1; //새 글이 생겼으니 맥스값이 1증가해야 한다.
			}
			
			
			String sql ="insert into board values(BOARD_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, bean.getWriter());
			psmt.setString(2, bean.getEmail());
			psmt.setString(3, bean.getSubject());
			psmt.setString(4, bean.getPassword());
			psmt.setInt(5, ref);
			psmt.setInt(6, re_step );
			psmt.setInt(7, re_level);
			psmt.setString(8, bean.getContents());
			
			psmt.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	public Boardbean getOneBoard(int num) {
		
		Boardbean bean = new Boardbean();
		try {
			
			getCon();

			String sql = "update board set readcount = readcount+1 where num=? ";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.executeUpdate();
			
			String sql2 = "select * from board where num=? ";
			psmt=con.prepareStatement(sql2);
			psmt.setInt(1, num);
			res=psmt.executeQuery();
			
			if(res.next()) {
			
			bean.setNum(res.getInt(1));
			bean.setWriter(res.getString(2));
			bean.setEmail(res.getString(3));
			bean.setSubject(res.getString(4));
			bean.setPassword(res.getString(5));
			bean.setReg_date(res.getDate(6).toString());
			bean.setRef(res.getInt(7));
			bean.setRe_step(res.getInt(8));
			bean.setRe_level(res.getInt(9));
			bean.setReadcount(res.getInt(10));
			bean.setContents(res.getString(11));
			
			}
					
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public void reInsertBoard(Boardbean bean) {
		try {	
			
			getCon();
			int ref=bean.getRef();
			int re_step=bean.getRe_step();
			int re_level=bean.getRe_level();
			
			String array = "update board set re_level=re_level+1 where ref=? and re_level>?";
			psmt=con.prepareStatement(array);
			psmt.setInt(1, ref);
			psmt.setInt(2, re_level);
			psmt.executeUpdate();
			
			String sql ="insert into board values(BOARD_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, bean.getWriter());
			psmt.setString(2, bean.getEmail());
			psmt.setString(3, bean.getSubject());
			psmt.setString(4, bean.getPassword());
			psmt.setInt(5, bean.getRef());
			psmt.setInt(6, bean.getRe_step()+1 );
			psmt.setInt(7, bean.getRe_level()+1);
			psmt.setString(8, bean.getContents());
			
			psmt.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void correct(Boardbean bean) {
		
		getCon();
		
		try {
			String sql = "update board set subject=?,contents=? where num=?";
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, bean.getSubject());
			psmt.setString(2, bean.getContents());
			psmt.setInt(3, bean.getNum());
			
			psmt.executeUpdate();
			
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void deleteOneBoard(int num) {
		
		getCon();
		String sql = "delete from board where num=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, num);
			
			psmt.executeQuery();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



   