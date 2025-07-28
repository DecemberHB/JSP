<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
    	// 전송 데이터 수신
    	String querString = request.getQueryString(); 
    	String id = request.getParameter("id"); // 데이터 수신 메서드
    	String pw = request.getParameter("pw"); // 데이터 수신 메서드
    	String name = request.getParameter("name"); // 숫자인데도 전달 받는 타입을문자열로 받아서 String
    	String birth = request.getParameter("birth"); // 숫자인데도 전달 받는 타입을문자열로 받아서 String
    	String gender = request.getParameter("gender"); // 숫자인데도 전달 받는 타입을문자열로 받아서 String
    	String address = request.getParameter("address");
    	
    	// 같은 이름의 파라미터값을 배열로 수신
    	String[] hobbies = request.getParameterValues("hobby"); // 숫자인데도 전달 받는 타입을문자열로 받아서 String

    %>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>결과페이지3</title>
	</head>
	<body>
		<h3>요청결과</h3>
		<p>
			아이디 : <%= id %><br/>
			비밀번호 : <%= pw %><br/>
			이름 : <%= name %><br/>
			생년월일 : <%= birth %><br/>
			성별 : <%= gender.equals("M")? "남자" : "여자" %><br/> 
			주소 : <%= address %><br/>
			취미 : <%
					for(String hobby:hobbies){
						out.println(hobby + ",");
					}
					
			
				 %><br/>
			
		</p>
	
		<a href="../1_request.jsp">뒤로가기</a>
		
	</body>
</html>