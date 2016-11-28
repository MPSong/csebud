<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\announce.css">
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
						<li><a href="lecture.jsp">강의정보</a>
							</li>
						<li><a href="timetable.jsp">시간표작성</a>
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
						<li class="current"><a href="announcement.jsp">학교공지</a></li>
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
						<div class="noticebox">
							<table class="announce_table">
								<thead>
									<tr class="announce_tr">
										<th class="announce_th" colspan="3">학사공지</th>
									</tr>
								</thead>
								<tbody>
									<tr class="announce_tr">
										<td class="announce_td">2016년도 동계 현장실습학점제(1학과1기업) 신청관련 공지</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.11.03</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">제1회 동국SW공모대전 공지</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.10.21</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">학과사무실 운영시간</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.09.13</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">SW중점대학사업 및 서울어코드사업 사사표기</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.05.26</td>
									</tr>

								</tbody>
							</table>
							<br>
							<br>
							<table class="announce_table">
								<thead>
									<tr class="announce_tr">
										<th class="announce_th" colspan="3">장학공지</th>
									</tr>
								</thead>
								<tbody>
									<tr class="announce_tr">
										<td class="announce_td">2016년도 동계 현장실습학점제(1학과1기업) 신청관련 공지</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.11.03</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">제1회 동국SW공모대전 공지</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.10.21</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">학과사무실 운영시간</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.09.13</td>
									</tr>
									<tr class="announce_tr">
										<td class="announce_td">SW중점대학사업 및 서울어코드사업 사사표기</td>
										<td class="announce_td">관리자</td>
										<td class="announce_td">2016.05.26</td>
									</tr>

								</tbody>
							</table>
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