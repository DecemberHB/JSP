<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.User1VO"%>  <%-- 사용자 정보 저장을 위한 VO (Value Object) 클래스 import --%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	// 1. DB 접속 정보 설정
	String host = "jdbc:oracle:thin:@localhost:1521:xe";  // 오라클 DB 접속 URL
	String user = "hyokong";  // DB 계정 ID
	String pass = "1234";     // DB 계정 비밀번호

	// 2. 사용자 목록을 담을 리스트 생성
	List<User1VO> users = new ArrayList<>();
	
	try {
		// 3. 오라클 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 4. DB 연결
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 5. SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
		
		// 6. 실행할 SQL 문
		String sql = "SELECT * FROM USER1";
		
		// 7. SQL 실행 후 결과 저장
		ResultSet rs = stmt.executeQuery(sql);
		
		// 8. 결과셋 반복 → User1VO 객체로 저장 후 리스트에 추가
		while(rs.next()){
			User1VO vo = new User1VO();
			vo.setUser_id(rs.getString(1));  // 첫 번째 컬럼: user_id
			vo.setName(rs.getString(2));     // 두 번째 컬럼: name
			vo.setHp(rs.getString(3));       // 세 번째 컬럼: hp
			vo.setAge(rs.getInt(4));         // 네 번째 컬럼: age

			users.add(vo);  // 리스트에 vo 객체 추가
		}

		// 9. 자원 정리
		rs.close();
		stmt.close();
		conn.close();
		
	} catch(Exception e){
		e.printStackTrace();  // 에러 발생 시 콘솔에 출력
	}

%>
