package dao.college;

import java.util.ArrayList;
import java.util.List;

import dto.college.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {

    private static final StudentDAO INSTANCE = new StudentDAO();

    public static StudentDAO getInstance() {
        return INSTANCE;
    }

    private StudentDAO() {}

    // 학생 등록
    public void insertStudent(StudentDTO dto) {
        System.out.println("insertStudent() 호출됨");
    }

    // 학생 한 명 조회
    public StudentDTO selectStudent(String stdNo) {
        System.out.println("selectStudent() 호출됨");
        return new StudentDTO(); // 혹은 null 반환
    }

    // 전체 학생 목록 조회
    public List<StudentDTO> selectAllStudent() {
        System.out.println("selectAllStudent() 호출됨");
        return new ArrayList<>();
    }

    // 학생 정보 수정
    public void updateStudent(StudentDTO dto) {
        System.out.println("updateStudent() 호출됨");
    }

    // 학생 삭제
    public void deleteStudent(String stdNo) {
        System.out.println("deleteStudent() 호출됨");
    }
}
