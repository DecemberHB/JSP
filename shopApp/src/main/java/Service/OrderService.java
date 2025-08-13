package Service;

import DAO.OrderDAO;
import DTO.OrderDTO;

public enum OrderService {

	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
		
	// DAO 요청메서드
	public void register(OrderDTO dto) {
		dao.insertOrder(dto);
	}
	
	
}