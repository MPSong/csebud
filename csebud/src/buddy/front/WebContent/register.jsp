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
                           <li><a href="main.jsp">Home</a></li>
                           <li>
                              <a>사이트공지</a>
                              <ul>
                                 <li><a href="introduction.jsp">사이트설명</a></li>
                                 <li><a href="notice.jsp">개발자공지</a></li>
                              </ul>
                           </li>
                           <li><a>시간표작성</a>
                              <ul>
                                 <li><a href="timetable.jsp">시간표 작성</a></li>
                                 <li><a href="timetable_auto.jsp">시간표 자동작성</a></li>
                                 <li><a href="lecture.jsp">강의정보</a></li>
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