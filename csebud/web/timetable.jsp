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
<link rel="stylesheet" href="css\timetable.css" />

<style type="text/css">
table tr td a {
   text-decoration: none;
   color: #666666;
}
</style>
<style type="text/css">
.tftable {
   font-size: 6px;
   color: #E6E6E6;
   width: 420px;
   border-width: 1px;
   border-color: #F5ECCE;
   border-collapse: collapse;
   empty-cell: true;
   table-layout: fixed;
   word-break: break-all;
}

.tftable th {
   font-size: 12px;
   font-weight: bold;
   background-color: #1C1C1C;
   border-width: 1px;
   border-style: solid;
   border-color: #F5ECCE;
   text-align: center;
   width: 100px;
}

.tftable tr {
   background-color: #E6E6E6;
   height: 5px;
}

.tftable td {
   font-size: 12px;
   border-width: 1px;
   padding: 0px;
   border-style: solid;
   border-color: #BDBDBD;
   text-align: center;
}

.tftable td:hover {
   background-color: #ffffff;
}
</style>
<SCRIPT type="text/javascript">
   function timeToindex(time) {

      switch (time) {
      case "0900":
         return 1;
      case "0930":
         return 2;
         break;
      case "1000":
         return 3;
         break;
      case "1030":
         return 4;
         break;
      case "1100":
         return 5;
         break;
      case "1130":
         return 6;
         break;
      case "1200":
         return 7;
         break;
      case "1230":
         return 8;
         break;
      case "1300":
         return 9;
         break;
      case "1330":
         return 10;
         break;
      case "1400":
         return 11;
         break;
      case "1430":
         return 12;
         break;
      case "1500":
         return 13;
         break;
      case "1530":
         return 14;
         break;
      case "1600":
         return 15;
         break;
      case "1630":
         return 16;
         break;
      case "1700":
         return 17;
         break;
      case "1730":
         return 18;
         break;
      case "1800":
         return 19;
         break;
      case "1825":
         return 20;
         break;
      case "1850":
         return 21;
         break;
      case "1915":
         return 23;
         break;
      case "1940":
         return 24;
         break;
      case "2005":
         return 25;
         break;
      case "2030":
         return 26;
         break;
      case "2105":
         return 27;
         break;
      case "2130":
         return 28;
         break;
      case "2155":
         return 29;
         break;
      case "2220":
         return 30;
         break;
      case "2245":
         return 31;
         break;
      case "월":
         return 1;
         break;
      case "화":
         return 2;
         break;
      case "수":
         return 3;
         break;
      case "목":
         return 4;
         break;
      case "금":
         return 5;
         break;

      default:
         return 50;

      }
   }

   function setTime(startrow, endrow, week, text) {

      var table1 = document.getElementById("table");

      //table1.rows[1].cells[1].innerHTML = "man";
      for (var j = startrow; j < endrow-1; j++) {
         table1.rows[j].cells[week].style.backgroundColor = "#018Dc8";
         table1.rows[j].cells[week].innerHTML = text;
      }
   }

   function removeTime(startrow, endrow, week) {

      var table1 = document.getElementById("table");
if(startrow=="50"||endrow=="49"||week=="50")
   return;
      //table1.rows[1].cells[1].innerHTML = "man";
      for (var j = startrow; j < endrow - 1; j++) {
         table1.rows[j].cells[week].style.backgroundColor = "#E6E6E6";
         table1.rows[j].cells[week].innerHTML = "";
      }
   }

   function isThere(startrow, endrow, week) {

      var table1 = document.getElementById("table");
      //alert("dd: " + startrow + endrow + week);
      //table1.rows[1].cells[1].innerHTML = "man";
      for (var j = startrow; j < endrow - 1; j++) {
         if (table1.rows[j].cells[week].innerHTML != "") {
            return true;
         }
      }

      return false;
   }

   function merge(startrow, endrow, week) {
      //alert("d"+startrow);
      var len = endrow - startrow - 1;
      var tObj = document.getElementById("table");

      if (1 < len) {

         tObj.rows[startrow].cells[week].rowSpan = len;
         for (var j = parseInt(startrow) + 1; j < parseInt(startrow) + len; j++) {

            tObj.rows[j].cells(week).style.display = "none";

         }

      }
   }

   function divide(startrow, endrow, week) {
      var len = endrow - startrow - 1;
      var tObj = document.getElementById("table");

      if (1 < len) {

         for (var j = parseInt(startrow) + 1; j < endrow - 1; j++) {

            tObj.rows[j].cells(week).style.display = "";

         }
         tObj.rows[startrow].cells[week].rowSpan = 1;

      }
   }

   function fn_text(obj) {

      var tr = obj.parentNode.parentNode;
      var v0 = parseInt(timeToindex(tr.cells[0].innerText));
      var v1 = parseInt(timeToindex(tr.cells[1].innerText))+ 1;
      var v2 = parseInt(timeToindex(tr.cells[2].innerText)) ;
      var v3 = parseInt(timeToindex(tr.cells[3].innerText));
      var v4 = parseInt(timeToindex(tr.cells[4].innerText)) + 1;
      var v5 = parseInt(timeToindex(tr.cells[5].innerText));
      var v6 = tr.cells[6].innerText;

      if (isThere(v0 + "", v1 + "", v2 + "")
            && isThere(tv3 + "", v4 + "", v5 + "")) {
         alert("해당 시간이 이미 차있습니다");
         return;
      }

      add_row(obj);
      setTime(v0, v1, v2, v6);
      merge(v0, v1, v2, v6);

      setTime(v3, v4, v5, v6);
      merge(v3, v4, v5, v6);

   }

   function add_row(obj) {
      //alert("add");
      var tr = obj.parentNode.parentNode;
      mytable = document.getElementById('mytable');
      row = mytable.insertRow(mytable.rows.length);

      for (var j = 0; j < 9; j++) {

         cell1 = row.insertCell(j)
         cell1.innerHTML = "<a href='#' onclick='delete_row(this);'>"
               + tr.cells[j].innerText + "<a>";
         if (j < 6) {
            cell1.style.display = "none";
         }
      }

   }

   function delete_row(obj) {
      var tr = obj.parentNode.parentNode;
      var v0 = parseInt(timeToindex(tr.cells[0].innerText));
      var v1 = parseInt(timeToindex(tr.cells[1].innerText))+ 1;
      var v2 = parseInt(timeToindex(tr.cells[2].innerText)) ;
      var v3 = parseInt(timeToindex(tr.cells[3].innerText));
      var v4 = parseInt(timeToindex(tr.cells[4].innerText)) + 1;
      var v5 = parseInt(timeToindex(tr.cells[5].innerText));

      removeTime(v0, v1, v2);
      divide(v0, v1, v2);
      removeTime(v3, v4, v5);
      divide(v3, v4, v5);


      var td = obj.parentNode.parentNode;
      td.parentNode.removeChild(td);
   }
