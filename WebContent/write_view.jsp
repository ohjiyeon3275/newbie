<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
write_view 페이지
<form action="write.do" method="post">
<input type="hidden" name="bId" value="${content_view.bId }">
<table width="500" border="1">
<tr>
	<td>번호</td><td> ${content_view.bId }</td>
</tr>
<tr>
	<td>이름</td><td><input type="text" name="bName" size="50" value="${content_view.bName }"></td>
</tr>
<tr>
	<td>제목</td><td><input type="text" name="bTitle" size="50" value="${content_view.bTitle }"></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="bContent" rows="10">${content_view.bContent }</textarea></td>
</tr>
<tr>
	<td colspan='2'><input type="submit" value="입력">&nbsp;&nbsp;<a href="list.do">목록보기</a></td>
</tr>
</table>
</form>
</body>
</html>