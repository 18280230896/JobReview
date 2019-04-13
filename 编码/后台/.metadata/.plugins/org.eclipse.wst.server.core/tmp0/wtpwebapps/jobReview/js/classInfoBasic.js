//添加任务模态框显示之前加载班级没有的任务列表
var tasks;
$("#addTask").on("show.bs.modal",function(){
	var classId = $("#classId").val();
	$.ajax({
		url:"teacherGetNotTaskList.action",
		type:"post",
		data:{"classId":classId},
		dataType:"json",
		success:function(result){
			tasks = result.tasks;
			//清空下拉列表
			$("#teskList").empty();
			//循环生成选项
			for(var i=0;i<tasks.length;i++){
				var newNode = $("<option>"+tasks[i].name+"</option>")
				$("#teskList").append(newNode);
			}
		}
	});
})

//点击下一步
$("#next").click(function(){
	//验证是否选择了任务
	if($(".body-content .form-control option:selected").length <= 2){
		$(".body-content .form-group:eq(0)").addClass("has-error");
		$(".body-content .help-block:eq(0)").hide().text("请选择一个任务").slideDown(200);
		return;
	}
	var offset1 = $("#addTask .body-content")[0].offsetWidth/-2;
	var offset2 = $("#addTask .footer-content")[0].offsetWidth/-2;
	$("#addTask  .body-content").animate({"margin-left":offset1},300);
	$("#addTask  .footer-content").animate({"margin-left":offset1},300);
	$("#addTask  .modal-title").text("设置开始和截止时间");
	$("#addTask .pull-right input").eq(0).val(tasks[$(".body-content .form-control option:selected").index()].id);
});
//点击上一步
$("#prev").click(function(){
	$("#addTask  .body-content").animate({"margin-left":0},300);
	$("#addTask  .footer-content").animate({"margin-left":0},300);
	$("#addTask  .modal-title").text("请选择一个任务");
});


$("#addTask .pull-right").click(function(){
	confirmTime();
});

function cleartime(){
	$("#addTask .pull-right .form-group").removeClass("has-success");
	$("#prev").click();
}

//验证开始和结束时间正确性验证
function confirmTime(){
	if($("#addTask .pull-right input").eq(1).val() == ""){
		$("#addTask .pull-right .form-group").eq(0).removeClass("has-success").addClass("has-error");
		$("#addTask .pull-right .help-block").eq(0).hide().text("请输入开始时间！").slideDown(200);
		return 0;
	}else{
		$("#addTask .pull-right .form-group").eq(0).addClass("has-success").removeClass("has-error");
		$("#addTask .pull-right .help-block").eq(0).slideUp(200);
	}
	if($("#addTask .pull-right input").eq(2).val() == ""){
		$("#addTask .pull-right .form-group").eq(1).removeClass("has-success").addClass("has-error");
		$("#addTask .pull-right .help-block").eq(1).hide().text("请输入截止时间！").slideDown(200);
		return 0;
	}
	var startTime = (new Date($("#addTask .pull-right input").eq(1).val())).getTime();
	var endTime = (new Date($("#addTask .pull-right input").eq(2).val())).getTime();
	if(endTime <= startTime){
		$("#addTask .pull-right .form-group").eq(1).removeClass("has-success").addClass("has-error");
		$("#addTask .pull-right .help-block").eq(1).hide().text("截止时间必须大于开始时间！").slideDown(200);
		return 0;
	}
	$("#addTask .pull-right .form-group").eq(1).addClass("has-success").removeClass("has-error");
	$("#addTask .pull-right .help-block").eq(1).slideUp(200);
	return 1;
}

/*
第一个input:1表示删除任务，2表示立即截止任务，3表示删除学生，4表示删除小组
第二个input：表示他们在data中的index
 */

