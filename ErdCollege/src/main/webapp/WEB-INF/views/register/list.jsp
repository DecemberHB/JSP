<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수강 목록</title>
	</head>
	<body>
		<h3>수강 목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/enroll/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>학번</th>
				<th>강좌번호</th>
				<th>중간고사점수</th>
				<th>기말고사점수</th>
				<th>총합</th>
				<th>등급</th>
			</tr>			
			
				<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.regStdNo}</td>
				<td>${dto.regLecNo}</td>
				<td>${dto.regMidScore}</td>
				<td>${dto.regFinalScore}</td>
				<td>${dto.regTotalScore}</td>
				<td>${dto.regGrade}</td>
				<td>					
					<a href="#">점수 정정</a>					
				</td>
			</tr>
			</c:forEach>
			</tr>			
		</table>		
	</body>
</html>