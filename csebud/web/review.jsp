<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\searchstyle.css" />
<link rel="stylesheet" href="css\jquery.rating.css" />
<link rel="stylesheet" href="css\review.css" />
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
							<li class="current"><a href="review">강의평가</a>
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
                     		<h2 style="text-align: center">강의평가 작성</h2>
                     		<br>
		                        <div style="width: 800px; min-height: 230px; margin: auto; border-radius: 10px; border: 4px; border-style: solid">
		                              <form id="form">
		                              <div
		                           style="width: 100%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: left; padding: 7 20 7 20;">
		                           <select name="lecturelist" id="lecturelist">
		                              <option value=""></option>
		                              <option value="09">09</option>
		                           </select>
		                        </div>
		                              <ul>
		                              <li><div style="padding-top:10px;">평가 :&nbsp&nbsp&nbsp<input type="text"></div></li>
		                              <li><textarea rows="1" column="10">a</textarea> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button>작성완료</button></li></ul></form>
		                           
		        	            </div>
        		             </div>
			
		                     </div>
		
		                  </div>
		                  
						<div class="noticebox">
							<div style="float: right">
								<form action="" method="">
									<input type="search" id="search" style="height: 44px;">
									<button id="button">Search</button>
								</form>
							</div>
							<br> <br>

							<h2 style="text-align: center">강의평가</h2><br>
							
							<c:forEach items="${list}" var="review">

								<div class="simplebox">
									<div
										style="width: 800px; min-height: 190px; margin: auto; border-radius: 10px; border: 4px; border-style: solid">
										<div
											style="width: 75%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: left; padding-top: 7px;">
											<font color="white"> ${review.lectureName}</font>
										</div>
										<div
											style="width: 25%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: right; padding-top: 7px;">
											<font color="white"> ${review.professor}</font>
										</div>
										<div style="width: 75%; min-height: 140px; float: left;">
											<div style="width: 75%; min-height: 40px; float: left;">
												<br>
												<div>
													&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 평가 : 
													<c:choose>
													<c:when test="${review.starval eq 0}">
													<img src="image\star-rating-0.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:when test="${review.starval eq 1}">
													<img src="image\star-rating-1.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:when test="${review.starval eq 2}">
													<img src="image\star-rating-2.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:when test="${review.starval eq 3}">
													<img src="image\star-rating-3.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:when test="${review.starval eq 4}">
													<img src="image\star-rating-4.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:when test="${review.starval eq 5}">
													<img src="image\star-rating-5.jpg" style="width: 100%; vertical-align: middle; width:90px" />
													</c:when>
													<c:otherwise>
													</c:otherwise>
													</c:choose>
												</div>
	
											</div>
											<div style="width: 75%; min-height: 100px; float: left">
												&nbsp&nbsp&nbsp&nbsp${review.content}</div>
										</div>
	
										<div
											style="width: 25%; min-height: 135px; float: right; text-align: center; padding-top: 10px; border-left: 4px; border-style: solid">
	
											<div id="box1"></div>
											작성자 ${review.writerId}
										</div>
	
									</div>
								
								</c:forEach>

							<br>
							<div style="float: right;">
							<a href="#page-wrapper"><img src="image\top.jpg" style="width: 100%; float: right; width:50px" /></a>
							</div>	

							</div>


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

	<script src='js\jquery.js' type="text/javascript"></script>
	<script src='js\jquery.MetaData.js' type="text/javascript"
		language="javascript"></script>
	<script src='js\jquery.rating.js' type="text/javascript"
		language="javascript"></script>

</body>
</html>