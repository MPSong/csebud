<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	function gotimetable() {

		window.opener.location.href = "timetable";
	    window.close();
		
	}
</script>
<link rel="stylesheet" href="css\recommend.css" />
</head>
<body>
	<div style="width: 100%; height: 400px; overflow-y: auto">
		<table class="timetable_table" style="width: 100%;">
			<thead>
				<tr class="timetable_tr">
					<td class="timetable_th" style="width: 50%">강의명</td>
					<td class="timetable_th" style="width: 25%">강의코드</td>
					<td class="timetable_th" style="width: 25%">강의구분</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${recLec}" var="lecture">

				<tr class="timetable_tr">
					<td class="timetable_td">${lecture.lname}</td>
					<td class="timetable_td">${lecture.lcode}</td>
					<c:choose>
					<c:when test="${lecture.ltype eq 'major'}">
					<td class="timetable_td">전공</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'basic'}">
					<td class="timetable_td">기본소양</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'common'}">
					<td class="timetable_td">기초교양</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'cultural'}">
					<td class="timetable_td">교양</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'mscMath'}">
					<td class="timetable_td">MSC수학</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'mscScience'}">
					<td class="timetable_td">MSC과학</td>
					</c:when>
					<c:when test="${lecture.ltype eq 'mscProcess'}">
					<td class="timetable_td">MSC전산</td>
					</c:when>
					<c:otherwise>
					<td class="timetable_td"></td>
					</c:otherwise>
					</c:choose>
				</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
		<br><center><button onclick="javascript:gotimetable();">시간표 작성하러 가기</button></center>
	</div>	
</body>
</html>