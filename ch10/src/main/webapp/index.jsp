<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		<!-- 
			날짜 : 2025/08/01
			이름 : 박효빈
			내용 : 프로젝트 로그와 배포 실습
			
			
			
			로그 
			 - 시스템의 실행과정 및 서버스 개선을 위한 작업 
			 - 로그 단계별 기록을 통해 서비스 개선
			 
			라이브러리
			 - logback-classic-1.5.18
			 - logback-core-1.5.18
			 - slf4j-api-2.0.17
			 
			로그 설정
			 - WEB-INF > classes 폴더 생성 > logback.xml 파일생성
			 - https://logback.qos.ch/manual/configuration.html에서 설정 XML 복사 ch03 > name="FILE"
			 
			배포
			 - 이클립스 프로젝트 > export > war 생성
			 - tocat > startup 실행
			 - tocat > webapps 폴더에 배포파일(ch10.war) 업로드 후 Deploy 확인 후 브라이저 확인
			  
		-->		
	</head>
	<body>
		<h3>프로젝트 로그와 배포</h3>
		
		<h4>SHOP</h4>
		<a href="/ch10/shop/customer/list.do">CUSTOMER CRUD</a>
		<a href="/ch10/shop/product/list.do">Product CRUD</a>
		
		
		<h4>College</h4>
		<a href="/ch10/college/student/list.do">Student CRUD</a>
		<a href="/ch10/college/course/list.do">Student CRUD</a>
		
		<h4>Bank</h4>
		<a href="/ch10/bank/account/list.do">Account CRUD</a>
		<a href="/ch10/bank/customer/list.do">customer CRUD</a>
		
		<h4>Library</h4>
		<a href="/ch10/library/member/list.do">Account CRUD</a>
		<a href="/ch10/library/book/list.do">customer CRUD</a>
		
		<h4>User(MySQL)</h4>
		<a href ="/ch10/user1/list.do"> user1 CRUD</a><br/>
		<a href ="/ch10/user2/list.do"> user2 CRUD</a><br/>
		<a href ="/ch10/user3/list.do"> user3 CRUD</a><br/>
		<a href ="/ch10/user4/list.do"> user4 CRUD</a><br/>
		<a href ="/ch10/user5/list.do"> user5 CRUD</a><br/>
		
		
	</body>
</html>