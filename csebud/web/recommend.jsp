<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script language="javascript">
	function gotimetable() {

		window.opener.location.href = "timetable.jsp";
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
					<td class="timetable_th" style="width: 25%">시간</td>
					<td class="timetable_th" style="width: 25%">교수</td>
				</tr>
			</thead>
			<tbody>

				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
				<tr class="timetable_tr">
					<td class="timetable_td">소프트웨어 공학개론</td>
					<td class="timetable_td">cse2000</td>
					<td class="timetable_td">최은만</td>
				</tr>
			</tbody>
		</table>
	</div>
	<center><button onclick="javascript:gotimetable();">시간표 작성하러 가기</button></center>
</body>
</html>