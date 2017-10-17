<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cssPath" value="/resources/css/modify.css" scope="request" />
<c:set var="title" value="modifyPage" scope="request" />
<c:import url="../template/header.jsp" />
<section>
	<header></header>
	<article class="">
		<form action="<c:url value='/board/modify' />" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno}"> <input
				type="hidden" name="searchType" value="${cri.searchType}"> <input
				type="hidden" name="keyword" value="${cri.keyword}"> <input
				type="hidden" name="page" value="${cri.page}"> <input
				type="hidden" name="perPageNum" value="${cri.perPageNum}">
			<div class="header">
				<div class="">
					제목 <input type="text" name="title" id="" class="title"
						value="${boardVO.title}">
				</div>
			</div>
			<div class="content">

				<pre>
					<label for="">내용</label>
					<textarea name="content" rows="8" cols="80">${boardVO.content}</textarea>
          </pre>
			</div>
			<div class="footer">
				<div class="btnGroup">
					<button class="readBtn">목록</button>
					<input type="submit" value="수정" />
				</div>
			</div>
		</form>
	</article>

</section>
<c:import url="../template/footer.jsp" />
<script type="text/javascript">
	$(function() {

		$(".readBtn").on(
				"click",
				function() {

					var url = contextPath + "/board/readPage?"
							+ makeQuery(searchType, keyword, page, perPageNum)
							+ "&bno=" + bno;
					location.href = url;

				});
		function makeQuery(searchType, keyword, page, perPageNum){
			var query = "searchType="+searchType
			+"&keyword="+keyword
			+"&page="+page
			+"&perPageNum="+perPageNum;
			return query;
		}
	});
</script>
</body>
</html>
