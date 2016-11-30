<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>


<style type="text/css">
table tr td a {
	text-decoration: none;
	color: #666666;
}
</style>
<style type="text/css">
.tftable {
	font-size: 5px;
	color: #E6E6E6;
	width: 100%;
	border-width: 1px;
	border-color: #F5ECCE;
	border-collapse: collapse;
	empty-cell: true;
	table-layout: fixed;
	word-break: keap-all;
	height: 100%;
	
}

.tftable th {
	font-size: 10px;
	font-weight: bold;
	background-color: #1C1C1C;
	border-width: 1px;
	border-style: solid;
	border-color: #F5ECCE;
	text-align: center;
}

.tftable tr {
	font-size: 5px;
	background-color: #E6E6E6;
	height: 0.1;
}

.tftable td {
	font-size: 5px;
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
		for (var j = startrow; j < endrow; j++) {
			table1.rows[j].cells[week].style.backgroundColor = "#018Dc8";
			table1.rows[j].cells[week].innerHTML = text;
		}
	}

	function removeTime(startrow, endrow, week) {

		var table1 = document.getElementById("table");
		if (startrow == "50" || endrow == "50" || week == "50")
			return;
		//table1.rows[1].cells[1].innerHTML = "man";
		for (var j = startrow; j < endrow; j++) {
			table1.rows[j].cells[week].style.backgroundColor = "#E6E6E6";
			table1.rows[j].cells[week].innerHTML = "";
		}
	}

	function isThere(startrow, endrow, week) {

		var table1 = document.getElementById("table");
		
		//table1.rows[1].cells[1].innerHTML = "man";
		for (var j = startrow; j < endrow; j++) {
			if (table1.rows[j].cells[week].innerHTML != "") {
				
				return true;
			}
		}
		//alert("dd: ");
		return false;
	}

	function merge(startrow, endrow, week) {
		//alert("d"+startrow);
		var len = endrow - startrow;
		var tObj = document.getElementById("table");

		if (1 < len) {

			tObj.rows[startrow].cells[week].rowSpan = len;
			for (var j = parseInt(startrow) + 1; j < parseInt(startrow) + len; j++) {

				tObj.rows[j].cells(week).style.display = "none";

			}

		}
	}

	function divide(startrow, endrow, week) {
		var len = endrow - startrow;
		var tObj = document.getElementById("table");

		if (1 < len) {

			for (var j = parseInt(startrow) + 1; j < endrow; j++) {

				tObj.rows[j].cells(week).style.display = "";

			}
			tObj.rows[startrow].cells[week].rowSpan = 1;

		}
	}

	function fn_text(start1, end1,week1,start2, end2, week2,value) {

		
		var v0 = parseInt(timeToindex(start1));
		var v1 = parseInt(timeToindex(end1)) + 1;
		var v2 = parseInt(timeToindex(week1));
		var v3 = parseInt(timeToindex(start2));
		var v4 = parseInt(timeToindex(end2)) + 1;
		var v5 = parseInt(timeToindex(week2));
		var v6 = value;
		
		
		if (isThere(v0 + "", v1 + "", v2 + "")|| isThere(v3 + "", v4 + "", v5 + "")) {
			alert("해당 시간이 이미 차있습니다");
			return ;
		}
		add_row(v6);
		//alert(v0+" ,"+v1+" ,"+v2+" ,"+v3+" ,"+v4+" ,"+v5+" ,"+v6);

		setTime(v0, v1, v2, v6);
		merge(v0, v1, v2, v6);
		setTime(v3, v4, v5, v6);
		merge(v3, v4, v5, v6);

	}

	function add_row(value) {
		
		mytable = document.getElementById('mytable');
		row = mytable.insertRow(mytable.rows.length);
		
		cell1 = row.insertCell(0);
		cell1.innerHTML = value ;
		
	}

	function delete_row(obj) {
		var tr = obj.parentNode.parentNode;
		var v0 = parseInt(timeToindex(tr.cells[0].innerText));
		var v1 = parseInt(timeToindex(tr.cells[1].innerText)) + 1;
		var v2 = parseInt(timeToindex(tr.cells[2].innerText));
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
<body>



	<table id="table" border=1 class="tftable">



		<tr>
			<th width=16%></th>
			<th width=14% >월</th>
			<th width=14%>화</th>
			<th width=14%>수</th>
			<th width=14%>목</th>
			<th width=14%>금</th>
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
			<td></td>
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


	<table id="mytable" border="0" cellspacing="0" style="font-size: 12px;">
		<th colspan="9">추가한 강의 목록</th>
	</table> 




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