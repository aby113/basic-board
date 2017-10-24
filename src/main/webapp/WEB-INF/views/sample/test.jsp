<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<form:form id="tesfForm" commandName="memberDTO" action="/basic/sample/checkId" method="post">
			<ul>
				<li>이메일:<form:input path="email" id="email" />@ 
				<select id="emailSelect">
						<option value="@naver.com">naver.com</option>
						<option value="@daum.net">daum.net</option>
						<option value="@nate.com">nate.com</option>
				</select>
				</li>
				<li>
					<form:errors path="email" cssClass="error" />
				</li>
				<li>
					아이디:<form:input path="id" id="id" />
					<div><button type="button" id="idBtn">아이디확인</button></div>
				</li>
				<li>
					<form:errors path="id" cssClass="error" />
				</li>
				<li>
					비번:<form:input path="pw" id="pw"/>
					비번확인:<form:input path="pwConfirm" id="pwConfirm"/>	
				</li>
				<li>
					<form:errors path="pw" cssClass="error" />
				</li>
			</ul>
		</form:form>
	</fieldset>
	<script>
	$(function(){
		var contextPath = "/basic";
		$("#idBtn").on("click", function(){
			
			console.log("아이디버튼 클릭");
			var url = contextPath + "/sample/checkAjaxId";
			
			$.ajax({
				type : 'post',
				url : url,
				headers:{
					"Content-Type": "application/json",
					"X-HTTP-Method-Override": "POST"
				},
				dataType:'text',
				data:JSON.stringify({
					email:''
				}),
				success:function(result){
					console.log(result);
					alert("성공");
				},
				statusCode:{
					400:function(result){
						console.log(result);
					}
				}
				
				
			});
			
			
			
			
		});
		
		
		
		
	});
	
	
	
	
	</script>

</body>
</html>