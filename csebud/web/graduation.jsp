<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\graduation.css" />
</head>
<body class="right-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<div id="header">
				<div style="min-width: 1200px;">
					<table id="topnav">
					<tr><td>
					<c:choose>

							<c:when test="${not empty sessionScope.userLoginInfo}">

								<ul>
									<li><a href="logoutProcess">로그아웃</a></li>
									<li class="line1">|</li>
									<li><a href="register">회원가입</a></li>
								</ul>

							</c:when>
							<c:otherwise>

								<ul>
									<li><a href="main">로그인</a></li>
									<li class="line1">|</li>
									<li><a href="register">회원가입</a></li>
								</ul>

							</c:otherwise>

					</c:choose>
					</td></tr>
					</table>
				</div>
				<!-- Logo -->
				<h1>
					
					<h1><a href="main"><img src="image\logo.jpg" style="width: 100%; vertical-align: middle; width:1200px" /></a></h1>
				</h1>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="lecture">강의정보</a></li>
						<li><a href="timetable">시간표작성</a>
							<ul>
								<li><a href="timetable">시간표 작성</a></li>
								<li><a href="timetable_auto">시간표 자동작성</a></li>
							</ul></li>
						<li class="current"><a href="personal_data">학사관리</a>
							<ul>
								<li><a href="personal_data">개인정보 입력</a></li>
								<li><a href="graduation">졸업요건관리</a></li>
							</ul></li>
						<li><a href="review">강의평가</a>
						<li><a href="announcement">학교공지</a></li>
					</ul>
				</nav>

			</div>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div class="row">
					<div class="12u">

						<!-- Content -->
						<div class="databox" style="float: left; height: 900px">
							<div
								style="width: 100%; text-align: center; padding-top: 20px; float: left">
								<h2>비교</h2>
							</div>
							<div style="width: 100%; padding: 100px 20px 20px 20px;">
								<table class="graduation">
									<thead>
										<tr>
											<th></th>
											<th scope="col">졸업요건</th>
											<th scope="col">내 정보</th>

										</tr>
									</thead>
									<tfoot>
										<tr>
											<th scope="row" width=150px>졸업가능 여부</th>
											<td></td>
											<td></td>
										</tr>
									</tfoot>
									<tbody>
										<tr>
											<th scope="row" width=130px bgcolor="red">이수학점</th>
											<td>${reg.gross}</td>
											<td>${myreg.gross}</td>

										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">총 MSC 학점</th>
											<td>${reg.mscGross}</td>
											<td>${myreg.mscGross}</td>

										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">MSC수학 학점</th>
											<td>${reg.mscMath}</td>
											<td>${myreg.mscMath}</td>

										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">MSC 과학 학점</th>
											<td>${reg.mscScience}</td>
											<td>${myreg.mscScience}</td>

										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">MSC 전산 학점</th>
											<td>${reg.mscProcess}</td>
											<td>${myreg.mscProcess}</td>

										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">총 교양 학점</th>
											<td>${reg.cultural}</td>
											<td>${myreg.cultural}</td>
										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">일반 교양 학점</th>
											<td>${reg.cultural}</td>
											<td>${myreg.cultural}</td>
										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">기본 소양 학점</th>
											<td>${reg.basic}</td>
											<td>${myreg.basic}</td>
										</tr>
										<tr>
											<th scope="row" width=130px bgcolor="red">총 전공 학점</th>
											<td>${reg.majorGross}</td>
											<td>${myreg.majorGross}</td>
										</tr>
									</tbody>
								</table>
							</div>

						</div>


						<div class="databox" style="float: right; height: 300px;">
							<div style="padding: 25px 25px 50px 25px; text-align: center;">
								<h2>내 정보</h2>
								<br>
								<div>
									<table class="info">
										<tbody>
											<tr>
												<td bgcolor="black" width=30% align=center border="1"><font
													color="white">이름</font></td>
												<td bgcolor="white" width=70%>${sessionScope.userLoginInfo.name}</td>
											</tr>
											<tr>
												<td bgcolor="black" width=30% align=center><font
													color="white">학번</font></td>
												<td bgcolor="white" width=70%>${sessionScope.userLoginInfo.studentId}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="databox" style="float: right; height: 600px;">
							<div style="padding: 50px 25px 50px 25px; text-align: center;">
								<h2>필수과목</h2>
								<br>
								<div style="width:100%; height:150px; overflow-y:auto">
									<table class="lecture_table" style="width: 100%;">
										<thead>
											<tr class="lecture_tr">
												<td class="lecture_th" style="width: 50%">강의명</td>
												<td class="lecture_th" style="width: 25%">강의코드</td>
												<td class="lecture_th" style="width: 25%">강의유형</td>
											</tr>
										</thead>
										<tbody>
										
											<c:forEach items="${reqLec}" var="lecture">

											<tr class="lecture_tr">
												<td class="lecture_td">${lecture.lname}</td>
												<td class="lecture_td">${lecture.lcode}</td>
												<c:choose>
												<c:when test="${lecture.ltype eq 'major'}">
												<td class="lecture_td">전공</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'basic'}">
												<td class="lecture_td">기본소양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'common'}">
												<td class="lecture_td">기초교양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'cultural'}">
												<td class="lecture_td">교양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscMath'}">
												<td class="lecture_td">MSC수학</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscScience'}">
												<td class="lecture_td">MSC과학</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscProcess'}">
												<td class="lecture_td">MSC전산</td>
												</c:when>
												<c:otherwise>
												<td class="lecture_td"></td>
												</c:otherwise>
												</c:choose>
											</tr>
											
											</c:forEach>

										</tbody>
									</table>
								</div>
								<br>
								<h2>선택필수</h2>
								<br>
								<div style="width:100%; height:200px; overflow-y:auto">
									<table class="lecture_table" style="width: 100%;">
										<thead>
											<tr class="lecture_tr">
												<td class="lecture_th" style="width: 50%">강의명</td>
												<td class="lecture_th" style="width: 25%">강의코드</td>
												<td class="lecture_th" style="width: 25%">강의유형</td>
											</tr>
										</thead>
										<tbody>
										
											<c:forEach items="${optLec}" var="lecture">

											<tr class="lecture_tr">
												<td class="lecture_td">${lecture.lname}</td>
												<td class="lecture_td">${lecture.lcode}</td>
												<c:choose>
												<c:when test="${lecture.ltype eq 'major'}">
												<td class="lecture_td">전공</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'basic'}">
												<td class="lecture_td">기본소양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'common'}">
												<td class="lecture_td">기초교양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'cultural'}">
												<td class="lecture_td">교양</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscMath'}">
												<td class="lecture_td">MSC수학</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscScience'}">
												<td class="lecture_td">MSC과학</td>
												</c:when>
												<c:when test="${lecture.ltype eq 'mscProcess'}">
												<td class="lecture_td">MSC전산</td>
												</c:when>
												<c:otherwise>
												<td class="lecture_td"></td>
												</c:otherwise>
												</c:choose>
											</tr>
											
											</c:forEach>
											
										</tbody>
									</table>
								</div>
							</div>
							
						</div>

						<br><br><br>

					</div>

				</div>

			</div>
		</div>

		<!-- Footer -->
		<div id="footer-wrapper"><br>
			<center>
				<a href="https://docs.google.com/forms/d/e/1FAIpQLSfu63k-5rEBTpbtX8yQCQ-S404QwmTiezaHoJhAxsvuR8eicA/viewform"
					target="_blank">사용만족도 조사에 참여해주세요!</a></center>

				<div style="min-width: 1100px">
					<div class="12u">

						<!-- Copyright -->
						<div id="copyright">
							<ul class="links">
								<li>Copyright &copy; 2016 By <b>team buddy</b> All Rights Reserved</li>
							</ul>
						</div>

					</div>
				</div>
			
		</div>
		<div style="position: fixed; bottom: 50px; right: 80px;">
			<a href="#header-wrapper"> <img src="image/top.jpg" title="위로 가기"
				width="50px"; ></a>
		</div>
	</div>

	<!-- Scripts -->
	<script src="js\jquery.min.js"></script>
	<script src="js\jquery.dropotron.min.js"></script>
	<script src="js\skel.min.js"></script>
	<script src="js\skel-viewport.min.js"></script>
	<script src="js\util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="js\main.js"></script>

</body>
</html>