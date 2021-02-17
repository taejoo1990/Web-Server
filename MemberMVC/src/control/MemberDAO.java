package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	
	
	Connection con;
	PreparedStatement psmt;
	ResultSet res;
	MemberBean mbean = new MemberBean();
	public void con() {
	
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
	
	//1. 데이터베이스에서 한 사람에 대한 회원정보를 저장.
	
	public void insertMember(MemberBean bean) {
		try {
			con();
			String sql ="insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
			psmt=con.prepareStatement(sql);
			psmt.setString(1 , mbean.getId());
			psmt.setString(2 , mbean.getPw1());
			psmt.setString(3 , mbean.getPw2());
			psmt.setString(4 , mbean.getGender());
			psmt.setString(5 , mbean.getEmail());
			psmt.setString(6 , mbean.getPhone());
			psmt.setString(7 , mbean.getAddr());
			psmt.setString(8 , mbean.getHobby());
			psmt.setString(9 , mbean.getAge());
			psmt.setString(10 , mbean.getInfo());
			psmt.setString(11 , mbean.getJob());
			
			//쿼리실행
			
			psmt.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//2. 모든 사용자의 정보를 가져오는 메소드
	
	public Vector<MemberBean> allSelectMember(){
		Vector<MemberBean> v= new Vector<MemberBean>();

		try {
			con();
			String sql="select * from member";
			psmt=con.prepareStatement(sql);
			
			res=psmt.executeQuery();
			
			while(res.next()) {
				MemberBean bean=new MemberBean();
				
				bean.setId(res.getString(1));
				bean.setPw1(res.getString(2));
				bean.setPw2(res.getString(3));
				bean.setGender(res.getString(4));
				bean.setEmail(res.getString(5));
				bean.setPhone(res.getString(6));
				bean.setAddr(res.getString(7));
				bean.setHobby(res.getString(8));
				bean.setAge(res.getString(9));
				bean.setInfo(res.getString(10));
				bean.setJob(res.getString(11));
				
				v.add(bean);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return v;
	}

	
	
		
		
}


