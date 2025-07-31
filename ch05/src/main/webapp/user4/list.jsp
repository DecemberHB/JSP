<%@page import="vo.User4VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%


		String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "hyokong"; 
		String pass = "1234";
		
		
		List<User4VO> users = new ArrayList<>();
		
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM USER4";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
			User4VO vo4 = new User4VO();
			vo4.setName(rs.getString(1));
			vo4.setGender(rs.getString(2));
			vo4.setAge(rs.getInt(3));
			vo4.setAddr(rs.getString(4));
						
			users.add(vo4);
			
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
	</head>
	<body>
		<h3>User4 목록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
			<% for(User4VO user4VO : users){ %>
			<tr>
				<td><%= user4VO.getName() %></td>
				<td><%= user4VO.getGender() %></td>
				<td><%= user4VO.getAge() %></td>
				<td><%= user4VO.getAddr() %></td>
				<td>
					<!-- 수정하고자하는 사용자 아이디를 modify.jsp 로 전송 -->
					<a href="./modify.jsp?name=<%= user4VO.getName()%>">수정</a>
					<a href="./delete.jsp?name=<%= user4VO.getName()%>">삭제</a>
				</td>
			</tr>			
			<% } %>
		</table>		
	</body>
</html>