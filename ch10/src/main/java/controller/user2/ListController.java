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

@WebServlet("/user2/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 서비스 불러오기 
	private User2Service service = User2Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 요청 (findAll)
		List<User2DTO> dtoList = service.findAll();
		
		//request 공휴
		req.setAttribute("dtoList", dtoList);
		
		// 포워드 (화면 뿌리기)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user2/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
