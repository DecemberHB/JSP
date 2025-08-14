package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper { //DB 호출 반복이므로 따로 유틸 클래스를 만들어서 관리 (상속성)
	
	
	protected Connection conn = null;
	protected PreparedStatement psmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	public Connection getConnection() throws NamingException, SQLException {
		
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/COLLEGE_USER");
		return ds.getConnection();
		
	}
	
	public void closeAll() throws SQLException {
		
		
		if(rs != null) {
			rs.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(psmt != null) {
			psmt.close();
			
		}
		if(conn != null ) {
			conn.close();
			
		}
	}
	
	

}
