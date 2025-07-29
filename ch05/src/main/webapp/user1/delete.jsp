<%@page import="vo.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 전송 데이터 수신
String user_id = request.getParameter("user_id");
String host = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hyokong";
String pass = "1234";

try {

		// 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 데이터베이스 접속		
		Connection conn = DriverManager.getConnection(host, user, pass);
	
	  PreparedStatement psmt = conn.prepareStatement("DELETE FROM USER1 WHERE USER_ID=?");

	  psmt.setString(1, user_id);
	  psmt.executeUpdate();
	  
	  psmt.close();
	  conn.close();
} catch (Exception e) {
	e.printStackTrace();
	
}

// 목록이동
response.sendRedirect("./list.jsp");
%>
