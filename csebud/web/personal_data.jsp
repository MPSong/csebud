<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\personal_data.css" />
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
						<div class="databox" style="float: left; height: 600px">
							<div
								style="width: 100%; text-align: center; padding-top: 20px; float: left">
								<h2>개인정보 입력</h2>
							</div>
							<div
								style="width: 100%; height: 150px; padding: 10px 10px 10px 50px; border: solid">
								성적파일을 올려주세요
								<%@ include file="upload.jsp"%>
							</div>
							<div
								style="width: 100%; padding: 50px 10px 20px 30px; border: solid; height: 445px;">
								<form>
									<div
										style="display: inline-block; width: 20%; margin-left: 50px">학번:
									</div>
									<select name="studentNumber" style="display: inline-block">
										<option value="">학번</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="13">15</option>
										<option value="14">16</option>
									</select> <br>
									<br>
									<div
										style="display: inline-block; width: 20%; margin-left: 50px">학년:
									</div>
									<select name="grade" style="display: inline-block">
										<option value="">학년</option>
										<option value="1">1학년</option>
										<option value="2">2학년</option>
										<option value="3">3학년</option>
										<option value="4">4학년 이상</option>
									</select> <br>
									<br>
									<div
										style="display: inline-block; width: 20%; margin-left: 50px">학기수:
									</div>
									<select name="semester" style="display: inline-block">
										<option value="">학기수</option>
										<option value="1">1학기</option>
										<option value="2">2학기</option>
										<option value="3">3학기</option>
										<option value="4">4학기</option>
										<option value="5">5학기</option>
										<option value="6">6학기</option>
										<option value="7">7학기</option>
										<option value="8">8학기</option>
									</select> <br>
									<br>
									<div
										style="display: inline-block; width: 20%; margin-left: 50px">영어트랙:
									</div>
									<select name="english" style="display: inline-block">
										<option value="">영어트랙</option>
										<option value="1">A트랙(1~500등)</option>
										<option value="2">A트랙(501~1000등)</option>
										<option value="3">B트랙</option>
										<option value="4">C트랙</option>
									</select>
								</form>
							</div>


						</div>


						<div class="databox" style="float: right; height: 600px;">
							<div style="padding: 50px 25px 50px 25px; text-align: center;">
								<h2>내 수강정보</h2>
								<br>
								<div style="min-width:500px; height:470px; overflow:auto;">
									<table class="personal_table">
										<thead>
											<tr>
												<td class="personal_th" style="width: 120px">강의명</td>
												<td class="personal_th" style="width: 85px">학점</td>
												<td class="personal_th" style="width: 85px">등급</td>
												<td class="personal_th" style="width: 110px">영어강의 유무</td>
											</tr>
										</thead>
										<tbody>
											
											<c:choose>
											
												<c:when test="${fn:length(list) > 0}">
													<c:forEach items="${list}" var="course">
	
													<tr class="personal_tr">
														<td class="personal_td"><center>${course.lectureName}</center></td>
														<td class="personal_td"><center>${course.credit}</center></td>
														<td class="personal_td"><center>${course.grade}</center></td>
														<c:choose>
														<c:when test="${course.isEnglishCourse eq 1}">
															<td class="personal_td"><center>○</center></td>
														</c:when>
														<c:otherwise>
															<td class="personal_td"></td>
														</c:otherwise>
														</c:choose>
													</tr>
													
													</c:forEach>
												</c:when>			
									            <c:otherwise>
									                <tr class="personal_tr">
									                    <td class="personal_td" colspan="4">&nbsp; 조회된 결과가 없습니다.</td>
									                </tr>
									            </c:otherwise>																			
											
											</c:choose>
											


										</tbody>
									</table>
								</div>
							</div>
							
							<div style="float: right;">
							<a href="#page-wrapper"><img src="image\top.jpg" style="width: 100%; float: right; width:50px" /></a>
							</div>
							
						</div>


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