<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\timetable.css" />

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

					<a href="main.jsp"><img src="image\logo.png"
						style="width: 100%; vertical-align: middle; width: 1287px" /></a>
				</h1>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="lecture.jsp">강의정보</a></li>
						<li class="current"><a href="timetable.jsp">시간표작성</a>
							<ul>
								<li><a href="timetable.jsp">시간표 작성</a></li>
								<li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
							</ul></li>
						<li><a href="personal_data.jsp">학사관리</a>
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
						<div
							style="min-width: 1100px; background-color: white; padding: 50 0 0 0">
							<center>
								<h2>시간표 수동작성</h2>
							</center>
							<div
								style="padding: 50 50 50 50; float: left; background-color: white; width: 60%; height: 1000px;">
								<%@include file="make_timetable.jsp"%>
							</div>
							<div
								style="width: 40%; background-color: white; float: right; height: 1000px; padding: 50 50 0 0">
								<div style="float: right; margin-left: 20px;">
									<button id="button" type="submit">add</button>
								</div>
								<div style="float: right">
									<form action="" method="">
										<input type="search" id="search" style="height: 44px;">
										<button id="button">Search</button>
									</form>
								</div>
								<div style="padding:100 0 20 20">
									<div style="width: 100%; height: 400px; overflow-y: auto">
										<table class="timetable_table" style="width: 100%;">
											<thead>
												<tr class="timetable_tr">
													<td class="timetable_th" style="width: 50%">강의명</td>
													<td class="timetable_th" style="width: 25%">시간</td>
													<td class="timetable_th" style="width: 25%">교수</td>
												</tr>
											</thead>
											<tbody>

												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
												</tr>
												<tr class="timetable_tr">
													<td class="timetable_td">소프트웨어 공학개론</td>
													<td class="timetable_td">cse2000</td>
													<td class="timetable_td">최은만</td>
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
		</div>

		<!-- Footer -->
		<div id="footer-wrapper">
			<center>
				<a
					href="https://docs.google.com/forms/d/e/1FAIpQLSfu63k-5rEBTpbtX8yQCQ-S404QwmTiezaHoJhAxsvuR8eicA/viewform"
					target="_blank">사용만족도 조사에 참여해주세요!</a>
			</center>

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