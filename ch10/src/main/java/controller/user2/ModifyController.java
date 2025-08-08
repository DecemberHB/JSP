package controller.user2;

import java.io.IOException;
import java.util.List;

import dto.User2DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User2Service;

@WebServlet("/user2/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 서비스 불러오기 
	private User2Service service = User2Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// uid 값 전달 받기
		String uid = req.getParameter("uid");
		// 조회 요청
		User2DTO dto = service.findById(uid);
		
		//JSP 전달
		req.setAttribute("user2", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user2/modify.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User2DTO dto = new User2DTO();
		dto.setUid(req.getParameter("uid"));
		dto.setUid(req.getParameter("name"));
		dto.setUid(req.getParameter("birth"));
		dto.setUid(req.getParameter("addr"));
		
		service.modify(dto);
		resp.sendRedirect("/ch10/user2/list.do");
		
		
	}

}
