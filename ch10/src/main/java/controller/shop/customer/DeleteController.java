package controller.shop.customer;

import java.io.IOException;

import dto.shop.CustomerDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;


@WebServlet("/shop/customer/delete.do")
public class DeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//cid값 넘겨받기
		String cid = req.getParameter("cid");
		//조회요청
		service.delete(cid);
		resp.sendRedirect("/ch10/shop/customer/list.do"); // 목록 페이지로 이동
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
