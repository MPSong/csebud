<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="css\style.css" />
		<link rel="stylesheet" href="css\registerstyle.css"/>
	</head>
	<body class="right-sidebar">
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
		                           <li><a>시간표작성</a>
		                              <ul>
		                                 <li><a href="timetable">시간표 작성</a></li>
		                                 <li><a href="timetable_auto">시간표 자동작성</a></li>
		                              </ul>
		                           </li>
		                           <li><a>학사관리</a>
		                              <ul>
		                                 <li><a href="personal_data">개인정보 입력</a></li>
		                                 <li><a href="graduation">졸업요건관리</a></li>
		                              </ul>
		                           </li>
		                           <li><a href="review">강의평가</a>
		                           <li><a href="announcement">학교공지</a>
		                           </li>
		                        </ul>
		                     </nav>

					</div>
				</div>

         <!-- Main -->
            <div id="main-wrapper">
               <div  class="form" style="border-radius:30px">
               <br><br>
                  <form name="Register" var="Register" method="post" action="registerProcess">
                     <div>
                     <p class="contact"><label><font size="4">ID</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="text" name="id" placeholder="id" />
                        </div>
                        <br>
                        <p class="contact"><label><font size="4">PW</font></label></p> 
                        <div style="margin-top:20px; margin-bottom:20px;">
                           <input type="password" name="pass" placeholder="password" />
                        </div><p class="contact"><label><font size="4">PW재입력</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="password" name="pass" placeholder="password" />
                        </div>
                        <br>
                        <p class="contact"><label><font size="4">이름</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="text" name="name" placeholder="name" />
                        </div>
                        <br>
                        <p class="contact"><label><font size="4">전화번호</font></label></p> 
                        <div style="margin-top:20px; maring-bottom:20px;">
                           <input type="text" name="phone" placeholder="010XXXXXXXXX" />
                        </div>
                        <p class="contact"><label><font size="4">Email</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="email" name="email" placeholder="*@*.*" />
                        </div>
                        <br>
                        <p class="contact"><label><font size="4">학번</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="text" name="studentId" placeholder="201XXXXXXX" />
                        </div>
                        회원님의 학번은 졸업요건 확인, 시간표 자동작성 알고리즘에 사용됩니다.
                     </div>                           
                     <br>
                     <div>
                     	<br>
                        <div>
                           &nbsp&nbsp<input type="submit" class="button alt" value="회원가입" style="width:100px;"/>
                           &nbsp&nbsp
                           <input type="reset" class="button alt" value="취소" style="width:100px;"/>
                        </div>
                     </div>
                  </form>
               </div>
               
				<br>
				<br>	               
               
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