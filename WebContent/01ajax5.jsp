<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(function(){
	$("#myBtn").click(function(){
		$.ajax({
			url:"wServlet",
			type:"get",
			data:"stnId=108",
			dataType:"xml",
			timeout:30000,
			cache:false,
			success:function(data){
				$(".console").html(data);
				$(data).find("data").each(function(){
					var title=$(this).tind("wf").text()
					console.log(title)
				})
			}
		})
	})
})

</script>
</head>
<body>

<input type="button" value="txt파일 가져오기" id="myBtn"/>
<div class="console">

</div>
</body>
</html>