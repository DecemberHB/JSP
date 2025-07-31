package controller.user1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/list.do") //주소 
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User1Service service = User1Service.getInstance(); // 서비스 생성 및 호출
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		// 데이터 조회 서비스의 -> findAll로 이동해서 -> 데이터처리 DAO
		List<User1DTO> dtoList = service.findAll();
		
		// request 객체로 데이터 공유  (DAO 에서 생성)List<User1DTO> dtoList = new ArrayList<>(); (DAO 결과값 : dtoList.add(dto);)
		req.setAttribute("dtoList", dtoList);
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user1/list.jsp"); // 해당 페이지를 포워드 가져와라
		dispatcher.forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	
}