package controller.shop.customer;

import java.io.IOException;

import dto.shop.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;

@WebServlet("/shop/customer/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// cid 값은 사용자가 수정버튼을누르면서 cid 값을 넘겨준거임
		String cid = req.getParameter("cid");
		// 조회 요청
		CustomerDTO dto = service.findById(cid);
		System.out.println("수신 요청 수신: " + req.getParameter("cid"));

		// JSP에 전달
		req.setAttribute("customer", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/customer/modify.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDTO dto = new CustomerDTO();
		dto.setCid(req.getParameter("cid"));
		dto.setName(req.getParameter("name"));
		dto.setHp(req.getParameter("hp"));
		dto.setAddress(req.getParameter("address"));
		
		System.out.println("수정 요청 수신: " + req.getParameter("cid"));
		System.out.println("이름: " + req.getParameter("name"));
		System.out.println("휴대폰: " + req.getParameter("hp"));
		System.out.println("주소: " + req.getParameter("address"));
		service.modify(dto); // DB 업데이트

		resp.sendRedirect("/ch10/shop/customer/list.do"); // 목록 페이지로 이동
	}
}
