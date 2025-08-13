package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User3DTO;
import util.DBHelper;

public class User3DAO extends DBHelper {

	// 싱글톤

	private static final User3DAO INSTANCE = new User3DAO();

	public static User3DAO getInstance() {
		return INSTANCE;
	}

	private User3DAO() {
	}

	// 연결하려는 DB 값 전달 (내꺼)

	private final String DBCP = "jdbc/studydb";

	// 유저등록 DAO Insert
	public void insertUser3(User3DTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO USER3 VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getAddr());

			psmt.executeUpdate();
			closeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 유저 정보 수정 및 삭제 (SELECT FROM Table)
	public User3DTO selectUser3(String uid) {

		User3DTO dto = null;
		// return null;

		try {
			conn = getConnection(DBCP);

			String sql = "SELECT * FROM USER3 WHERE UID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sql);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new User3DTO();

				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));

			}
			closeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 유저 전체 정보 리스트
	public List<User3DTO> seleteAllUser3() {
		List<User3DTO> dtoList = new ArrayList<User3DTO>();
		try {

			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USER3");

			while (rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	// 유저 정보 수정 DAO (update)
	public void updateUser3(User3DTO dto) {
		try {
			conn = getConnection(DBCP);
			 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 유저 삭제 DAO (DELETE)
	public void deleteUser3(String uid) {

	}
}
