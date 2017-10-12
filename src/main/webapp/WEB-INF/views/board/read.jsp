<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cssPath" value="/resources/css/write.css" scope="request" />
<c:set var="cssPath2" value="/resources/css/read.css" scope="request" />
<c:set var="title" value="readPage" scope="request" />
<c:import url="../template/header.jsp" />

    <section>
      <header></header>
      <article class="">
        <div class="header">
            <div class="">
              제목 <input type="text" name="title" id="" class="title" value="${boardVO.title}" readonly="readonly">
            </div>
        </div>
        <div class="content">

      <label for="">내용</label>
      <textarea name="content" rows="8" cols="80" readonly="readonly">${boardVO.content}</textarea>

        </div>
        <div class="footer">
            <div class="btnGroup">
                  <button class="listBtn">목록</button>
                  <button class="rmBtn">글삭제</button>
                  <button class="modBtn">글수정</button>
            </div>
            </div>
      </article>

    </section>
<c:import url="../template/footer.jsp" />
<script type="text/javascript">
$(function(){
 
  $(".rmBtn").on("click", function(){
        var result = confirm("삭제 하시겟습니까?");
        if(result == true){
        	var url = contextPath + "/board/remove";
        	var $formObj = $("<form></form>");
        	var paramNames = ["bno", "page", "perPageNum"];
        	var inpsVal = [bno, page, perPageNum];
        	$formObj.attr("action", url);
        	$formObj.attr("method", "post");
        	$formObj.appendTo("section");
    		for(var i = 0; i < 3; i++){
    			var $inps = $("<input type='hidden' />").clone();
    			$inps.attr("name", paramNames[i]);
    			$inps.val(inpsVal[i]);
    			$inps.appendTo($formObj);
    		}
        	$formObj.submit();
        }
  });
});
</script>
</body>
</html>
