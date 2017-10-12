<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cssPath" value="/resources/css/write.css" scope="request" />
<c:set var="title" value="writePage" scope="request" />
<c:import url="../template/header.jsp" />
<section>
	<header></header>
	<article class="">
		<form action="<c:url value='/board/write' />" method="post">
			<div class="header">
				<div class="">
					제목 <input type="text" name="title" id="" class="title">
				</div>
			</div>
			<div class="content">
				<label for="">내용</label>
				<textarea name="content" rows="8" cols="80"></textarea>
			</div>
			<div class="footer">
				<div class="btnGroup">
					<button class="listBtn">목록</button>
					<input type="submit" value="글쓰기" />
				</div>
			</div>
		</form>
	</article>

</section>
<c:import url="../template/footer.jsp" />

</body>
</html>