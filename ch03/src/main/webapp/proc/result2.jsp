<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
    	// 전송 데이터 수신
    	String querString = request.getQueryString(); 
    	String uid = request.getParameter("uid"); // 데이터 수신 메서드
    	String name = request.getParameter("name"); // 데이터 수신 메서드
    	String birth = request.getParameter("birth"); // 숫자인데도 전달 받는 타입을문자열로 받아서 String
   
    %>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>결과페이지1</title>
	</head>
	<body>
		<h3>요청결과</h3>
		<p>
			쿼리스트링 : <%= querString %><br/>
			아이디 : <%= uid %><br/>
			이름 : <%= name %><br/>
			생년월일 : <%= birth %><br/>
		</p>
	
		<a href="../1_request.jsp">뒤로가기</a>
		
	</body>
</html>