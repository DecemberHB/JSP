package controller.shop.product;

import java.io.IOException;
import java.util.List;
import dto.shop.CustomerDTO;
import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/list.do")
public class ListController extends HttpServlet{

	// 기본 형태 
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ProductListController 진입 성공");
		
		List<ProductDTO> dtoList = service.findAll();
		
		req.setAttribute("dtoList", dtoList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/product/list.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
