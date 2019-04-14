$(".groupInfo li").mouseover(function(){
	$(this).children(".glyphicon").fadeIn(100);
});
$(".groupInfo li").mouseleave(function(){
	$(this).children(".glyphicon").fadeOut(100);
});
$(".glyphicon-pencil").click(function(){
	$("#updateGroupInfo").modal("show");
	var index = $(this).parent().index();
	$("#updateGroupInfo .form-group").hide();
	$("#updateGroupInfo .form-group").eq(index).show().children().eq(1).val($(this).prev().text());
	$("#updateGroupInfo .modal-footer input").val(index);
});
$("table").click(function(event){
	if($(event.target).hasClass("btn-danger")){
		var text = "确定要将"+$(event.target).parent().siblings("td:eq(1)").text()+"从该组中移除吗？";
		$("#confirm .modal-title").text(text);
		$("#confirm input").eq(0).val(1);
		$("#confirm input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#confirm").modal("show");
	}else if($(event.target).hasClass("btn-warning")){
		var text = "确定要将"+$(event.target).parent().siblings("td:eq(1)").text()+"任命为组长吗？";
		$("#confirm .modal-title").text(text);
		$("#confirm input").eq(0).val(2);
		$("#confirm input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#confirm").modal("show");
	}
});