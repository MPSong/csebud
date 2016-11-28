<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>


<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\searchstyle.css" />
<link rel="stylesheet" href="css\jquery.rating.css" />
<link rel="stylesheet" href="css\review.css" />

<style type="text/css">
textarea {
	width: 1000px;
}
</style>
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
						<li class="current"><a href="review.jsp">강의평가</a>
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
							<h2 style="text-align: center">강의평가</h2>
							<br>
							<div
								style="width: 800px; min-height: 230px; margin: auto; border-radius: 10px; border: 4px; border-style: solid">
								<form id="form">
									<div
										style="width: 100%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: left; padding: 7 20 7 20;">
										<select name="lecturelist" id="lecturelist">
											<option value=""></option>
											<option value="09">09</option>
										</select>
									</div>
									<ul>
										<li><div style="padding-top: 10px;">
												평가 :&nbsp&nbsp&nbsp<input type="text">
											</div></li>
										<li><textarea rows="1" column="10">a</textarea>
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
											<button>작성완료</button></li>
									</ul>
								</form>

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

						<div class="simplebox">
							<div
								style="width: 800px; min-height: 190px; margin: auto; border-radius: 10px; border: 4px; border-style: solid">
								<div
									style="width: 75%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: left; padding-top: 7px;">
									<font color="white"> 소프트웨어 공학</font>
								</div>
								<div
									style="width: 25%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: right; padding-top: 7px;">
									<font color="white"> 최은만</font>
								</div>
								<div style="width: 75%; min-height: 140px; float: left;">
									<div style="width: 75%; min-height: 40px; float: left;">


										<div>
											<label for="test-1-rating-1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp평가:</label>
											<input class="star" type="radio" name="test-1-rating-1"
												value="N" title="No" disabled="disabled" /> <input
												class="star" type="radio" name="test-1-rating-1" value="M"
												title="Maybe" disabled="disabled" /> <input class="star"
												type="radio" name="test-1-rating-1" checked="checked"
												disabled="disabled" />
										</div>

									</div>
									<div style="width: 75%; min-height: 100px; float: left">
										배울게 많고 성적도 잘주고 흥미유발도 좋고 엄청재밌고</div>
								</div>

								<div
									style="width: 25%; min-height: 135px; float: right; text-align: center; padding-top: 10px; border-left: 4px; border-style: solid">

									<div id="box1"></div>
									작성자 xx
								</div>


							</div>

							<br>
							<div
								style="width: 800px; min-height: 190px; margin: auto; border-radius: 10px; border: 4px; border-style: solid">
								<div
									style="width: 75%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: left; padding-top: 7px;">
									<font color="white"> 소프트웨어 공학</font>
								</div>
								<div
									style="width: 25%; min-height: 50px; text-align: center; vertical-align: center; background-color: #018dc8; float: right; padding-top: 7px;">
									<font color="white"> 최은만</font>
								</div>
								<div style="width: 75%; min-height: 140px; float: left;">
									<div style="width: 75%; min-height: 40px; float: left;">


										<div>
											<label for="test-1-rating-2">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp평가:</label>

											<input class="star" type="radio" name="test-1-rating-2"
												value="M" title="Maybe" disabled="disabled" /> <input
												class="star" type="radio" name="test-1-rating-2" value="M"
												title="Maybe" disabled="disabled" /> <input class="star"
												type="radio" name="test-1-rating-2" checked="checked"
												disabled="disabled" />
										</div>

									</div>
									<div style="width: 75%; min-height: 100px; float: left">
										배울게 많고 성적도 잘주고 흥미유발도 좋고 엄청재밌고</div>
								</div>

								<div
									style="width: 25%; min-height: 135px; float: right; text-align: center; padding-top: 10px; border-left: 4px; border-style: solid">

									<div id="box1"></div>
									작성자 xx
								</div>


							</div>
							<br> <br>
							<div class="fp_service_box fp_c1"></div>
							<div class="tooplate_paging">
								<ul>
									<li><a href="#" target="_parent">Previous</a></li>
									<li><a href="#" target="_parent">1</a></li>
									<li><a href="#" target="_parent">2</a></li>
									<li><a href="#" target="_parent">3</a></li>
									<li><a href="#" target="_parent">4</a></li>
									<li><a href="#" target="_parent">5</a></li>
									<li><a href="#" target="_parent">6</a></li>
									<li><a href="#" target="_parent">Next</a></li>
								</ul>

								<div class="cleaner"></div>

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