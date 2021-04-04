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
<table width="500" border="1">
<tr>
	<td>이름</td><td><input type="text" name="bName" size="50"></td>
</tr>
<tr>
	<td>제목</td><td><input type="text" name="bTitle" size="50"></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="bContent" rows="10"></textarea></td>
</tr>
<tr>
	<td colspan='2'><input type="submit" value="수정">&nbsp;&nbsp;
	<a href="list.do">목록보기</a>
	<a href="delete.do?bId=${content_view.bId }">삭제하기</a>
	<a href="reply_view.do?bId="${content_view.bId }>답글달기</a>
	
	</td>
</tr>
</table>
</form>
</body>
</html>