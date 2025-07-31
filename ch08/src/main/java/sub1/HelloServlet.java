package sub1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 서블릿 고유번호
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 생성될 때 실행 되는 초기화 메서드
		System.out.println("HelloServlet init...");
		//super.init();
	}

	@Override //중요 ** 사용자의 요청이 여기로 들어옴 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트 Get 요청 실행
		System.out.println("HelloServlet get 요청 !!!");

		//HTML 출력
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'/>"); // 
		writer.println("<title>HelloServlet</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h3>HelloServlet</h3>");
		writer.println("<a href='/ch08/servlet.jsp'> 서블릿 메인</a>");
		writer.println("<a href='/ch08/hello.do'> HelloServlet</a>");
		writer.println("<a href='/ch08/welcome.do'> welcomeServlet</a>");
		writer.println("<a href='/ch08/greeting.do'> GreetingServlet</a>");
		writer.println("</body>");
		writer.println("</html>"); 
	}

	@Override //중요 **
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet post 요청 !!!");
	}
}
