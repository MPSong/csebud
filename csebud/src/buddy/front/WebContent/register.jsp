<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
               <ul>
                  <li><a href="main.jsp">로그인</a></li><li class="line1">|</li>
                  <li><a href="register.jsp">회원가입</a></li>
               </ul>
               </td></tr>
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
                           <li><a>시간표작성</a>
                              <ul>
                                 <li><a href="timetable.jsp">시간표 작성</a></li>
                                 <li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
                              </ul>
                           </li>
                           <li><a>학사관리</a>
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
                           <input type="email" name="phone" placeholder="010XXXXXXXXX" />
                        </div>
                        <p class="contact"><label><font size="4">Email</font></label></p> 
                        <div style="margin-top:20px">
                           <input type="email" name="email" placeholder="*@*.*" />
                        </div>
                     </div>                           
                     <br>
                     <div>
                        <div>
                           <input type="submit" class="button alt" value="Register" />
                        </div>
                     </div>
                  </form>
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