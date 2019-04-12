$("#addTeacherModal .form-control").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#addTeacherModal .modal-footer .btn").eq(1).focus().click();
    }
});


//添加教师输入验证
var addTeacherNameInput = false;
var addTeacherUserNameInput = false;
var addTeacherPedInput = false;
$("#addTeacherModal .form-control").on("input propertychange",function(){
	var index = $(this).parent().index();
	var value = $(this).val();
	if(index == 0){
		//姓名验证
		if(value.length < 2 || value.length > 10){
			addTeacherNameInput = false;
			$("#addTeacherModal .help-block").eq(0).hide().text("只能输入2-10个字符！").slideDown(200);
			$("#addTeacherModal .form-group").eq(0).removeClass("has-success").addClass("has-error");
		}else{
			addTeacherNameInput = true;
			$("#addTeacherModal .help-block").eq(0).slideUp(200);
			$("#addTeacherModal .form-group").eq(0).removeClass("has-error").addClass("has-success");
		}
	}
	else if(index == 1){
		//用户名验证
		var RegExp = /^[0-9a-zA-Z]{6,20}$/;
		if(!RegExp.test(value)){
			addTeacherUserNameInput = false;
			$("#addTeacherModal .help-block").eq(index).hide().text("只能输入字母或数字，且长度为6-20！").slideDown(200);
			$("#addTeacherModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			//判断用户名是否存在
			$.ajax({
				url:"usernameIsExist.action",
				type:"post",
				data:{"username":value},
				dataType:"json",
				success:function(result){
					if(result.msg == 1){
						//不存在
						addTeacherUserNameInput = true;
						$("#ausername").parent().addClass("has-success");
						$("#ausername").parent().removeClass("has-error");
						$("#ausername").next().slideUp(200,function(){
							$("#ausername").next().text("");
						});
					}else{
						//存在
						addTeacherUserNameInput = false
						$("#ausername").parent().addClass("has-error");
						$("#ausername").parent().removeClass("has-success");
						$("#ausername").next().hide().text("用户名已存在！").slideDown(200);
					}
				}
			});
		}
	}else if(index == 2){
		//密码输入验证
		var RegExp = /^[0-9a-zA-Z]{6,20}$/;
		if(!RegExp.test(value)){
			addTeacherPedInput = false;
			$("#addTeacherModal .help-block").eq(index).hide().text("只能输入字母或数字，且长度为6-20！").slideDown(200);
			$("#addTeacherModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			addTeacherPedInput = true;
			$("#addTeacherModal .help-block").eq(index).slideUp(200);
			$("#addTeacherModal .form-group").eq(index).removeClass("has-error").addClass("has-success");
		}
	}
});

//添加教师按钮点击事件
$("#addTeacherModal .modal-footer .btn").eq(1).click(function(){
	//输入验证
	if(!addTeacherNameInput){
		$("#addTeacherModal .form-control").eq(0).focus();
		return;
	}else if(!addTeacherUserNameInput){
		$("#addTeacherModal .form-control").eq(1).focus();
		return;
	}else if(!addTeacherPedInput){
		$("#addTeacherModal .form-control").eq(2).focus();
		return;
	}
	//获取输入参数
	var name = $("#aname").val();
	var username = $("#ausername").val();
	var password = $("#apassword").val();
	$.ajax({
		url:"adminAddTeacher.action",
		type:"post",
		data:{"name":name,"username":username,"password":password},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//添加成功
				$("#addTeacherModal").modal("hide");
				init();
				tips("success","添加成功!");
				//清空输入框
				$(".reset").click();
				$("#addTeacherModal .form-group").removeClass("has-success");
				addTeacherNameInput = false;
				addTeacherUserNameInput = false;
				addTeacherPedInput = false;
			}else{
				$("#addTeacherModal").modal("hide");
				tips("error","用户名已经存在!");
				
			}
		}
	});
});


