//修改删除按钮监听
$("table").click(function(event){
	if($(event.target).hasClass("updateBtn")){
		//显示修改弹框
		$("#updateClassModal").modal("show");
		$("#updateClassModal input").eq(0).val($(event.target).parent().siblings().eq(1).text());
		$("#updateClassModal input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#updateClassModal option").eq(data[$(event.target).parent().parent().index()-1].semester-1).prop("selected","selected");
	}else if($(event.target).hasClass("deleteBtn")){
		//显示删除弹框
		$("#dleTeacherModal").modal("show");
		$("#dleTeacherModal input").val($(event.target).parent().parent().index()-1);
	}else if($(event.target).hasClass("btn-primary")){
		$("#toClassInfo input").val(data[$(event.target).parent().parent().index()-1].classId);
		$("#toClassInfo")[0].submit();
	}
});


$("#addClassModal .form-control").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	console.log($("#addClassModal .btn").eq(1)[0]);
    	$("#addClassModal .btn").eq(1).focus().click();
    	return false;
    }
});
//添加班级输入验证
var addclassNameInput = false;
$("#addClassModal .form-control:eq(0)").on("input propertychange",function(){
	var value = $(this).val();
	if(value.length < 2 || value.length > 10){
		addclassNameInput = false;
		$("#addClassModal .help-block:eq(0)").hide().text("只能输入2-10个字符！").slideDown(200);
		$("#addClassModal .form-group:eq(0)").addClass("has-error").removeClass("has-success");
	}else{
		addclassNameInput = true;
		$("#addClassModal .help-block:eq(0)").slideUp(200);
		$("#addClassModal .form-group:eq(0)").addClass("has-success").removeClass("has-error");
	}
});

//添加班级
$("#addClassModal .btn").eq(1).click(function(){
	//输入验证
	if(!addclassNameInput){
		$("#addClassModal .form-control:eq(0)").focus();
		return;
	}
	var className = $("#addClassModal input").eq(0).val();
	var semester = $("#addClassModal option:selected").index()+1;
	$.ajax({
		url:"teacherAddClass.action",
		type:"post",
		data:{"name":className,"semester":semester},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//添加成功
				//隐藏模态框
				$("#addClassModal").modal("hide");
				//显示第一页数据
				init();
				//显示提示
				tips("success","添加成功！");
				//重置input
				$(".reset").click();
				$("#addClassModal .form-group").removeClass("has-success");
				addclassNameInput = false;
			}
		}
	});
});

$("#updateClassModal .form-control").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#updateClassModal .btn").eq(1).focus().click();
    	return false;
    }
});
//修改班级输入验证
var updateClassNameInput = true;
$("#updateClassModal .form-control:eq(0)").on("input propertychange",function(){
	var value = $(this).val();
	if(value.length < 2 || value.length > 10){
		updateClassNameInput = false;
		$("#updateClassModal .help-block:eq(0)").hide().text("只能输入2-10个字符！").slideDown(200);
		$("#updateClassModal .form-group:eq(0)").addClass("has-error").removeClass("has-success");
	}else{
		updateClassNameInput = true;
		$("#updateClassModal .help-block:eq(0)").slideUp(200);
		$("#updateClassModal .form-group:eq(0)").addClass("has-success").removeClass("has-error");
	}
});
//修改班级
$("#updateClassModal .btn").eq(1).click(function(){
	//输入验证
	if(!updateClassNameInput){
		$("#updateClassModal .form-control:eq(0)").focus();
		return;
	}
	var classId = data[$("#updateClassModal input").eq(1).val()].id;
	var className = $("#updateClassModal input").eq(0).val();
	var semester = $("#updateClassModal option:selected").index()+1;
	$.ajax({
		url:"teacherUpdateClass.action",
		type:"post",
		data:{"id":classId,"name":className,"semester":semester},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//修改成功
				//隐藏弹框
				$("#updateClassModal").modal("hide");
				//更新数据
				showPage(nowPage);
				//显示提示
				tips("success","修改成功！");
				//重置input
				$(".reset").click();
				$("#updateClassModal .form-group").removeClass("has-success");
			}
		}
	});
});

//删除班级
$("#dleTeacherModal .btn").eq(1).click(function(){
	var classId = data[$("#dleTeacherModal input").eq(0).val()].id;
	$.ajax({
		url:"teacherDeleteClass.action",
		type:"post",
		data:{"id":classId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//删除成功
				//隐藏弹框
				$("#dleTeacherModal").modal("hide");
				//更新数据
				showPage(nowPage);
				//提示
				tips("success","删除成功！");
			}
		}
	});
});