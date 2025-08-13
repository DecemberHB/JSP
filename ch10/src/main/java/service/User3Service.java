package service;

import java.util.List;

import dao.User3DAO;
import dto.User3DTO;

public enum User3Service {
	INSTANCE; // 서비스에서는 DAO를 그대로 복사해오되, 명을 좀더 서비스에 맞게 설정

	private User3DAO dao = User3DAO.getInstance();
	
	
	// 유저등록 DAO
	public void registerUser3(User3DTO dto) {

		dao.insertUser3(dto); 
	}

	// 유저 정보 수정 및 삭제 (SELECT FROM Table)
	public User3DTO findById(String uid) {
		return dao.selectUser3(uid);
	}

	// 유저 전체 정보 리스트
	public List<User3DTO> findAllUser3() {
		return dao.seleteAllUser3();
	}

	// 유저 정보 수정 DAO (update)
	public void modify(User3DTO dto) {
		dao.updateUser3(dto);

	}

	// 유저 삭제 DAO (DELETE)
	public void remove(String uid) {

		dao.deleteUser3(uid);
	}

}
