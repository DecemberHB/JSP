package controller.shop.product;

import java.io.IOException;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 서비스 객체 가져오기
	
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 가져올 데이터가 없고 사용자에게 등록하기 화면만 보여주기만 하면됨
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/product/register.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pno = req.getParameter("pno");
		String pname = req.getParameter("pname");
		String stock = req.getParameter("stock");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		
		System.out.println("들고온 데이터 조회" +pno + pname + stock + price + company);
		
		ProductDTO dto = new ProductDTO();
	
		dto.setPno(pno);
		dto.setPname(pname);
		dto.setStock(stock);
		dto.setPrice(price);
		dto.setCompany(company);
		service.register(dto);
		
		System.out.println("추가한 데이터 조회" +pno + pname + stock + price + company);

		
		resp.sendRedirect("/ch10/shop/product/list.do");
		
	}

}
