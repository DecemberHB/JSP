<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 

	// 전송데이터 수신
	String id = request.getParameter("id"); // form에서 받는 데이터 "id", "pw"
	String pw = request.getParameter("pw");
	
	String path = application.getContextPath(); // 프로젝트 컨텍스트 경로 구하기 :  프로젝트 이름 컨텍스트 루트 (Contextroot)

	// 아이디가 abc123이고, 비밀번호가 1234 일 때 로그인 성공( 시나리오 )
	
	if(id.equals("abc123") && pw.equals("1234")){
		//회원이 맞을 경우 쿠키 생성

		Cookie cookie = new Cookie("username",id); // 키-값 쿠키 생성
		cookie.setMaxAge(60*3); // 쿠키 수명 선언 (현재 3분)
		cookie.setPath(path); // 쿠키 유효 범위 (루트범위 = 전역)
		
		Cookie cookie2 = new Cookie("userpass",pw);
		cookie2.setMaxAge(60*1);
		cookie2.setPath(path);
		
		// 응답 객체로 클라이언트 쿠키 전송
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		//리다이렉트(페이지이동)
		response.sendRedirect("./resultCookie.jsp");
		
	}else {
		//회원이 아닐 경우
		response.sendRedirect("../cookie.jsp");
	}




%>