//删除和修改按钮的监听事件
$("table").click(function(event){
	if($(event.target).attr("id") == "update"){
		$("#updateTeacherModal").modal("show");
		$("#updateTeacherModal input").eq(0).val($(event.target).parent().siblings().eq(1).text());
		$("#updateTeacherModal input").eq(1).val($(event.target).parent().siblings().eq(3).text());
		$("#updateTeacherModal input").eq(2).val($(event.target).parent().parent().index()-1);
	}else if($(event.target).attr("id") == "delete"){
		$("#dleTeacherModal").modal("show");
		$("#dleTeacherModal input").val($(event.target).parent().parent().index()-1);
	}
});


//修改教师输入验证
var updateTeacherNameInput = true;
var updateTeacherPwdInput = true;
$("#updateTeacherModal .form-control").on("input propertychange",function(){
	var index = $(this).parent().index();
	var value = $(this).val();
	if(index == 0){
		//验证姓名
		if(value.length < 2 || value.length > 10){
			updateTeacherNameInput = false;
			$("#updateTeacherModal .help-block").eq(index).hide().text("只能输入2-10个字符").slideDown(200);
			$("#updateTeacherModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			updateTeacherNameInput = true;
			$("#updateTeacherModal .help-block").eq(index).slideUp(200);
			$("#updateTeacherModal .form-group").eq(index).removeClass("has-error").addClass("has-success");
		}
	}else if(index == 1){
		//密码验证
		var RegExp = /^[0-9a-zA-Z]{6,20}$/;
		if(!RegExp.test(value)){
			updateTeacherPwdInput = false;
			$("#updateTeacherModal .help-block").eq(index).hide().text("只能输入字母或数字，且长度为6-20！").slideDown(200);
			$("#updateTeacherModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			updateTeacherPwdInput = true;
			$("#updateTeacherModal .help-block").eq(index).slideUp(200);
			$("#updateTeacherModal .form-group").eq(index).removeClass("has-error").addClass("has-success");
		}
	}
});

//修改教师弹框消失，移除class
$("#updateTeacherModal").on("hide.bs.modal",function(){
	updateTeacherNameInput = true;
	updateTeacherPwdInput = true;
	$("#updateTeacherModal .form-group").removeClass("has-error").removeClass("has-success");
	$("#updateTeacherModal .help-block").text("");
});

$("#updateTeacherModal .form-control").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#updateTeacherModal button").eq(2).focus().click();
    }
});

//修改教师
$("#updateTeacherModal button").eq(2).click(function(){
	//输入验证
	if(!updateTeacherNameInput){
		$("#updateTeacherModal .form-control").eq(0).focus();
		return;
	}
	if(!updateTeacherPwdInput){
		$("#updateTeacherModal .form-control").eq(1).focus();
		return;
	}
	var teacherId = teachers[$("#updateTeacherModal input").eq(2).val()].id;
	var name = $("#updateTeacherModal input").eq(0).val();
	var password = $("#updateTeacherModal input").eq(1).val();
	$.ajax({
		url:"adminUpdateTeacher.action",
		type:"post",
		data:{"id":teacherId,"name":name,"password":password},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//修改成功
				$("#updateTeacherModal").modal("hide");
				//更新内容
				showPage(nowPage);
				//显示提示
				tips("success","修改成功！");
				//重置input
				$("#updateTeacherModal .form-group").removeClass("has-success");
			}
		}
	});
});

//删除教师
$("#dleTeacherModal .btn").eq(1).click(function(){
	var teacherId = teachers[$("#dleTeacherModal input").eq(0).val()].id;
	$.ajax({
		url:"adminDelTeacher.action",
		type:"post",
		data:{"id":teacherId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//删除成功
				$("#dleTeacherModal").modal("hide");
				//更新界面
				showPage(nowPage);
				//显示提示
				tips("success","删除成功！");
			}
		}
	});
});