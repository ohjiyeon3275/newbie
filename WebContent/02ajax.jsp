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
	$("#category1").load(
			"text/category-data.html #category1-1",
		function(){
			$(this).show();
		}
	)
	
	$("#category1").change(function(){
		var target=$(this).find("option:selected").attr("data-target");
		
		$("category2").load(
			"text/category-data.html"+ target,
			function(){
				$(this).show();
			}
		)
	})
	
	$("#category2").change(function(){
		var target=$(this).find("option:selected")
	}
	
})

</script>
</head>
<body>
<h1> 동적 메뉴 </h1>
<div>
	<span id="category1"></span>
	<span id="category2"></span>
	<span id="category3"></span>
	
</div>

<div class="console">
</div>

</body>
</html>