var unameInput = $("input[name='username']:eq(0)");
var pwdInput = $("input[name='password']:eq(0)");



$("input").keypress(function(e) {
       var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
        if (eCode == 13){
            $("#login").click();
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
	//判断密码是否正确
	if(username == "admin" && password == "admin"){
		$("#admin").click();
	}else if(username == "111111" && password == "111111"){
		$("#teacher").click();
	}else if(username == "222222" && password == "222222"){
		$("#student").click();
	}else{
		pwdInput.focus().parent().next().hide().text("用户名或密码错误！").slideDown(250).parent().addClass("has-error");
	}
}