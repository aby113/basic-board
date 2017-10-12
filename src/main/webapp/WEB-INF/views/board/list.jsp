<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cssPath" value="/resources/css/list.css" scope="request" />
<c:set var="title" value="listPage" scope="request" />
<c:import url="../template/header.jsp" />
<fmt:formatDate var="now" value="<%=new java.util.Date()%>"
	pattern="yyyyMMdd" />
<section>
	<header>
		<div class="searchGroup">
			<select class="" name="">
				<option value="" selected="selected">제목</option>
				<option value="">내용</option>
				<option value="">제목+내용</option>
			</select> <input type="text" name="keyword" id="" class="keyword">
			<button class="searchBtn">검색</button>
			<button class="writeBtn">글쓰기</button>
		</div>
	</header>
	<article class="">
		<table>
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.bno}</td>
						<td><a class="getReadPage" data-bno="${vo.bno}" href="#">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<fmt:formatDate pattern="yyyyMMdd" value="${vo.regdate}"
							var="regdate" />
						<c:set var="patternValue"
							value="${(now - regdate) eq 0? 'HH:mm':'yyyy-MM-dd'}" />
						<td><fmt:formatDate value="${vo.regdate}"
								pattern="${patternValue}" /></td>

						<td>${vo.reviewcnt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</article>
	<footer>
		<ul class="pagenation">
			
			<c:if test="${pageMaker.prev}">
				<li><a class="prev" href="${pageMaker.startPage - 1}">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" varStatus="i">
				<li class="${pageMaker.cri.page eq i.current? 'selected':''}">
				<a href="${i.current}">${i.current}</a>
				</li>
				
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li><a class="next" href="${pageMaker.endPage + 1}">&raquo;</a>
			</c:if>
		</ul>
	
	</footer>
</section>
<c:import url="../template/footer.jsp" />
<script>
	$(function() {
		// 제목링크 이벤트 처리
		$("a.getReadPage").on(
				"click",
				function(event) {
					event.preventDefault();
					var bno = $(this).data("bno");
					location.href = contextPath + '/board/readPage?bno=' + bno
							+ "&page=" + page + "&perPageNum=" + perPageNum;
				});

		// 페이지 네이션 이벤트처리
		$(".pagenation").on("click", "li a", function(event){
			event.preventDefault();
			var pageValue = $(this).attr("href");		
			location.href = contextPath + '/board/listPage?'
					+"&page=" + pageValue + "&perPageNum=" + perPageNum;
		});
		
	
	
	});
</script>


</body>
</html>