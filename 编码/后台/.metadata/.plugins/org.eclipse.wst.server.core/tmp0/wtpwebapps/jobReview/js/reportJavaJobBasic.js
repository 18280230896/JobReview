//获取任务信息
var ctid = $("#ctid").val();
var classTask;
var task;
var isLeader = studentIsLeader();
var student;
//获取显示任务信息
getClassTaskInfo();
showClassTask();

var defaultCode = $("#code").val();
var nowCode;

var subjectIndex = 0;
var nowDivision;
//上一题点击事件
$(".prevSubject").click(function(){
	subjectIndex --;
	var width = $(".content")[0].offsetWidth;
	$(".content-list").animate({"left":-subjectIndex*width},400);
	if(subjectIndex == 0) $(".prevSubject").prop("disabled","disabled");
	$(".nextSubject").prop("disabled","");
	if(classTask.type == 2){
		nowDivision = getDivision(task.subjects[subjectIndex].id);
		showDivision(subjectIndex,nowDivision);
		submitIsdisabled();
	}
	getAndShowCode(task.subjects[subjectIndex].id);
	$(".console").empty();
});


//下一题点击事件
$(".nextSubject").click(function(){
	subjectIndex ++;
	var width = $(".content")[0].offsetWidth;
	$(".content-list").animate({"left":-subjectIndex*width},400);
	if(subjectIndex == task.subjects.length - 1) $(".nextSubject").prop("disabled","disabled");
	$(".prevSubject").prop("disabled","");
	if(classTask.type == 2){
		nowDivision = getDivision(task.subjects[subjectIndex].id);
		showDivision(subjectIndex,nowDivision);
		submitIsdisabled();
	}
	getAndShowCode(task.subjects[subjectIndex].id);
	$(".console").empty();
});


//修改分工点击时间
$(".content-list").click(function(event){
	if($(event.target).hasClass("glyphicon-pencil")){
		$("#updatefengong").modal("show");
	}
});


//修改分工弹窗显示之前加载数据
var students;
$("#updatefengong").on("show.bs.modal",function(){
	clear();
	getAndShowDivision();
});

//弹窗消失之前更新数据
$("#updatefengong").on("hide.bs.modal",function(){
	nowDivision = getDivision(task.subjects[subjectIndex].id);
	showDivision(subjectIndex,nowDivision);
	submitIsdisabled();
});

//add点击事件
$("#add").click(function(){
	var selecteds = $("#updatefengong .form-control:eq(0) option:selected");
	if(selecteds.length == 0) return;
	var subjectId = task.subjects[subjectIndex].id;
	var data = {"subjectId":subjectId};
	data.studentIds = new Array(selecteds.length);
	for(var i=0;i<selecteds.length;i++){
		data.studentIds[i] = students[$(selecteds[i]).index()].id;
	}
	addDivision(data);
});

//remove点击事件
$("#remove").click(function(){
	var selecteds = $("#updatefengong .form-control:eq(1) option:selected");
	if(selecteds.length == 0) return;
	var data = {};
	data.ids = new Array(selecteds.length);
	for(var i=0;i<selecteds.length;i++){
		data.ids[i] = nowDivision[$(selecteds[i]).index()].id;
	}
	delDivision(data);
});

//提交按钮点击事件
$("#submitBtn").click(function(){
	//判断有没有输入新内容
	if(javaEditor.getValue() == nowCode) return;
	//验证是否是第一次提交
	if(!subjectIsFirstSubmit(task.subjects[subjectIndex].id)){
		//显示覆盖提示
		$("#confirmSubmit").modal("show");
	}else{
		submitJob(task.subjects[subjectIndex].id,javaEditor.getValue());
	}
});

//确认提交按钮点击事件
$("#confirmSubmit .btn:eq(1)").click(function(){
	$("#confirmSubmit").modal("hide");
	submitJob(task.subjects[subjectIndex].id,javaEditor.getValue());
});

//提交作业
function submitJob(subjectId,code){
	nowCode = code;
	$("#submitBtn").prop("disabled","disabled");
	$.ajax({
		url:"studentSubmitJavaWork.action",
		type:"post",
		data:{"subjectId":subjectId,"code":code},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//提交成功
				tips("success","提交成功！");
			}else{
				tips("error",result.msg);
			}
			$("#submitBtn").prop("disabled","");
		}
	});
}



