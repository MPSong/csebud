<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="css\style.css" />
		<link rel="stylesheet" href="css\loginstyle.css"/>
	</head>
	<body class="homepage">
		<div id="page-wrapper">
				
			<!-- Header -->
				<div id="header-wrapper">
					<div id="header">
					<div style="min-width:1200px;">
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
							<h1><a href="main"><img src="image\logo.jpg" style="width: 100%; vertical-align: middle; width:1200px" /></a></h1>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li><a href="lecture">강의정보</a></li>
									<li><a href="timetable">시간표작성</a>
										<ul>
											<li><a href="timetable">시간표 작성</a></li>
											<li><a href="timetable_auto">시간표 자동작성</a></li>
										</ul></li>
									<li><a href="personal_data">학사관리</a>
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
						<div class="noticebox">
							<div class="form">
								<c:choose>
                     	
		                     		<c:when test="${not empty sessionScope.userLoginInfo}">			
										
										<form action="logoutProcess">
										<br>
										<center><img src="image\face_.jpg" style="width: 100%; vertical-align: middle; width:85px" /></center>
				   						<br><b><c:out value="${sessionScope.userLoginInfo.name}"/></b>님 환영합니다!
				   						<br><br>
				   						<button>로그아웃</button>
				   						</form>
				    					
				    				</c:when>
				    				
				    				<c:otherwise>
				    				
				   						<form action="loginProcess">
				      					<label>ID<input type="text" name="id" id="id"></label>
				      					<label>비밀번호<input type="password" name="password" id="password"></label>
				      					<button>로그인</button>
				    					</form>
				    							    				
				    				</c:otherwise>
		    				
		    					</c:choose>
							</div>
						</div>
						<div class="noticebox" style="min-height: 800px;">
						
							<header>
								<h2 align="center">컴공벗(cse-buddy)</h2>
								<p align="center">컴퓨터공학과 학교생활 도우미</p>
							</header>
						
							<div style="width: 50%; min-height: 50px; float: left; padding: 18px;">
								<p>&nbsp; &nbsp; &nbsp;매 학기 전 이번 학기에 어떤 수업을 필수로 들어야
								하고, 남은 졸업여건은 어떻게 되는 지, 수업 시간은 언제고, 공강을 만들 수 있는지 등을 고려하여 시간표를 짜려고
								하면 시간도 오래 걸리고,누군가 내 머리 속의 시간표를 최적으로 짜주었으면 하는 생각이 들곤 한다.<br><br>
								&nbsp; &nbsp; &nbsp;따라서 사용자가
								원하는 시간표를 이야기하면 시간표를 자동으로 완성해 여러 개의 예시를 띄워주는 기능을 주요기능으로 하는, 시간표를
								짜는 데 어려움을 느끼는 학생들의 어려움을 덜고자 하는 취지하에 동국대학교 컴퓨터공학과 학생들을 위한 시간표 자동
								완성 웹 기반 소프트웨어를 개발하고자 한다. 
								<br><br>&nbsp; &nbsp; &nbsp;본 팀의 S/W 제품의 주 사용자는 시간표 작성에 어려움을 겪는
								동국대학교 컴퓨터공학과 학생들이다. MSC, 일반교양, 전공 선이수, 전공 필수 과목 등 시간표를 짤 때
								고려해야하는 사항들이 너무 많아 혼란을 겪고, 수강해야만 하는 과목을 미처 생각하지 못해 제때에 수강을 못하고,
								졸업이 가까워져 어려움을 겪는 학생들이 종종 있다. 따라서 이러한 어려움을 겪는 학생들을 위해서 웹페이지 기반의
								정보공유 플랫폼을 이용해 학생들이 시간표를 작성하는 수고를 조금이나마 덜어주는 것을 목표로 하고 있다.</p>
							</div>
							<div style="width: 50%; min-height: 50px; float: right;">
								<br><center><h1><img src="image\intro.jpg" style="width: 100%; vertical-align: middle; width:550px" /></h1></center>
							</div>
							
							<br><br><br><br><br><br>

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
		<div style="position: fixed; bottom: 50px; right: 80px;">
			<a href="#header-wrapper"> <img src="image/top.png" title="위로 가기"
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