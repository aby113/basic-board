$(function(){
	
	
	$(".listBtn").on("click", function(){
		location.href = contextPath + "/board/listPage?"
						+"&page="+page
						+"&perPageNum="+perPageNum;
	});
	
	$(".writeBtn").on("click", function(){
		location.href = contextPath + "/writePage";
	});
	
	$(".modBtn").on("click", function(){
		location.href = contextPath + "/board/modifyPage?" 
						+"bno="+bno
				        +"&page="+page
						+"&perPageNum="+perPageNum;
	});
	
});