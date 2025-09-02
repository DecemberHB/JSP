package jboard.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jboard.service.UserService;

@WebServlet("/user/check.do")
public class CheckUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String col = req.getParameter("col");
		String value = req.getParameter("value");
		
		int count = userService.getUserCount(col, value);
		
		
		// 사용 가능한 이메일이면 인증코드 전송 서비스 요청
		if(col.equals("email") && count == 0) {
			
			// 생성된 인증코드 이메일 전송 후 반환 서비스 호출
			String code = userService.sendEmailCode(value);	
			
			// 세션 저장 -> 방금 반환된 세션을 내 세션에 저장하는것
			HttpSession session = req.getSession();
			session.setAttribute("sessAuthCode", code);			
		}		
		
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("count", count);		
		
		// JSON 출력 - 브라우저 주소창에 http://localhost:8080/jboard/user/check.do?col=uid&value=a101 테스트 확인
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("code");	// 사용자가 registet.jsp에서 보내준값
		//System.out.println(code);
		
		// 인증코드 일치 여부 확인 doget에서 저장한 세션을 비교
		HttpSession session = req.getSession();
		String sessAuthCode = (String) session.getAttribute("sessAuthCode");
		boolean isMatched = sessAuthCode.equals(code);
		// 아래의 코드 변경함 0902 
//		int result = 0; // boolean
//		
//		if(sessAuthCode.equals(code)) { // 구조는 {"result":1} 
//			result = 1;
//		}else {
//			result = 0;
//		}		
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("isMatched", isMatched);
		
		// JSON 출력
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print(json);
	}

}