$("#TaskManager .table").click(function(event){
	if($(event.target).hasClass("btn-info")){
		//点击修改任务
		$("#updateModal input").eq(0).val($(event.target).parent().parent().index()-1);
		$("#updateModal input").eq(1).val($(event.target).parent().siblings("td").eq(1).text());
		$("#updateModal option").eq(classTasks[$(event.target).parent().parent().index()-1].proportion-1).prop("selected","selected");
		$("#updateModal input").eq(2).val($(event.target).parent().siblings("td").eq(5).text());
		$("#updateModal input").eq(3).val($(event.target).parent().siblings("td").eq(6).text());
		//弹出修改弹窗
		$("#updateModal").modal("show");
	}else if($(event.target).hasClass("btn-danger")){
		//点击删除按钮
		$("#delModal input").eq(0).val(1);
		$("#delModal input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#delModal .modal-title").text("确定要删除该任务吗？");
		//弹出提示框
		$("#delModal").modal("show");
	}else if($(event.target).hasClass("btn-warning")){
		//点击立即截止按钮
		$("#delModal input").eq(0).val(2);
		$("#delModal input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#delModal .modal-title").text("确定要立即截止该任务吗？");
		//弹出提示框
		$("#delModal").modal("show");
	}else if($(event.target).hasClass("btn-primary")){
		var index = $(event.target).index();
		var ctId = classTasks[$(event.target).parent().parent().index()-1].ctId;
		if(index == 0){
			$("#toReviewCaseBtn").prev().val(ctId);
			$("#toReviewCaseBtn").click();
		}else if(index == 1){
			$("#toReviewBugBtn").prev().val(ctId);
			$("#toReviewBugBtn").click();
		}
	}
});

//点击批量导入
$("#StudentManager .page-header .btn-primary").click(function(){
	$(this).siblings("form").children("input").click();
});

$("#StudentManager .table").click(function(){
	if($(event.target).hasClass("btn-danger")){
		//点击删除学生按钮
		$("#delModal input").eq(0).val(3);
		$("#delModal input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#delModal .modal-title").text("确定要删除该学生吗？");
		//弹出提示框
		$("#delModal").modal("show");
	}else if($(event.target).hasClass("btn-primary")){
		//点击修改学生按钮
		$("#udpateStudnetModal").modal("show");
		$("#udpateStudnetModal input").eq(0).val($(event.target).parent().siblings("td").eq(1).text());
		$("#udpateStudnetModal input").eq(1).val($(event.target).parent().siblings("td").eq(3).text());
		$("#udpateStudnetModal input").eq(2).val($(event.target).parent().parent().index()-1);
	}
});

$("#GruopManager .table").click(function(event){
	if($(event.target).hasClass("btn-danger")){
		//点击删除小组按钮
		$("#delModal input").eq(0).val(4);
		$("#delModal input").eq(1).val($(event.target).parent().parent().index()-1);
		$("#delModal .modal-title").text("确定要删除该小组吗？");
		//弹出提示框
		$("#delModal").modal("show");
	}else if($(event.target).hasClass("btn-primary")){
		$("#toGroupInfo input").val(groups[$(event.target).parent().parent().index()-1].groupId);
		$("#toGroupInfo")[0].submit();
	}
	
});

var addStudentNameInput = false;
var addStudentUserNameInput = false;
var addStudentPasswordInput = false;
//添加学生输入验证
$("#addStudent input").eq(0).on("input propertychange",function(){
	var value = $(this).val();
	if(value.length < 2 || value.length > 10){
		addStudentNameInput = false;
		$("#addStudent .form-group").eq(0).addClass("has-error").removeClass("has-sucess");
		$("#addStudent .help-block").eq(0).hide().text("姓名长度为2-10个字符！").slideDown(200);
	}else{
		addStudentNameInput = true;
		$("#addStudent .form-group").eq(0).addClass("has-success").removeClass("has-error");
		$("#addStudent .help-block").eq(0).slideUp(200);
	}
});
$("#addStudent input").eq(1).on("input propertychange",function(){
	var value = $(this).val();
	var RegExp = /^[0-9a-zA-Z]{6,20}$/;
	if(!RegExp.test(value)){
		addStudentUserNameInput = false;
		$("#addStudent .form-group").eq(1).addClass("has-error").removeClass("has-sucess");
		$("#addStudent .help-block").eq(1).hide().text("只能输入数字和字母，且长度为6-20！").slideDown(200);
		return;
	}
	//判断用户名是否存在
	$.ajax({
		url:"usernameIsExist.action",
		type:"post",
		data:{"username":value},
		dataType:"json",
		success:function(result){
			if(result.msg == 2){
				//存在
				addStudentUserNameInput = false;
				$("#addStudent .form-group").eq(1).addClass("has-error").removeClass("has-sucess");
				$("#addStudent .help-block").eq(1).hide().text("用户名已存在！").slideDown(200);
			}else{
				addStudentUserNameInput = true;
				$("#addStudent .form-group").eq(1).addClass("has-success").removeClass("has-error");
				$("#addStudent .help-block").eq(1).slideUp(200);
			}
		}
	});
	
});
$("#addStudent input").eq(2).on("input propertychange",function(){
	var value = $(this).val();
	var RegExp = /^[0-9a-zA-Z]{6,20}$/;
	if(!RegExp.test(value)){
		addStudentPasswordInput = false;
		$("#addStudent .form-group").eq(2).addClass("has-error").removeClass("has-sucess");
		$("#addStudent .help-block").eq(2).hide().text("值允许输入数字和字母，且长度为6-20").slideDown(200);
	}else{
		addStudentPasswordInput = true;
		$("#addStudent .form-group").eq(2).addClass("has-success").removeClass("has-error");
		$("#addStudent .help-block").eq(2).slideUp(200);
	}
});

