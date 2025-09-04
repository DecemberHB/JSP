package jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.dto.UserDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class UserDAO extends DBHelper {
	
	private final static UserDAO INSTANCE = new UserDAO();
	public static UserDAO getInstance() {
		return INSTANCE;
	}	
	private UserDAO() {}
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(UserDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_USER);
			psmt.setString(1, dto.getUsid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getUs_name());
			psmt.setString(4, dto.getNick());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getHp());
			psmt.setString(7, dto.getZip());
			psmt.setString(8, dto.getAddr1());
			psmt.setString(9, dto.getAddr2());
			psmt.setString(10, dto.getReg_ip());			
			
			psmt.executeUpdate();			
			closeAll();			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public int selectCount(String col, String value) {
		
		int count = 0;
		
		try {
			conn = getConnection();
			
			StringBuilder sql = new StringBuilder(Sql.SELECT_COUNT);
			
			if(col.equals("uid")) {
				sql.append(Sql.WHERE_USID);
			}else if(col.equals("nick")) {
				sql.append(Sql.WHERE_NICK);
			}else if(col.equals("email")) {
				sql.append(Sql.WHERE_EMAIL);
			}else if(col.equals("hp")){
				sql.append(Sql.WHERE_HP);
			}			
			psmt= conn.prepareStatement(sql.toString());
			psmt.setString(1, value);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		return count;
	}
	//서비스 계층에서 전달받은 UserDTO (로그인 시 입력한 uid, pass 값 들어있음)를 받아서, DB 조회 후 **회원 정보(UserDTO)**를 만들어 반환하는
	public UserDTO select(UserDTO dto) {
		
		UserDTO userDTO = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_USER_BY_PASS);
			psmt.setString(1, dto.getUsid());
			psmt.setString(2, dto.getPass());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { // 사용자가 입력한 값을 확인하는 곳 
				userDTO = new UserDTO();
				userDTO.setUsid(rs.getString(1));						
				userDTO.setPass(rs.getString(2));						
				userDTO.setUs_name(rs.getString(3));						
				userDTO.setNick(rs.getString(4));						
				userDTO.setEmail(rs.getString(5));						
				userDTO.setHp(rs.getString(6));						
				userDTO.setUs_role(rs.getString(7));						
				userDTO.setZip(rs.getString(8));						
				userDTO.setAddr1(rs.getString(9));						
				userDTO.setAddr2(rs.getString(10));						
				userDTO.setReg_ip(rs.getString(11));						
				userDTO.setReg_date(rs.getString(12));						
				userDTO.setLeave_date(rs.getString(13));						
			}			
			closeAll();			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return userDTO;
	}
	
	public List<UserDTO> selectAll() {
		return null;
	}
	
	public void update(UserDTO dto) {
		
	}
	
	public void delete(String usid) {
		
	}
}