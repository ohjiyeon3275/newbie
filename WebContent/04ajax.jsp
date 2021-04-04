<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style>
form>span{
	display:none;
}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(function(){
	$("#myBtn").click(function(){
		$.ajax({
			url:"text/04.json",
			type:"get",
			data:"",
			dataType:"json",
			timeout:30000,
			cache:false,
			success:function(data){
				
				$(data).find("subject").each(function(){		
					var title=$(data).find("subject").find("title").text()
					var time=$(data).find("subject").find("time").text()
					var teacher=$(data).find("subject").find("teacher").text()
				
					var div=$("<div>");
					var p1=$("<p>").html(title);
					var p2=$("<p>").html(time);
					var p3=$("<p>").html(teacher);
				
					div.append(p1).append(p2).append(p3);
				
				
					$(".console").html(div);
				
				})
				
			}
		})
	});
	
})

</script>
</head>
<body>
	<input type="button" value="txt파일 가져오기" id="myBtn"/>
	<div class="console"></div>
</body>
</html>