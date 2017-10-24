<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
var bno = "${boardVO.bno}";
var page = "${cri.page}";
var perPageNum = "${cri.perPageNum}";
var searchType = "${cri.searchType}";
var keyword = "${cri.keyword}";
var msg = "${param.msg}";
$(function(){
	

	if(msg == "LOGIN_FAIL"){
		alert("로그인 하세요");
		console.log(msg);
		location.href = contextPath + "/board/listPage";
	}
	
	$("#loginBtn").on("click", function(){
		console.log("로그인버튼 클릭");
		var email = $("#email").val();
		var pw = $("#pw").val();
		console.log("email:"+email+", pw:" + pw);
		$.ajax({
			type:'post',			
			url:contextPath + "/member/login",
			headers:{
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST"
			},
			dataType:'text',
			data:JSON.stringify({
				email : email,
				pw : pw
			}),
			success:function(){
				 $("#email").val("");
				 $("#pw").val("");
				 alert("로그인 성공");
				 location.reload();
			},
			statusCode:{
				400:function(){
					 $("#email").val("");
					 $("#pw").val("");
					alert("로그인 실패");
				}
			} 
				
		});
		
		
	});
	
	
	
});

</script>
<link rel="stylesheet" href="<c:url value='/resources/css/board.css' />">
<link rel="stylesheet" href="<c:url value='${cssPath}' />">
<c:if test="${cssPath2 ne null}">
	<link rel="stylesheet" href="<c:url value='${cssPath2}'/>">
</c:if>
<script type="text/javascript" src="<c:url value='/resources/js/commonBtn.js' />"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>${title}</title>
</head>
<body>
	<div id="wrap">
		<header class="header">
			<nav>

				<a href="#">HOME</a> 
				<a href="<c:url value='/board/listPage'/>">toyProject#board</a> 
				<span
					id="loginBox">
				<c:if test="${login eq null}">	
					<input type="text" id="email" name="email"
					placeholder="email"> <input type="text" name="pw"
					id="pw" placeholder="비밀번호">
					<button id="loginBtn">로그인</button>
				</c:if>
				<c:if test="${login ne null}">
					<span class="loginMsg">아이디 : ${login.id}님 환영합니다.</span>
				</c:if>
				</span>

			</nav>
		</header>
		<nav class="side">
				<ul>
					<li>
						<a href="<c:url value='/board/listPage'/>">회원게시판</a>
					</li>
					<li>
						<a href="<c:url value='/member/joinPage'/>">회원가입</a>
					</li>
				</ul>
		</nav>