package dao.shop;

import java.util.ArrayList;
import java.util.List;

import dto.shop.CustomerDTO;
import util.DBHelper;

/**
 * CustomerDAO 클래스는 고객 정보에 대한 DB 작업을 처리하는 DAO 클래스입니다.
 * DBHelper를 상속받아 DB 연결/해제 관련 기능을 재사용합니다.
 */
public class CustomerDAO extends DBHelper {

    // 싱글톤 패턴: DAO 객체를 하나만 생성해서 공유하도록 설계
    private static final CustomerDAO INSTANCE = new CustomerDAO();

    // 외부에서 getInstance()를 통해 객체를 가져가게 하기 위한 메서드
    public static CustomerDAO getInstance() {
        return INSTANCE;
    }

    // 외부에서 객체 생성을 막기 위한 private 생성자
    private CustomerDAO() {
    }

    // DBCP(DataBase Connection Pool) 이름 (context.xml 또는 tomcat 설정 참고)
    private final String DBCP = "jdbc/shop";

    /**
     * 고객 정보를 DB에 삽입하는 메서드
     * @param dto - 고객 정보를 담고 있는 DTO 객체
     */
    public void insertCustomer(CustomerDTO dto) {
        try {
            // DBCP를 통해 DB 연결
            conn = getConnection(DBCP);

            // SQL 문 작성
            String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?)";
            psmt = conn.prepareStatement(sql);

            // ?에 값 매핑
            psmt.setString(1, dto.getCid());
            psmt.setString(2, dto.getName());
            psmt.setString(3, dto.getHp());
            psmt.setString(4, dto.getAddress());
            psmt.setString(5, dto.getRdate());

            // SQL 실행 (삽입)
            psmt.executeUpdate();

            // 리소스 해제
            closeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 특정 고객 한 명의 정보를 조회하는 메서드
     * @param cid - 고객 ID
     * @return CustomerDTO 객체 (없으면 null)
     */
    public CustomerDTO selectCustomer(String cid) {
        CustomerDTO dto = null;

        try {
            conn = getConnection(DBCP);

            String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cid);

            rs = psmt.executeQuery();

            if (rs.next()) {
                dto = new CustomerDTO();
                dto.setCid(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setHp(rs.getString(3));
                dto.setAddress(rs.getString(4));
                dto.setRdate(rs.getString(5));
            }

            closeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    /**
     * 모든 고객 정보를 조회해서 리스트로 반환하는 메서드
     * @return 고객 목록 리스트
     */
    public List<CustomerDTO> selectAllCustomer() {
        List<CustomerDTO> dtoList = new ArrayList<>();

        try {
            conn = getConnection(DBCP);

            // Statement 객체 사용 (파라미터가 없는 단순 쿼리)
            stmt = conn.createStatement();
            String sql = "SELECT * FROM CUSTOMER";
            rs = stmt.executeQuery(sql);

            // 여러 행을 반복하며 DTO로 변환 후 리스트에 추가
            while (rs.next()) {
                CustomerDTO dto = new CustomerDTO();
                dto.setCid(rs.getString(1));
                dto.setName(rs.getString(2));
                dto.setHp(rs.getString(3));
                dto.setAddress(rs.getString(4));
                dto.setRdate(rs.getString(5));

                dtoList.add(dto);
            }

            closeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtoList;
    }

    /**
     * 고객 정보 수정
     * @param dto - 수정할 정보가 담긴 DTO
     */
    public void updateCustomer(CustomerDTO dto) {
        try {
            conn = getConnection(DBCP);

            String sql = "UPDATE CUSTOMER SET NAME=?, HP=?, ADDRESS=? WHERE CID=?";
            psmt = conn.prepareStatement(sql);

            // 수정할 컬럼 값 세팅
            psmt.setString(1, dto.getName());
            psmt.setString(2, dto.getHp());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getCid());
            psmt.executeUpdate();
            closeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 고객 정보 삭제
     * @param cid - 삭제할 고객의 ID
     */
    public void deleteCustomer(String cid) {
        try {
            conn = getConnection(DBCP);

            String sql = "DELETE FROM CUSTOMER WHERE CID=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cid);

            psmt.executeUpdate();
            closeAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
