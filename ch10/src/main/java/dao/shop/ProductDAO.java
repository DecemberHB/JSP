package dao.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.shop.ProductDTO;
import util.DBHelper;

public class ProductDAO extends DBHelper {

	private static final ProductDAO INSTANCE = new ProductDAO();

	public static ProductDAO getInstance() {
		return INSTANCE;
	}

	// 외부 객체 생성 방지
	private ProductDAO() {
	}

	// DBCP ->

	private final String DBCP = "jdbc/shop";

	public void insertProduct(ProductDTO dto) {

		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			// 값 매핑시켜주기
			psmt.setInt(1, dto.getPno());
			psmt.setString(2, dto.getPname());
			psmt.setInt(3, dto.getStock());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getCompany());

			// 실행

			psmt.executeUpdate();

			// 해제
			closeAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ProductDTO selectProduct(int pno) {

		ProductDTO dto = null;

		try {
			conn = getConnection(DBCP);

			String sql = "SELECT * FROM PRODUCT WHERE PNO=?";
			psmt.setInt(1, pno);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new ProductDTO();

				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));

			}
			closeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;

	}

	public List<ProductDTO> selectAllProduct() {
		List<ProductDTO> dtoList = new ArrayList<>();

		try {
			conn = getConnection(DBCP);

			stmt = conn.createStatement();
			String sql = "SELECT * FROM PRODUCT";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateProduct(ProductDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE PRODUCT SET PNAME=?, STOCK=?, PRICE=?, COMPANY=? WHERE PNO =?";

			psmt = conn.prepareStatement(sql);
			//컬럼값 셋팅
			psmt.setString(1, dto.getPname());
			psmt.setInt(2, dto.getStock());
			psmt.setInt(3, dto.getPrice());
			psmt.setString(4, dto.getCompany());
			psmt.setInt(5, dto.getPno());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteProduct(int pno) {
		
		try {
			conn  =getConnection(DBCP);
			
			String sql ="DELETE FROM PRODUCT WHERE PNO=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);
			
			psmt.executeUpdate();
			closeAll();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}
