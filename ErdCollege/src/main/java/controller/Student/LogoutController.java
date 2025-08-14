package controller.Student;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/logout.do")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	//a 태그는 get
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.removeAttribute("sessStudent"); //서비스 필요없슴
		session.invalidate();
		
		//메인이동
		
		resp.sendRedirect("/ErdCollege/?logout=success");
		
	}

}
