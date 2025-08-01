package controller.shop.product;

import java.io.IOException;

import dto.shop.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 서비스 호출
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pno = req.getParameter("pno");
		
		//조회
		//int pno = Integer.parseInt(request.getParameter("pno"));

	   // ProductDTO dto =  service.findById(pno);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
