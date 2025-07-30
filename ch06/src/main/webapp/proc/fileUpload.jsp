<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.Part"%>

<%
    // 파일 업로드 디렉토리 경로 생성
    String path = application.getRealPath("/files");

    // 업로드 파일 가져오기
    Part part = request.getPart("file1");

    // 원본 파일명 추출
    String oriName = part.getSubmittedFileName();
    System.out.println("fname : " + oriName);

    // 확장자와 저장 파일명 생성
    String ext1 = oriName.substring(oriName.lastIndexOf("."));
    String savedName = UUID.randomUUID().toString() + ext1;

    // 기타 파라미터 수신
    String title = request.getParameter("title");
    String name = request.getParameter("name");

    // 파일 저장
    part.write(path + File.separator + savedName);

    // 데이터베이스 저장
    try {
        Context ctx = (Context) new InitialContext().lookup("java:comp/env");
        DataSource ds = (DataSource) ctx.lookup("jdbc/hyokong");
        Connection conn = ds.getConnection();

        String sql = "INSERT INTO FILES (TITLE, NAME, ONAME, SNAME, RDATE) VALUES (?, ?, ?, ?, SYSDATE)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, title);
        psmt.setString(2, name);
        psmt.setString(3, oriName);
        psmt.setString(4, savedName);

        psmt.executeUpdate();

        psmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    // 파일 목록 페이지로 이동
    response.sendRedirect("/ch06/fileDownload.jsp");
%>
