<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 목록</title>
	</head>
	<body>
		<h3>학생 목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/student/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>휴대폰</th>
				<th>학년</th>
				<th>주소</th>
				<th>관리</th>
			</tr>			
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.stdNo}</td>
				<td>${dto.stdName}</td>
				<td>${dto.stdHp}</td>
				<td>${dto.stdYear}</td>
				<td>${dto.stdAddress}</td>
				<td>					
					<a href="#">수강신청</a>					
				</td>
			</tr>
			</c:forEach>		
		</table>		
	</body>
</html>