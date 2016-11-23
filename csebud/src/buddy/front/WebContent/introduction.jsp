<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="css\style.css" />
		<link rel="stylesheet" href="css\loginstyle.css"/>
	</head>
	<body class="right-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<div id="header">
					
					<div style="min-width:1200px;">
					<table id="topnav">
					<tr><td>
					<ul>
						<li><a href="main.jsp">HOME</a></li><li class="line1">|</li>
						<li><a href="register.jsp">회원가입</a></li>
					</ul>
					</td></tr>
					</table>
					</div>
						<!-- Logo -->
							<h1><a href="main.jsp">컴공벗</a></h1>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li class="current">
										<a href="introduction.jsp">사이트공지</a>
										<ul>
											<li><a href="introduction.jsp">사이트설명</a></li>
											<li><a href="notice.jsp">개발자공지</a></li>
										</ul>
									</li>
									<li><a href="timetable.jsp">시간표작성</a>
										<ul>
											<li><a href="timetable.jsp">시간표 작성</a></li>
											<li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
											<li><a href="lecture.jsp">강의정보</a></li>
										</ul>
									</li>
									<li><a href="personal_data.jsp">학사관리</a>
										<ul>
											<li><a href="personal_data.jsp">개인정보 입력</a></li>
											<li><a href="graduation.jsp">졸업요건관리</a></li>
										</ul>
									</li>
									<li><a href="review.jsp">강의평가</a>
									<li><a href="announcement.jsp">학교공지</a>
									</li>
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
										<header>
											<h2 align="center">컴공벗(cse-buddy)</h2>
											<p align="center">컴퓨터공학과 학교생활 도우미</p>
										</header>
									
										<p>&nbsp; &nbsp; &nbsp; &nbsp;매 학기 전 이번 학기에 어떤 수업을 필수로 들어야 하고, 
										남은 졸업여건은 어떻게 되는 지, 수업 시간은 언제고, 공강을 만들 수 있는지 등을 고려하여 시간표를 짜려고
										 하면 시간도 오래 걸리고,누군가 내 머리 속의 시간표를 최적으로 짜주었으면 하는 생각이 들곤 한다. 
										 따라서 사용자가 원하는 시간표를 이야기하면 시간표를 자동으로 완성해 여러 개의 예시를 띄워주는 기능을 
										 주요기능으로 하는, 시간표를 짜는 데 어려움을 느끼는 학생들의 어려움을 덜고자 하는 취지하에 동국대학교 컴퓨터공학과
										  학생들을 위한 시간표 자동 완성 웹 기반 소프트웨어를 개발하고자 한다. 본 팀의 S/W 제품의 주 사용자는 시간표 
										  작성에 어려움을 겪는 동국대학교 컴퓨터공학과 학생들이다. MSC, 일반교양, 전공 선이수, 전공 필수 과목 등 시간표를
										   짤 때 고려해야하는 사항들이 너무 많아 혼란을 겪고, 수강해야만 하는 과목을 미처 생각하지 못해 제때에 수강을 못하고, 
										   졸업이 가까워져 어려움을 겪는 학생들이 종종 있다. 따라서 이러한 어려움을 겪는 학생들을 위해서 웹페이지 기반의 정보공유 
										   플랫폼을 이용해 학생들이 시간표를 작성하는 수고를 조금이나마 덜어주는 것을 목표로 하고 있다.
										</p>
										
										
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
										<li>
											<span class="date">Jan <strong>27</strong></span>
											<h3><a href="#">Lorem dolor sit amet veroeros</a></h3>
											<p>Ipsum dolor sit amet veroeros consequat blandit ipsum phasellus lorem consequat etiam.</p>
										</li>
										<li>
											<span class="date">Jan <strong>27</strong></span>
											<h3><a href="#">Lorem dolor sit amet veroeros</a></h3>
											<p>Ipsum dolor sit amet veroeros consequat blandit ipsum phasellus lorem consequat etiam.</p>
										</li>
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
											<p>
												주소
											</p>
										</li>
										<li>
											<h3>Mail</h3>
											<p><a href="#">문의 이메일</a></p>
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
											<li>&copy;컴공벗</li><li>컴공벗조</li>
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