package controller.college.student;

import java.io.IOException;
import java.util.List;

import dto.college.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService service = StudentService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 서비스에서 전체 학생 목록 조회
		List<StudentDTO> dtoList = service.findAll();

		// 2. JSP로 넘기기 위해 request에 데이터 저장
		req.setAttribute("dtoList", dtoList);

		// 3. forward로 JSP 호출
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/student/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용하지 않음
	}
}
