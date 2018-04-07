<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="cssPath" value="/resources/css/join.css" scope="request" />
<c:set var="title" value="joinPage" scope="request" />
<c:import url="../template/header.jsp" />
<section>
	<article class="">
		<fieldset>
			<form id="joinForm" action="<c:url value='/member/join' />" method="post">
				<ul>
					<li><label>이메일</label> <input type='text' name="email"
						id="emailInp" value="" /> @ <select class="" name="email2"
						id="siteSelect">
							<option value="@naver.com">naver.com</option>
							<option value="@daum.net">daum.net</option>
							<option value="@nate.com">nate.com</option>
					</select> <span id="emailMsg"></span>
					</li>

					<li><label>아이디</label> <input type='text' name="id" id="idInp" />
						<span id="idMsg"></span></li>
					<li><label>비번</label> <input type='text' name="pw" id="pwInp" />
						<span id="pwMsg"></span></li>
					<li><label>비번확인</label> <input type='text' name="pwConfirm"
						id="pwConfirm" />
					</li>
				</ul>
			 <input type="submit" value="가입하기" />
			 <span id="errorMsg"></span>
			</form>
		</fieldset>
	</article>
</section>
<c:import url="../template/footer.jsp" />

<script type="text/javascript">
	$(function() {
		var checkList = {
			isEmail : false,
			isId : false,
			isPw : false
		};

		var msg = '${msg}';
		console.log(msg);
		if(msg == "FAIL")alert("유효하지 않습니다");
		
		$("#emailInp").on("change", function() {
			console.log("change이벤트 실행");
			var email = $("#emailInp").val() + $("#siteSelect").val();
			var dataObj = {"email" : email};
			var url = contextPath + "/member/checkEmail";
			sendCheckAjax(url, dataObj, "isEmail");
		});

		$("#siteSelect").on("change", function(){
			console.log("change이벤트 실행");
			var email = $("#emailInp").val() + $("#siteSelect").val();
			var dataObj = {"email" : email};
			var url = contextPath + "/member/checkEmail";
			sendCheckAjax(url, dataObj, "isEmail");
		});
		
		$("#idInp").on("change", function(){
			console.log("blur이벤트 실행");
			var id = $("#idInp").val();
			var dataObj = {id:id};
			var url = contextPath + "/member/checkId";
			sendCheckAjax(url, dataObj, "isId");
		});

		$("#pwInp").on("change", function(){
			console.log("change이벤트 동작");
			checkList.isPw = false;
			var pwVal = $("#pwInp").val();
			var pwconfirmVal = $("#pwConfirm").val();
			console.log(pwVal);
			console.log(pwconfirmVal);
			if(pwVal == null || "" === pwVal)return;
			if(pwVal === pwconfirmVal){
				checkList.isPw = true;
				$("#pwMsg").text("통과");
				$("#pwMsg").css("color", "blue");
				return;
			}
			$("#pwMsg").text("비번이 서로 다릅니다");
			$("#pwMsg").css("color", "red");
			
		});
		
		$("#pwConfirm").on("change", function(){
			console.log("change이벤트 동작");
			// 비밀번호가 변경될때마다 false로 초기화
			checkList.isPw = false;
			var pwVal = $("#pwInp").val();
			var pwconfirmVal = $("#pwConfirm").val();
			console.log(pwVal);
			console.log(pwconfirmVal);
			if(pwVal == null || "" === pwVal)return;
			if(pwVal === pwconfirmVal){
				checkList.isPw = true;
				$("#pwMsg").text("통과");
				$("#pwMsg").css("color", "blue");
				
				return;
			}
			$("#pwMsg").text("비번이 서로 다릅니다");
			$("#pwMsg").css("color", "red");
			
		});
		
		function changeMsg(color, msg, target) {
			var $emailMsg = $(target);
			$emailMsg.css("color", color);
			$emailMsg.text(msg);
		}

		function sendCheckAjax(url, dataObj, checkName) {
			var targetName = checkName.substring(2);
			var target = "#" + targetName.toLowerCase() + "Msg";
			console.log(target);
			$.ajax({
				type : 'post',
				url : url,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify(dataObj),
				success : function(msg) {
					// target이름을 뽑아내기위해 isEmail.substring(2);
					console.log("msg: " + msg);
					changeMsg("blue", msg, target);
					checkList[checkName] = true;
				},
				statusCode : {
					400 : function(msg) {

						console.log(msg.responseText);
						changeMsg("red", msg.responseText, target);
						checkList[checkName] = false;
					}
				}

			});
		}

		
		
		$("form").submit(function(event){
			console.log("submit이벤트 호출");		
			var url = contextPath + "/member/join";
			var flag = isValidation(checkList);
			console.log(flag);
			
			return flag;
		});
		
		function errorHandling(target){
			$(target).focus();
			$("#errorMsg").css("color", "red");
			$("#errorMsg").text("올바르게 입력해주세요.");
		}
		
		// submit전 유효성검사
		function isValidation(checkList){
			var result = true;
			if(checkList.isEmail == false){
				console.log("호출");
				errorHandling("#emailInp");
				result = false;
			}else if(checkList.isId == false){
				errorHandling("#idInp");
				result = false;
			}else if(checkList.isPw == false){
				errorHandling("#pwInp");
				result = false;
			}
			
			return result;
		}
		
		$("")
		
		
		
	});
</script>
</body>
</html>
