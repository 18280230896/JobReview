//添加任务表单验证
var addTaskNameInput = false;
var addTaskTypeInput = false;
var addTaskModuleNameInput = false;
$("#addTaskModal .form-control:eq(0)").on("input propertychange",function(){
	var value = $(this).val();
	if(value.length < 2 || value.length > 20){
		addTaskNameInput = false;
		$("#addTaskModal .help-block").eq(0).hide().text("必须输入2-20个字符！").slideDown(200);
		$("#addTaskModal .form-group").eq(0).removeClass("has-success").addClass("has-error");
	}else{
		addTaskNameInput = true;
		$("#addTaskModal .help-block").eq(0).slideUp(200);
		$("#addTaskModal .form-group").eq(0).removeClass("has-error").addClass("has-success");
	}
});

$("#addTaskModal form").on("input propertychange",function(event){
	if($(event.target).hasClass("subjectName")){
		var value = $(event.target).val();
		if(value.length < 2 || value.length > 255){
			addTaskjjInput = false;
			$(event.target).parent().next().hide().text("必须输入2-255个字符！").slideDown(200);
			$(event.target).parent().parent().parent().removeClass("has-success").addClass("has-error");
		}else{
			addTaskjjInput = true;
			$(event.target).parent().next().slideUp(200);
			$(event.target).parent().parent().parent().removeClass("has-error").addClass("has-success");
		}
	}
});

//添加任务
$("#addTaskBtn").click(function(){
	//输入验证
	for(var i=0;i<$("#addTaskModal .form-group").length;i++){
		if(i == 1) continue; 
		if(!$("#addTaskModal .form-group").eq(i).hasClass("has-success")){
			$("#addTaskModal .form-group").eq(i).find(".form-control").focus();
			return;
		}
	}
	var formData = new FormData($("#addTaskModal form")[0]);
	$.ajax({
		url:"teacherAddTask.action",
		type:"post",
		data:formData,
		dataType:"json",
		cache: false,  
        contentType: false,  
        processData: false,
		success:function(result){
			if(result.msg == 1){
				//添加成功
				//隐藏弹框
				$("#addTaskModal").modal("hide");
				//重置input
				$(".reset").click();
				$(".add").remove();
				$(".file-group").remove();
				$("#addTaskModal .form-group").removeClass("has-success");
				//刷新页面数据
				init();
				//显示提示
				tips("success","添加成功！");
				index = 1;
			}
		}
	});
});

//表格按钮点击监听
$("table").click(function(event){
	if($(event.target).hasClass("btn-danger")){
		//显示确认提示框
		$("#delTaskModal").modal("show");
		//将任务id赋值给隐藏域
		$("#delTaskModal input").val(data[$(event.target).parent().parent().index()-1].id);
	}
});

//确认删除点击监听
$("#delTaskModal .btn").eq(1).click(function(){
	var taskId = $("#delTaskModal input").val();
	$.ajax({
		url:"teacherDeleteTask.action",
		type:"post",
		data:{"id":taskId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//删除成功
				//弹框消失
				$("#delTaskModal").modal("hide");
				//刷新数据
				showPage(nowPage);
				//显示提示
				tips("success","删除成功！");
			}
		}
	});
});