//修改学生输入验证
var updateStudentNameInput = true;
var updateStudentPwdInput = true;

$("#udpateStudnetModal input").eq(0).on("input propertychange",function(){
	var value = $(this).val();
	if(value.length<2 || value.length>10){
		updateStudentNameInput = false;
		$("#udpateStudnetModal .help-block").eq(0).hide().text("姓名长度为2-10！").slideDown(200);
		$("#udpateStudnetModal .form-group").eq(0).removeClass("has-success").addClass("has-error");
	}else{
		updateStudentNameInput = true;
		$("#udpateStudnetModal .help-block").eq(0).slideUp(200);
		$("#udpateStudnetModal .form-group").eq(0).removeClass("has-error").addClass("has-success");
	}
});

$("#udpateStudnetModal input").eq(1).on("input propertychange",function(){
	var value = $(this).val();
	var RegExp = /^[0-9a-zA-Z]{6,20}$/;
	if(!RegExp.test(value)){
		updateStudentNameInput = false;
		$("#udpateStudnetModal .help-block").eq(1).hide().text("只能输入数字或字母，且长度为6-20").slideDown(200);
		$("#udpateStudnetModal .form-group").eq(1).removeClass("has-success").addClass("has-error");
	}else{
		updateStudentNameInput = true;
		$("#udpateStudnetModal .help-block").eq(1).slideUp(200);
		$("#udpateStudnetModal .form-group").eq(1).removeClass("has-error").addClass("has-success");
	}
});

var addGroupNumInput = false;
var addGroupNameInput = false;
var addGroupSolGanInput = false;
var addGroupNoteInput = false;
//添加小组输入验证
$("#addGroupModal input:lt(2)").on("input propertychange",function(){
	var value = $(this).val();
	var index = $(this).parent().index();
	if(value.length < 1 || value.length > 10){
		if(index == 0) addGroupNumInput = false;
		else addGroupNameInput = false;
		$(this).next().hide().text("只能输入1-10个字符！").slideDown(200);
		$(this).parent().addClass("has-error").removeClass("has-success");
	}else{
		if(index == 0) addGroupNumInput = true;
		else addGroupNameInput = true;
		$(this).next().slideUp(200);
		$(this).parent().addClass("has-success").removeClass("has-error");
	}
});
$("#addGroupModal textarea:eq(0)").on("input propertychange",function(){
	var value = $(this).val();
	if(value.length < 1 || value.length > 100){
		addGroupSolGanInput = false;
		$(this).next().hide().text("只能输入1-100个字符！").slideDown(200);
		$(this).parent().addClass("has-error").removeClass("has-success");
	}else{
		addGroupSolGanInput = true;
		$(this).next().slideUp(200);
		$(this).parent().addClass("has-success").removeClass("has-error");
	}
});
$("#addGroupModal textarea:eq(1)").on("input propertychange",function(){
	var value = $(this).val();
	if(value.length > 100){
		addGroupNoteInput = false;
		$(this).next().hide().text("最多输入100个字符！").slideDown(200);
		$(this).parent().addClass("has-error").removeClass("has-success");
	}else{
		addGroupNoteInput = true;
		$(this).next().slideUp(200);
		$(this).parent().addClass("has-success").removeClass("has-error");
	}
});

$("#updateModal").on("show.bs.modal",function(){
	$("#updateModal .form-group").removeClass("has-error");
	$("#updateModal .help-block").text("");
});