//验证题目是否是第一次提交
function subjectIsFirstSubmit(subjectId){
	var flag = false;
	$.ajax({
		url:"studentIsFirstSubmit.action",
		type:"post",
		data:{"subjectId":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg != 0){
				flag = result.msg;
			}
		}
	});
	return flag;
}

function getAndShowCode(subjectId){
	$.ajax({
		url:"studentGetWork.action",
		type:"post",
		data:{"subjectId":subjectId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1) nowCode = result.code;
			else nowCode = defaultCode;
			javaEditor.setValue(nowCode);
		}
	});
}

function submitIsdisabled(){
	var flag = false;
	for(var i=0;i<nowDivision.length;i++){
		if(nowDivision[i].student.id == student.id){
			flag = true;
			break;
		}
	}
	if(flag){
		$("#submitBtn").prop("disabled","");
	}else{
		$("#submitBtn").prop("disabled","disabled");
	}
}

function addDivision(data){
	$.ajax({
		url:"studentAddDivision.action",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			clear();
			getAndShowDivision();
		}
	});
}

function delDivision(data){
	$.ajax({
		url:"studentDelDivision.action",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			clear();
			getAndShowDivision();
		}
	});
}

function getAndShowDivision(){
	$.ajax({
		url:"studentGetDivision.action",
		type:"post",
		data:{"sid":task.subjects[subjectIndex].id},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				students = result.students;
				nowDivision = result.division;
				for(var i=0;i<students.length;i++){
					$("#updatefengong .form-control:eq(0)").append($("<option>"+students[i].name+"</optino>"));
				}
				for(var i=0;i<nowDivision.length;i++){
					$("#updatefengong .form-control:eq(1)").append($("<option>"+nowDivision[i].student.name+"</option>"));
				}
			}else{
				alert("发生异常！");
			}
		}
	});
}

function clear(){
	$("#updatefengong .form-control").empty();
}

function getClassTaskInfo(){
	$.ajax({
		url:"studentGetClassTaskInfo.action",
		type:"post",
		data:{"ctid":ctid},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				classTask = result.classTask;
				task = result.task;
				student = result.student;
			}
		}
	});
	
}


function showClassTask(){
	var length = task.subjects.length;
	if(length == 0){
		prohibit();
		return;
	}
	$(".content-list").css("width",length+"00%");
	for(var i=0;i<length;i++){
		var newLi = $("<li class='content'></li>");
		var newSubject = $("<div class='subject'><h4>"+(i+1)+"、"+task.subjects[i].name+"</h4></div>")
		newLi.append(newSubject);
		if(classTask.type === 2){
			//显示分工信息
			var division = getDivision(task.subjects[i].id);
			var newfengong = $("<div class='fengong'></div>");
			newLi.append(newfengong);
		}
		$(".content-list").append(newLi);
		$(".content").css("width",100/length+"%");
		$(".prevSubject").prop("disabled","disabled");
		if(length == 1) $(".nextSubject").prop("disabled","disabled");
	}
	if(classTask.type === 2) {
		nowDivision = getDivision(task.subjects[0].id);
		showDivision(0,nowDivision);
		submitIsdisabled();
	}
	getAndShowCode(task.subjects[0].id);
}

function studentIsLeader(){
	var flag= false;
	$.ajax({
		url:"studentIsLeader.action",
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			flag = result.msg;
		}
	});
	return flag;
}

function showDivision(index,division){
	$(".content-list .content").eq(index).children(".fengong").empty();
	var newp = $("<p></p>");
	if(division.length == 0) newp.append($("<span>该题目还没有设置负责人哦！</span>"));
	else{
		var text = "该题目负责人：";
		for(var j=0;j<division.length;j++){
			text += division[j].student.name;
			if(j != division.length - 1) text += "、";
		}
		newp.append("<span>"+text+"</span>");
	}
	if(isLeader){
		newp.append(" <span class='glyphicon glyphicon-pencil'></span>");
	}
	$(".content-list .content").eq(index).children(".fengong").append(newp);
}


function getDivision(subjectId){
	var division;
	$.ajax({
		url:"studentGetDivision.action",
		type:"post",
		data:{"sid":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			division = result.division
		}
	});
	return division;
}


function prohibit(){
	$(".content-list").append($("<h4 style='margin-left:15px;'>该任务还没有添加题目哦！</h4>"));
	$(".prevSubject").prop("disabled","disabled");
	$(".nextSubject").prop("disabled","disabled");
	$("#submitBtn").prop("disabled","disabled");
}
