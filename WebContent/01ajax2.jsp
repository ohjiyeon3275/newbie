<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(function(){
	$("#checkid").click(function(){
		var input_value=$("input[name='user_id']").val();
		if(!input_value){
			alert("아이디를 입력하세요");
			$("input[name='user_id']").focus();
			return false;
		}
		
		var url = "text/idcheck_fail.xml";
		var url = "text/idcheck_ok.xml";
		
		
		$.get(url, {
			"user_id":input_value
		}, function(data){
			var result_text=$(data).find("result").text();
			var result = eval(result_text)
			if(result){
				$(".console").html("<span style='color:blue'>")+
					"사용할 수 있는 아이디"+"</span>";
			}else{
				$(".console").html("<span style='color:blue'>")+
				"사용할 수 없는 아이디"+"</span>";
			}
		})
	})
})

</script>
</head>
<body>
<h1 class="title">아이디 중복검사</h1>
		<div class="exec">
			<form>
				<input type="text" name="user_id" />
				<input type="button" id="checkid" value="중복검사" />
			</form>
		</div>
		<div class="console"></div>

</body>
</html>