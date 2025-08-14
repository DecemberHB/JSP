package controller.Student;

import java.io.IOException;
import java.util.List;

import dto.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentService;

@WebServlet("/student/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private StudentService service = StudentService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 학생리스트보기
		
		List<StudentDTO> dtoList = service.findAll();
		req.setAttribute("dtoList", dtoList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/student/list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// index.jsp에서 로그인 정보를 받아옴(POST)
		String stdNo = req.getParameter("stdNo");
		String stdName = req.getParameter("stdName");
		
		StudentDTO studentDTO = service.findByIdAndName(stdNo, stdName);
		
		if(studentDTO != null) {
			//회원이맞으면 studentDTO 세션 저장
			HttpSession session = req.getSession();
			session.setAttribute("sessStudent", studentDTO);

			//메인이동
			
			resp.sendRedirect("/ErdCollege/?login=suess");
		}else {
			//메인이동
			resp.sendRedirect("/ErdCollege/?login=fail");

		}
	}

}
