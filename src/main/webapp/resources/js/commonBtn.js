$(function(){
	
	
	$(".listBtn").on("click", function(){
		location.href = contextPath + "/board/listPage?"
						+ makeQuery(searchType, keyword, page, perPageNum);
	});
	
	$(".writeBtn").on("click", function(){
		location.href = contextPath + "/writePage";
	});
	
	$(".modBtn").on("click", function(){
		location.href = contextPath + "/board/modifyPage?" 
						+ makeQuery(searchType, keyword, page, perPageNum)
						+"&bno="+bno;
	});
	
	$(".readBtn").on("click", function(){
		var url = contextPath + "/board/readPage?"
						+ makeQuery(searchType, keyword, page, perPageNum)
						+ "&bno="+bno;
		console.log(url);
	});
	
	function makeQuery(searchType, keyword, page, perPageNum){
		var query = "searchType="+searchType
		+"&keyword="+keyword
		+"&page="+page
		+"&perPageNum="+perPageNum;
		return query;
	}
	
});