<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function setIFrameHeight(obj){
    if(obj.contentDocument){
        obj.height = obj.contentDocument.body.offsetHeight + 40;
    } else {
        obj.height = obj.contentWindow.document.body.scrollHeight;
    }
    
    //각시간표에 내용 자동 자동채우기
    
    obj.contentWindow.fn_text("0900","1000","월","0900","1000","화","수학");
}
</script>

	
	추천강의

	<table width="100%" height="100%"
		style="table-layout: fixed; border-width: 1px;">
		<thead>
			<tr height="10%">
				<th>추천강의1</th>
				<th>추천강의2</th>
				<th>추천강의3</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="33.3%" height="600"><iframe src="make_timetable.jsp" name="window" width="100%
		" height="100%" align="right" frameborder="0" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight(this)" > </iframe></td>
				
				<td width="33.3%" height="600"><iframe src="make_timetable.jsp" name="window" width="100%
		" height="100%" align="right" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight(this)" > </iframe></td>
				
				<td width="33.3%" height="600"><iframe src="make_timetable.jsp" name="window" width="100%
		" height="100%" align="right" frameborder="0" framespacing="3" marginheight="3" marginwidth="3" scrolling="No" onLoad="setIFrameHeight(this)"> </iframe></td>

			</tr>
		</tbody>
	</table>
</body>
</html>