</SCRIPT>

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
                        <h2>시간표 수동작성</h2>
                        <br> <br>
                     </center>
                     <div
                        style="padding: 50 50 50 50; float: left; background-color: white; width: 60%; height: 1200px;">
                        <table id="table" border=1 class="tftable">

                           <tr>
                              <th></th>
                              <th>월</th>
                              <th>화</th>
                              <th>수</th>
                              <th>목</th>
                              <th>금</th>
                           </tr>
                           <tr>
                              <th>09:00~09:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>

                           </tr>
                           <tr>
                              <th>09:30~10:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>10:00~10:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>10:30~11:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>11:00~10:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>11:30~11:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>12:00~12:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>12:30~13:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>13:00~13:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>13:30~14:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>14:00~14:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>14:30~15:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>15:00~15:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>15:30~16:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>16:00~16:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>16:30~17:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>17:00~17:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>17:30~18:00</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>18:00~18:25</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>18:25~18:50</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>18:50~19:15</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>19:15~19:40</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>19:40~20:05</th>
                              <td></td>
                              <td>sss</td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>
                           <tr>
                              <th>20:05~20:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                           <tr>
                              <th>20:30~21:05</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                           <tr>
                              <th>21:05~21:30</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                           <tr>
                              <th>21:30~21:55</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                           <tr>
                              <th>21:55~22:20</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                           <tr>
                              <th>22:20~22:45</th>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                           </tr>

                        </table>

                        <table id="mytable" border="2" cellspacing="0">
                           <th colspan="9">추가한 강의 목록</th>
                        </table>
                     </div>
                     <div
                        style="width: 40%; background-color: white; float: right; height: 1000px; padding: 50 50 50 50">

                        <div style="float: center; padding: 50 50 50 50">
                        과목이름으로 검색하기
                           <form action="lectureSearchProcess" method="POST">
                              <input type="search" name="search" id="search" style="height: 44px;">
                              <button id="button">Search</button>
                              </input>
                           </form>
                           <br> <br> <br> <br>
                        </div>
                        <div style="padding: 100 100 20 20">
                           <div style="width: 100%; height: 400px; overflow-y: auto">


                              <table class="timetable_table" style="width: 100%;">
                                 <thead>
                                    <tr class="timetable_tr">

                                       <th style="display: none;">시작시간1</th>
                                       <th style="display: none;">끝시간1</th>
                                       <th style="display: none;">요일1</th>
                                       <th style="display: none;">시작시간2</th>
                                       <th style="display: none;">끝시간3</th>
                                       <th style="display: none;">요일4</th>

                                       <td class="timetable_th" style="width: 25%">과목명
                                       </th>

                                       <td class="timetable_th" style="width: 25%">과목코드</td>
                                       <td class="timetable_th" style="width: 25%">교수명</td>
                                    </tr>
                                 </thead>
                                 <tbody>
 
                                 	<c:forEach items="${list}" var="lecture">
	                                    <tr class="timetable_tr">
	                                       <td style="display: none;">${lecture.firstStartTime}</td>
	                                       <td style="display: none;">${lecture.firstEndTime}</td>
	                                       <td style="display: none;">${lecture.firstWeekday}</td>
	                                       <td style="display: none;">${lecture.secondStartTime}</td>
	                                       <td style="display: none;">${lecture.secondEndTime}</td>
	                                       <td style="display: none;">${lecture.secondWeekday}</td>
	                                       <td class="timetable_td"><a href="#"
	                                          onclick="fn_text(this);">${lecture.lectureName}</a></td>
	                                       <td class="timetable_td">${lecture.lectureCode}</td>
	                                       <td class="timetable_td">${lecture.professor}</td>
	                                    </tr>
                                    </c:forEach>

                                 </tbody>
                              </table>
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
							<input type="button" value="메인페이지로" onclick="location.href='main'";>
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
	<script src="js\jquery.min.js"></script>
	<script src="js\jquery.dropotron.min.js"></script>
	<script src="js\skel.min.js"></script>
	<script src="js\skel-viewport.min.js"></script>
	<script src="js\util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="js\main.js"></script>

</body>
</html>