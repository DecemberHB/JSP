<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SHOP::modify</title>
	</head>
	<body>
		<h3>SHOP::Modify 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/customer/modify.do">수정하기</a>
		
		<form action="/ch10/shop/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="cid" readonly value="${customer.cid}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${customer.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${customer.hp}" placeholder="휴대폰 입력(- 포함)"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${customer.address}" placeholder="주소 입력"/></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>			
			</table>		
		</form>			
	</body>
</html>