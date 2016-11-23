<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\notice.css" />
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
									<li><a href="main.jsp">HOME</a></li>
									<li class="line1">|</li>
									<li><a href="register.jsp">회원가입</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<!-- Logo -->
				<h1>
					<a href="main.jsp">컴공벗</a>
				</h1>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li class="current"><a href="introduction.jsp">사이트공지</a>
							<ul>
								<li><a href="introduction.jsp">사이트설명</a></li>
								<li><a href="notice.jsp">개발자공지</a></li>
							</ul></li>
						<li><a href="timetable.jsp">시간표작성</a>
							<ul>
								<li><a href="timetable.jsp">시간표 작성</a></li>
								<li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
								<li><a href="lecture.jsp">강의정보</a></li>
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
						<div class="noticebox">

							<section>
								<header>
									<h3></h3>
								</header>
								<header>
									<h2 align="center">개발자 공지사항</h2>
								</header>
								<table class="notice_table">
									<thead>
										<tr>
											<th class="notice_th">제목</th>
											<th class="notice_th">글쓴이</th>
											<th class="notice_th">날짜</th>
											<th class="notice_th">조회수</th>
										</tr>
									</thead>
									<tbody>
										<tr class="notice_tr">
											<td class="notice_td">2016년도 동계 현장실습학점제(1학과1기업) 신청관련 공지</td>
											<td class="notice_td">관리자</td>
											<td class="notice_td">2016.11.03</td>
											<td class="notice_td"></td>
										</tr>
										<tr class="notice_tr">
											<td class="notice_td">제1회 동국SW공모대전 공지</td>
											<td class="notice_td">관리자</td>
											<td class="notice_td">2016.10.21</td>
											<td class="notice_td"></td>
										</tr>
										<tr class="notice_tr">
											<td class="notice_td">학과사무실 운영시간</td>
											<td class="notice_td">관리자</td>
											<td class="notice_td">2016.09.13</td>
											<td class="notice_td"></td>
										</tr>
										<tr class="notice_tr">
											<td class="notice_td">SW중점대학사업 및 서울어코드사업 사사표기</td>
											<td class="notice_td">관리자</td>
											<td class="notice_td">2016.05.26</td>
											<td class="notice_td"></td>
										</tr>

									</tbody>
								</table>


							</section>

						</div>

					</div>

				</div>
			</div>
		</div>

		<!-- Footer -->
		<div id="footer-wrapper">
			<section id="footer" class="container">
				<div class="row">
					<div class="8u 12u(mobile)">
						<section>
							<header>
								<h2>버전업데이트 정보</h2>
							</header>
							<ul class="dates">
								<li><span class="date">Jan <strong>27</strong></span>
									<h3>
										<a href="#">Lorem dolor sit amet veroeros</a>
									</h3>
									<p>Ipsum dolor sit amet veroeros consequat blandit ipsum
										phasellus lorem consequat etiam.</p></li>
								<li><span class="date">Jan <strong>27</strong></span>
									<h3>
										<a href="#">Lorem dolor sit amet veroeros</a>
									</h3>
									<p>Ipsum dolor sit amet veroeros consequat blandit ipsum
										phasellus lorem consequat etiam.</p></li>
							</ul>
						</section>
					</div>
					<div class="4u 12u(mobile)">
						<section>
							<header>
								<h2>제작자정보</h2>
							</header>

							<ul class="contact">
								<li>
									<h3>Address</h3>
									<p>주소</p>
								</li>
								<li>
									<h3>Mail</h3>
									<p>
										<a href="#">문의 이메일</a>
									</p>
								</li>
								<li>
									<h3>Phone</h3>
									<p>전화번호 넣는곳</p>
								</li>
							</ul>
						</section>
					</div>
				</div>

				<div class="row">
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
			</section>
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