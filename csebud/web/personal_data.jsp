<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
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
						<tr>
							<td>
								<ul>
									<li><a href="main.jsp">로그인</a></li>
									<li class="line1">|</li>
									<li><a href="register.jsp">회원가입</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<!-- Logo -->
				<h1>
					
					<a href="main.jsp"><img src="image\logo.png" style="width: 100%; vertical-align: middle; width:1287px" /></a>
				</h1>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="lecture.jsp">강의정보</a></li>
						<li><a href="timetable.jsp">시간표작성</a>
							<ul>
								<li><a href="timetable.jsp">시간표 작성</a></li>
								<li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
							</ul></li>
						<li class="current"><a href="personal_data.jsp">학사관리</a>
							<ul>
								<li><a href="personal_data.jsp">개인정보 입력</a></li>
								<li><a href="graduation.jsp">졸업요건관리</a></li>
							</ul></li>
						<li><a href="review.jsp">강의평가</a>
						<li><a href="announcement.jsp">학교공지</a></li>
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
								style="width: 100%; height: 100px; padding: 10px 10px 10px 50px">
								성적파일을 올려주세요
								<%@ include file="upload.jsp"%>
							</div>
							<div style="width: 100%; padding: 50px 10px 20px 30px">
								학번: <select name="studentNumber">
									<option value="">학번</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="13">15</option>
									<option value="14">16</option>
								</select> <br> <br> <br> 학년: <select name="grade">
									<option value="">학년</option>
									<option value="1">1학년</option>
									<option value="2">2학년</option>
									<option value="3">3학년</option>
									<option value="4">4학년 이상</option>
								</select> <br> <br> <br> 학기수: <select name="semester">
									<option value="">학기수</option>
									<option value="1">1학기</option>
									<option value="2">2학기</option>
									<option value="3">3학기</option>
									<option value="4">4학기</option>
									<option value="5">5학기</option>
									<option value="6">6학기</option>
									<option value="7">7학기</option>
									<option value="8">8학기</option>
								</select> <br> <br> <br> 영어트랙: <select name="english">
									<option value="">영어트랙</option>
									<option value="1">A트랙(1~500등)</option>
									<option value="2">A트랙(501~1000등)</option>
									<option value="3">B트랙</option>
									<option value="4">C트랙</option>
								</select>
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
												<td class="personal_th" style="width: 100px">강의코드</td>
												<td class="personal_th" style="width: 100px">강의명</td>
												<td class="personal_th" style="width: 100px">학점</td>
												<td class="personal_th" style="width: 100px">영어강의</td>
											</tr>
										</thead>
										<tbody>

											<tr class="personal_tr">
												<td class="personal_td">cse4040</td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>

											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>

											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>
											<tr class="personal_tr">
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
												<td class="personal_td"></td>
											</tr>


										</tbody>
									</table>
								</div>
							</div>
						</div>


					</div>

				</div>

			</div>
		</div>

		<!-- Footer -->
		<div id="footer-wrapper">
			<center>
				<a
					href="https://docs.google.com/forms/d/e/1FAIpQLSfu63k-5rEBTpbtX8yQCQ-S404QwmTiezaHoJhAxsvuR8eicA/viewform"
					target="_blank">사용만족도 조사에 참여해주세요!</a></center>

				<div style="min-width: 1100px">
					<div class="12u">

						<!-- Copyright -->
						<div id="copyright">
							<ul class="links">
								<li>&copy;컴공벗</li>
								<li>컴공벗조</li>
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