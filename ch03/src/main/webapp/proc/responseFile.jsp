<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>redirect3</title>
	</head>
	<body>
		<h3>responseFile 페이지</h3>
		<% 
			// 해당 페이지를 파일로 응답 : app~
			response.setHeader("Content-Type", "application/octet-stream");
		
		
		%>
	</body>
</html>