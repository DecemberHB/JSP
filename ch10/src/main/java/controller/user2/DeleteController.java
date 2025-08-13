package controller.user2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User2Service;


@WebServlet("/user2/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	// 서비스호출
	private User2Service service = User2Service.INSTANCE; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// jsp에서 전달한 uid값 전달받기
		
		String uid = req.getParameter("uid");
		
		// 조회페이지로 넘어가기 (삭제 후)
		
		service.delete(uid);
		resp.sendRedirect("/ch10/user2/list.do");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
