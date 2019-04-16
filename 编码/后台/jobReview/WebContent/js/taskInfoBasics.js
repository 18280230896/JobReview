$(".ul-info").mouseover(function(event){
	if(event.target.nodeName == "LI"){
		$(event.target).children(".option").fadeIn(150);
		$(event.target).siblings().children(".option").fadeOut(150);
	}
});

$(".ul-info").mouseleave(function(event){
	$(this).find(".option").fadeOut(150);
});

$(".panel-info").mouseover(function(){
	$(this).find(".add").fadeIn(150);
});
$(".panel-info").mouseleave(function(){
	$(this).find(".add").fadeOut(150);
});

$("#taskInfo .glyphicon").click(function(event){
	var index = $(event.target).parent().index();
	$("#updateModal .form-group").hide();
	$("#updateModal .form-group").eq(index).show();
	if(index == 0){
		$("#updateModal .modal-footer input:eq(0)").val("1");
		$("#updateModal .modal-title").text("修改任务名称");
		$("#taskName").val(task.name);
	}else if(index == 1){
		$("#updateModal .modal-footer input:eq(0)").val("2");
		$("#updateModal .modal-title").text("修改任务类型");
		$("#taskType option").eq(task.type-1).prop("selected","selected");
	}
	$("#updateModal").modal("show");
	
});

var updateTaskNameInput = true;
$("#taskName").on("input propertychange",function(){
	var value = $("#taskName").val();
	if(value.length < 2 || value.length > 10){
		$(this).next().hide().text("请输入2-10个字符").slideDown(250);
		$(this).parent().addClass("has-error");
		$(this).parent().removeClass("has-success");
		updateTaskNameInput = false;
	}else{
		$(this).parent().removeClass("has-error");
		$(this).parent().addClass("has-success");
		$(this).next().text("");
		updateTaskNameInput = true;
	}
});

//点击添加题目，弹出添加弹窗
$("#addSubjectBtn").click(function(){
	$("#addSubjectModal").modal("show");
});


$("#subjectName").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#addSubjectModal .btn:eq(1)").focus().click();
    	return false;
    }
});
//添加题目输入监听
var addSubjectInput = false;
$("#subjectName").on("input propertychange",function(){
	var length = $("#subjectName").val().length;
	if(length < 2 || length > 255){
		$("#subjectName").next().hide().text("请输入2-255个字符！").slideDown(250).parent().addClass("has-error").removeClass("has-success");
		addSubjectInput = false;
	}else{
		$("#subjectName").next().text("").parent().removeClass("has-error").addClass("has-success");
		addSubjectInput = true;
	}
	
});

$("#updateModal .form-group textarea").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#updateModal .modal-footer .btn:eq(1)").focus().click();
    	return false;
    }
});
//监听修改和删除题目点击
$("#subjectList").click(function(event){
	var target = $(event.target);
	if(target.hasClass("update")){
		//点击修改题目按钮弹出弹窗
		$("#updateModal .form-group").hide();
		$("#updateModal .form-group").eq(2).show();
		$("#updateModal .form-group textarea").val(task.subjects[target.parent().index()].name);
		$("#updateModal").modal("show");
		$("#updateModal .modal-footer input:eq(0)").val("3");
		$("#updateModal .modal-footer input:eq(1)").val(task.subjects[target.parent().index()].id);
	}else if(target.hasClass("delete")){
		//点击了删除按钮
		$("#dleModal").modal("show");
		$("#dleModal .modal-footer input").val(task.subjects[target.parent().index()].id);
	}
});


//修改题目输入验证
var updateSubjectInput = false;
$("#updateModal textarea:eq(0)").on("input propertychange",function(){
	var length = $(this).val().length;
	if(length < 2 || length > 255){
		updateSubjectInput = false;
		$(this).next().hide().text("请输入2-255个字符！").slideDown(250).parent().addClass("has-error").removeClass("has-success");
	}else{
		$(this).next().text("").parent().addClass("has-success").removeClass("has-error");
		updateSubjectInput = true;
	}
});
	
	
	
	
	
	