<%@ page contentType="text/html; charset=utf-8" %>
<!-- 파일 업로드 기능을 구현한 페이지입니다 -->
<html>

<script>        /*파일 전송메뉴 기능한 소스입니다*/
function checkForm() {   
 if (upload.file1.value == "") {           /*업로드한 파일이 없을 경우 없다고 표시합니다*/
  alert("파일을 업로드해주세요.");   
  return false;   
 }  else if(!checkFileType(upload.file1.value)) {           /*업로드한 문서가 엑셀파일이 아닐경우 출력합니다*/
  alert("엑셀파일만 업로드 해주세요.");   
  return false;   
 }   
  document.upload.submit();
}   
function checkFileType(filePath){      /*파일의 타입을 체크하는 기능입니다*/
  
 var fileLen = filePath.length;   
 var fileFormat = filePath.substring(fileLen - 4);   
 fileFormatfileFormat = fileFormat.toLowerCase();   
  
}   
</script>  
 
<body>
<form action="excel_insert.jsp" name="upload" method="POST" enctype="multipart/form-data">
<td><input type="file" name="file1" size="20" align="absmiddle" />    </td>     <!--  파일업로드하는 바를 구현한 부분입니다-->
<td><a onclick="checkForm();" style="cursor:hand"> [전송] </a></td>       <!--  업로드한 파일을 전송하는 부분입니다-->
<br><br>
</form>
</body>
 
</html>