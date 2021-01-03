<%@ page import = "file.FileDAO" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
	<%
		String directory = "C:\\Users\\JY\\Desktop\\upload\\";
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
		
		Enumeration fileNames = multipartRequest.getFileNames();
		while(fileNames.hasMoreElements()){
			String parameter = (String) fileNames.nextElement();
			
			
			
			String fileName = multipartRequest.getOriginalFileName(parameter);
			String fileRealName = multipartRequest.getFilesystemName(parameter);
			
			if(fileName == null) continue;
			if(!fileName.endsWith(".docx") && !fileName.endsWith(".hwp") && !fileName.endsWith(".pdf") && !fileName.endsWith(".xlsx")){
				File file = new File(directory + fileRealName);
				file.delete();
				out.write("업로드 할 수 없는 확장자입니다.");
			}else{
				new FileDAO().upload(fileName, fileRealName);
				out.write("파일명" + fileName + "<br>");
				out.write("실제파일명" + fileRealName + "<br>");	
			}
		}
		
		
		
		
		
		
		
	%>
</body>
</html>