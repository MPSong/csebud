<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css\style.css" />
<link rel="stylesheet" href="css\loginstyle.css" />
<link rel="stylesheet" href="css\timetable_auto.css" />

<script>
   function setIFrameHeight(obj) {

      //각시간표에 내용 자동 자동채우기
	<c:forEach items="${lecauto}" var="lecture">
		obj.contentWindow.fn_text("${lecture.firstStartTime}", "${lecture.firstEndTime}", "${lecture.firstWeek}", "${lecture.secondStartTime}", "${lecture.secondEndTime}", "${lecture.secondWeek}", "${lecture.lectureName}");
	</c:forEach>
	
   }
   
</script>
<style type="text/css">
input [type="button"]
{
	background-color:#018dc8;
}
#disabled{
width:150px;
background-color:#d52349; 
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

               <a href="main.jsp"><img src="image\logo.jpg"
                  style="width: 100%; vertical-align: middle; width: 1200px" /></a>
            </h1>

            <!-- Nav -->
            <nav id="nav">
               <ul>
                  <li><a href="lecture">강의정보</a></li>
                  <li class="current"><a href="timetable">시간표작성</a>
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
 	<c:choose>

	<c:when test="${not empty sessionScope.userLoginInfo}">
      <div id="main-wrapper">
         <div class="container">
            <div class="row">
               <div class="12u">



                  <!-- Content -->
                  <div
                     style="min-width: 1100px; background-color: white; padding: 50 0 0 0">
                     <br><center>
                        <h2>시간표 자동작성</h2>
                     </center><br>
                     <div
                        style="padding: 50 50 50 50; float: left; background-color: white; width: 60%; height: 1200px;">
                        <iframe src="ex_timetable.jsp" name="window" width="100%
      "
                           height="100%" align="right" frameborder="0" frameborder="0"
                           framespacing="3" marginheight="3" marginwidth="3"
                           scrolling="No" onLoad="setIFrameHeight(this)"> </iframe>
                     </div>
                     <div
                        style="width: 40%; background-color: white; float: right; height: 1200px; padding: 50 50 0 0">
                        <div style="float: right;">
                           <c:choose>
                           	  <c:when test="${empty lecauto}">
                              <a
                                 onclick="window.open('auto','new','resizable=no width=700 height=570');return false">
                                 <!-- target="_blank" -->
                                 <input type="button" id="button" value="시간표 작성">
                              </a>
                              </c:when>
                              <c:otherwise>
                              <input type="button"  id="disabled"  value="작성완료" disabled>
                           	  </c:otherwise>
                           </c:choose>
                        </div>
                        <br><br>
                        <div style="float: right; width:100%; padding-top:100px;">
                           <table id="mytable" border="0" cellspacing="0"
                              style="font-size: 15px; text-align:center; color:black;">
                              <tr>
                              <th colspan="3"><h2>추가한 강의 목록</h2><br></th>
                              </tr>
                              <tr>
                              <td width="30%">학수번호/분반</td>
                              <td width="50%">강의명</td>
                              <td width="20%">교수</td>
                              </tr>
                              <c:forEach items="${lecauto}" var="lecture">
                              <tr>
                              <td width="30%">${lecture.lectureInfo}-${lecture.division}</td>
                              <td width="50%">${lecture.lectureName}</td>
                              <td width="20%">${lecture.professor}</td>
                              </tr>
                              </c:forEach>
                           </table>
                        </div>
                        <div style="padding: 100 0 20 20">
                           <div style="width: 100%; height: 400px; overflow-y: auto">

                           </div>
                        </div>

                     </div>
                  </div>

               </div>

            </div>
         </div>

      </div>

	</c:when>
	<c:otherwise>
		<div id="main-wrapper">
			<div class="container">
				<div class="row">
					<div class="12u">

						<!-- Content -->
						<div style="min-width:1100px; height: 900px; background-color:white;">
						<br><br>
						<center><div>
							<img src="image/sorry.png"></div>
							<font face="Impact, Charcoal, sans-serif" color="black" size="50"><h1>Sorry,<br><br> Please, Login First!!</h1></font>
							<br><br><br>
							<input type="button" value="메인페이지로" onclick="location.href='main.jsp'";>
						</div>
						
						</center>

					</div>

				</div>
			</div>
		</div>	
	</c:otherwise>
	</c:choose>

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
   <script src="js\jquery.min.js">
      
   </script>
   <script src="js\jquery.dropotron.min.js"></script>
   <script src="js\skel.min.js"></script>
   <script src="js\skel-viewport.min.js"></script>
   <script src="js\util.js"></script>
   <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
   <script src="js\main.js"></script>




</body>
</html>