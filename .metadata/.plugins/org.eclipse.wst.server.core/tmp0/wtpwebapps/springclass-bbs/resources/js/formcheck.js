$(function() {

	/* 게시 글 상세보기에서 게시 글 수정 폼 요청 처리
	 * 아래와 같이 hidden 폼을 통해 get 방식으로 요청할 수 있다.
	 **/
	$("#detailUpdate").on("click", function() {
			
		var pass = $("#pass").val();
		if(pass.length <= 0) {
			alert("암호를 대라");
			return false;
		}		
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "update");
		$("#checkForm").submit();
	});
	
	/* 게시 글 상세보기에서 게시 글 삭제 요청 처리
	 * 아래와 같이 hidden 폼을 통해 post 방식으로 처리 할 수 있다.
	 **/
	$("#detailDelete").on("click", function() {
			
		var pass = $("#pass").val();
		if(pass.length <= 0) {
			alert("암호를 대지않으면 지워주지 않겠다!");
			return false;
		}
		
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "delete");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	});
	
	// 게시글 쓰기 폼 유효성 검사
	$("#writeForm").on("submit", function() {
		if($("#writer").val().length <= 0) {
			alert("NO작성자!\nWRITE작성자!!");
			$("#writer").focus();			
			return false;
		}
		if($("#title").val().length <= 0) {
			alert("NO제목!\nWRITE제목!!");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0) {
			alert("NO비번!\nWRITE비번!!");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("NO내용!\nWRITE내용!!");
			$("#content").focus();
			return false;
		}
	});

	// 게시 글 수정 폼 유효성 검사
	$("#updateForm").on("submit", function() {
		if($("#writer").val().length <= 0) {
			alert("(수정)NO작성자!\nWRITE작성자!!");
			$("#writer").focus();			
			return false;
		}
		if($("#title").val().length <= 0) {
			alert("(수정)NO제목!\nWRITE제목!!");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0) {
			alert("(수정)NO비번!\nWRITE비번!!");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("(수정)NO내용!\nWRITE내용!!");
			$("#content").focus();
			return false;
		}
	});
});