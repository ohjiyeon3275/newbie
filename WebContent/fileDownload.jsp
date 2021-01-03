<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "file.FileDTO" %>
<%@ page import = "file.FileDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ArrayList<FileDTO> fileList = new FileDAO().getList();

for(FileDTO file : fileList){
	out.print("<a href =\"" + request.getContextPath() + "/downloadAction?file="+java.net.URLEncoder.encode(file.getFileRealName(), "UTF-8")+"\">"+
	file.getFileName() + "(다운로드 횟수 : "+ file.getDownloadCount() + ")</a><br>");
	
}
%>
</body>
</html>