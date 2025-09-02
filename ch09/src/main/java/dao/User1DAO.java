package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User1DTO;

// DAO(Data Access Object) : DB처리를 수행하는 객체 
public class User1DAO {
	
	// DAO는 기본 싱글톤
	private final static User1DAO INSTANCE = new User1DAO();	
	public static User1DAO getInstance() {
		return INSTANCE;
	}	
	private User1DAO() {} // 외부에서 생성자 호출 못하도록 private 설정
	
	// 기본 CRUD 메서드
	// ✅ 2. INSERT (Create) - 새로운 유저 추가
	public int insertUser1(User1DTO dto) {		
		int rowCount = 0;
		try {
			// 1. JNDI를 통해 커넥션 풀(DataSource) 객체 얻기
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
			
			// 2. 커넥션 가져오기
			Connection conn = ds.getConnection();
			
			// 3. SQL 작성 및 실행
			String sql = "INSERT INTO USER1 VALUES (?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			// INSERT가 성공하면 1, 실패하면 0  (return 값)
			rowCount = psmt.executeUpdate();  // INSERT 실행
			
			// 4. 리소스 정리
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}
		
		return rowCount;
	}
	
	
	//SELECT (Read) - 특정 유저 조회
	public User1DTO selectUser1(String user_id) {
		
		User1DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
			
			Connection conn = ds.getConnection();
			
			String sql = "SELECT * FROM USER1 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {				
				dto = new User1DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}
		
		return dto;
	}
	
	
	// SELECT ALL - 전체 유저 목록 조회

	public List<User1DTO> selectAllUser1() {
		
		List<User1DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
			
			Connection conn = ds.getConnection();
						
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER1";			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				User1DTO dto = new User1DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				
				dtoList.add(dto);
			}			
			
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}	
		
		return dtoList;
	}
	
	
	//UPDATE - 유저 정보 수정
	public int updateUser1(User1DTO dto) {
		int rowCount = 0;
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
			
			Connection conn = ds.getConnection();
						
			String sql = "UPDATE USER1 SET name=?, hp=?, age=? WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUser_id());
			
			rowCount = psmt.executeUpdate(); // 반환처리 09-02
			
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}	
		return rowCount;
		
	}
	
	// DELETE - 특정 유저 삭제
	public int deleteUser1(String user_id) {
		int rowCount = 0;
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
			
			Connection conn = ds.getConnection();
						
			String sql = "DELETE FROM USER1 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rowCount = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();			
		}	
		return rowCount;
	}
}