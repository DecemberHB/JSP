package controller.user1;

import java.io.IOException;
import java.util.List;

import dto.User1DTO;
import dto.shop.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private User1Service service = User1Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// uid 값 전달 받기
		String uid = req.getParameter("uid");
		// 조회 요청
		User1DTO dto = service.findById(uid);
		System.out.println("수신 요청 수신: " + req.getParameter("uid"));
		
		//JSP 전달
		req.setAttribute("user1", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user1/modify.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User1DTO dto = new User1DTO();
		dto.setUid(req.getParameter("uid"));
		dto.setName(req.getParameter("name"));
		dto.setHp(req.getParameter("hp"));
		dto.setAge(req.getParameter("age"));
		
		System.out.println("수정 요청 수신: " + req.getParameter("uid"));
		System.out.println("이름: " + req.getParameter("name"));
		System.out.println("휴대폰: " + req.getParameter("hp"));
		System.out.println("나이: " + req.getParameter("age"));
		service.modify(dto); // DB 업데이트

		resp.sendRedirect("/ch10/user1/list.do"); // 목록 페이지로 이동
	
	}
	
}