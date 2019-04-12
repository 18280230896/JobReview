//获取并显示用户信息
$.ajax({
	url:"getUserInfo.action",
	type:"post",
	dataType:"json",
	async:false,
	success:function(result){
		if(result.user != null){
			$("#name").text(result.user.name);
		}
	}
});

//修改密码输入监听
var updateNewPwdInput = false;
var updateConfirmInput = false;
$("#changePwdModal .form-control").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#changePwdModal .modal-footer button").eq(1).focus().click();
    }
});
$("#changePwdModal .form-control").on("input propertychange",function(){
	var index = $(this).parent().index();
	var value = $(this).val();
	if(index == 0){
		if(value == ""){
			$("#changePwdModal .help-block").eq(0).hide().text("请输入旧密码！").slideDown(200);
			$("#changePwdModal .form-group").eq(0).removeClass("has-success").addClass("has-error");
		}else{
			$("#changePwdModal .help-block").eq(index).slideUp(200);
			$("#changePwdModal .form-group").eq(0).removeClass("has-error");
		}
	}else if(index == 1){
		var RegExp = /^[0-9a-zA-Z]{6,20}$/;
		if(!RegExp.test(value)){
			updateNewPwdInput = false;
			$("#changePwdModal .help-block").eq(index).hide().text("只能输入字母或数字，且长度为6-20！").slideDown(200);
			$("#changePwdModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			updateNewPwdInput = true;
			$("#changePwdModal .help-block").eq(index).slideUp(200);
			$("#changePwdModal .form-group").eq(index).removeClass("has-error").addClass("has-success");
		}
	}else if(index == 2){
		var newPwd = $("#newPwd").val();
		if(value != newPwd){
			updateConfirmInput = false;
			$("#changePwdModal .help-block").eq(index).hide().text("密码不匹配！").slideDown(200);
			$("#changePwdModal .form-group").eq(index).removeClass("has-success").addClass("has-error");
		}else{
			updateConfirmInput = true;
			$("#changePwdModal .help-block").eq(index).slideUp(200);
			$("#changePwdModal .form-group").eq(index).removeClass("has-error").addClass("has-success");
		}
	}
});

//修改密码
$("#changePwdModal .modal-footer button").eq(1).click(function(){
	var oldPwd = $("#changePwdModal input").eq(0).val();
	//输入验证
	if(oldPwd == ""){
		$("#changePwdModal .form-control").eq(0).focus();
		$("#changePwdModal .help-block").eq(0).hide().text("请输入旧密码！").slideDown(200);
		$("#changePwdModal .form-group").eq(0).removeClass("has-success").addClass("has-error");
		return;
	}
	if(!updateNewPwdInput){
		$("#changePwdModal .form-control").eq(1).focus();
		return;
	}
	if(!updateConfirmInput){
		$("#changePwdModal .form-control").eq(2).focus();
		return;
	}
	var newPwd = $("#changePwdModal input").eq(1).val();
	var confirm = $("#changePwdModal input").eq(2).val();
	$.ajax({
		url:"changePwd.action",
		type:"post",
		data:{"newPassword":newPwd,"oldPassword":oldPwd},
		dataType:"json",
		success:function(data){
			if(data.status == 1){
				$("#changePwdModal").modal("hide");
				tips("success","修改成功!");
				//清空输入框
				$(".reset").click();
				$("#changePwdModal .form-group").removeClass("has-success");
				updateNewPwdInput = false;
				updateConfirmInput = false;
			}else{
				$("#changePwdModal .form-group").eq(0).addClass("has-error");
				$("#changePwdModal input").eq(0).next().hide().text("旧密码错误！").slideDown(200);
			}
		}
	});
});

//操作提示
function tips(sign,msg){
	if(sign === "success"){
		$("#alert .alert").addClass("bg-success").removeClass("bg-danger").removeClass("bg-warning");
	}else if(sign === "warning"){
		$("#alert .alert").addClass("bg-warning").removeClass("bg-danger").removeClass("bg-success");
	}else if(sign === "error"){
		$("#alert .alert").addClass("bg-danger").removeClass("bg-success").removeClass("bg-warning");
	}
	$("#alert #msg").text(msg);
	$("#alert").modal("show");
}
