package service;

import java.util.List;

import dao.User2DAO;
import dto.User2DTO;

public enum User2Service {
	
	INSTANCE;
	
	private User2DAO dao = User2DAO.getInstance();
	
	// 기본 CRUD 메서드 생성하기
	//유저 추가등록 (register)
	public void register(User2DTO dto) {
		dao.insertUser2(dto);
	}
	
	// 유저의 정보 수정 및 삭제를 위함 >> uid=? << 값을 가져오기 위함
	public User2DTO findById(String uid) {
		return dao.selectUser2(uid);
	}
	
	// 유저 전체 정보 확인
	public List<User2DTO> findAll(){
		return dao.selectAllUser2();
	}
	
	// 유저 정보 수정 (modify)
	public void modify(User2DTO dto) {
		dao.updateUser2(dto);
	}
	
	//유저 삭제
	public void delete(String uid) {
		dao.deleteUser2(uid);
	}
	

}
