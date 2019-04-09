var unameInput = $("input[name='username']:eq(0)");
var pwdInput = $("input[name='password']:eq(0)");

$("input").keypress(function(e) {
       var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
        if (eCode == 13){
        	$("#login").focus().click();
        }
});
$("#login").click(function(){
	if(unameInput.val() === ""){
		unameInput.focus().parent().next().hide().text("用户名不能为空！").slideDown(250).parent().addClass("has-error");
		return;
	}else{
		unameInput.parent().next().hide().parent().removeClass("has-error");
	}
	if(pwdInput.val() === ""){
		pwdInput.focus().parent().next().hide().text("密码不能为空！").slideDown(250).parent().addClass("has-error");
		return;
	}else{
		pwdInput.parent().next().hide().parent().removeClass("has-error");
	}
	login();
});

function login(){
	var username = unameInput.val();
	var password = pwdInput.val();
	$.ajax({
		url:"login.action",
		type:"post",
		dataType:"json",
		data:{"username":username,"password":password},
		success:function(result){
			if(result.status === 0){
				pwdInput.focus().parent().next().hide().text("用户名或密码错误！").slideDown(250).parent().addClass("has-error");
			}else if(result.status === 1){
				$("#admin").click();
			}else if(result.status === 2){
				$("#teacher").click();
			}else if(result.status === 3){
				$("#student").click();
			}
		}
	});
}