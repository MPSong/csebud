<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function setIFrameHeight1(obj){
  
	//각시간표에 내용 자동 자동채우기

	
	<c:forEach items="${timefst}" var="lecture">
		obj.contentWindow.fn_text("${lecture.firstStartTime}", "${lecture.firstEndTime}", "${lecture.firstWeek}", "${lecture.secondStartTime}", "${lecture.secondEndTime}", "${lecture.secondWeek}", "${lecture.lectureName}");
	</c:forEach>
	
	
}
function setIFrameHeight2(obj){
    
    //각시간표에 내용 자동 자동채우기
    
	<c:forEach items="${timesec}" var="lecture">
		obj.contentWindow.fn_text("${lecture.firstStartTime}", "${lecture.firstEndTime}", "${lecture.firstWeek}", "${lecture.secondStartTime}", "${lecture.secondEndTime}", "${lecture.secondWeek}", "${lecture.lectureName}");
	</c:forEach>
    
	
}
function setIFrameHeight3(obj){
	
    //각시간표에 내용 자동 자동채우기
    
	<c:forEach items="${timethd}" var="lecture">
		obj.contentWindow.fn_text("${lecture.firstStartTime}", "${lecture.firstEndTime}", "${lecture.firstWeek}", "${lecture.secondStartTime}", "${lecture.secondEndTime}", "${lecture.secondWeek}", "${lecture.lectureName}");
	</c:forEach>
    
}

function gotimetable1() {

	window.opener.parent.location.href = "timetable1";
    window.close();
	
}

function gotimetable2() {

	window.opener.parent.location.href = "timetable2";
    window.close();
	
}

function gotimetable3() {

	window.opener.parent.location.href = "timetable3";
    window.close();
	
}
</script>
<style type="text/css">
input[type="button"], input[type="submit"], button {
	-webkit-appearance: none;
	display: inline-block;
	text-decoration: none;
	cursor: pointer;
	border: 0;
	border-radius: 5px;
	background: #018dc8;
	color: #fff !important;
	font-weight: 700;
	outline: 0;
	width: 70%;
	height: 30px; 
	-moz-transition: background-color .25s ease-in-out;
	-webkit-transition: background-color .25s ease-in-out;
	-ms-transition: background-color .25s ease-in-out;
	transition: background-color .25s ease-in-out;
}
input[type="button"]:hover, input[type="submit"]:hover, input[type="reset"]:hover,
	button:hover, .button:hover {
	background: #e53359;
}
</style>

</head>
<body>
	<div style="width:700px; height:550px; overflow-y:auto;">
	<table width="100%" height="100%"
		style="table-layout: fixed; border-width: 1px; ">
		
		<tbody>
			<tr>
				<td width="33.3%" height="500"><iframe src="auto_timetable.jsp" name="window" width="100%
		"  height="100%" align="right" frameborder="0" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight1(this)" > </iframe></td>
				
				<td width="33.3%" height="500"><iframe src="auto_timetable.jsp" name="window" width="100%
		" height="100%" align="right" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight2(this)" > </iframe></td>
				
				<td width="33.3%" height="500"><iframe src="auto_timetable.jsp" name="window" width="100%
		" height="100%" align="right" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight3(this)"> </iframe></td>

			</tr>
			<tr>
			<td><center><button type="button" onclick="javascript:gotimetable1();">시간표 1 선택</button></center></td>
			<td><center><button type="button" onclick="javascript:gotimetable2();">시간표 2 선택</button></center></td>
			<td><center><button type="button" onclick="javascript:gotimetable3();">시간표 3 선택</button></center></td>
			</tr>
		</tbody>
	</table>
	</div>	
</body>
</html>