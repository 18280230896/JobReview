var ctid = $("#ctid").val();
var classTask;
var task;
var isLeader = studentIsLeader();
getClassTaskInfo();
showSubject();


//修改分工按钮点击事件
$(".media-list").click(function(event){
	if($(event.target).hasClass("glyphicon")){
		$("#subjectIndex").val($(event.target).parent().parent().index());
		$("#updatefengong").modal("show");
	}
	
});

//修改弹窗显示之前加载数据
$("#updatefengong").on("show.bs.modal",function(){
	clear();
	getAndShowDivision();
});

//弹窗消失之前更新数据
$("#updatefengong").on("hide.bs.modal",function(){
	var body = $(".media-body").eq($("#subjectIndex").val());
	body.children("span").remove();
	division = getDivision(task.subjects[$("#subjectIndex").val()].id);
	if(division.length == 0) body.append($("<span>该题目还没有分配负责人！</span>"));
	else{
		var text = "该题目负责人：";
		for(var i=0;i<division.length;i++){
			text += division[i].student.name;
			if(i != division.length - 1) text += "、";
		}
		body.append($("<span>"+text+"</span> "));
	}
	if(isLeader && classTask.status != 3) body.append($(" <span style='margin-left:8px;' class='glyphicon glyphicon-pencil'></span>"));
});



//add点击事件
$("#add").click(function(){
	var selecteds = $("#updatefengong .form-control:eq(0) option:selected");
	if(selecteds.length == 0) return;
	var subjectId = task.subjects[$("#subjectIndex").val()].id;
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

//上传截图点击事件
var index;
$(".media-list").click(function(event){
	if($(event.target).hasClass("media-object")){
		index = $(event.target).parent().parent().index();
		$("input[type='text']").val(task.subjects[index].id);
		$("input[type='file']").click();
	}
});

//文件选择器内容改变事件
$("input[type='file']").change(function(){
	var formData = new FormData($("#upload")[0]);
	if($(this).val() != ""){
		$.ajax({
			url:"studentSubmitOracleJob.action",
			type:"post",
			data:formData,
			dataType:"json",
			cache: false,  
	        contentType: false,  
	        processData: false,
			success:function(result){
				if(result.status == 1){
					tips("success","上传成功！");
					var work = getWork(task.subjects[index].id);
					$(".media").eq(index).find(".media-object").attr("src",work.picPath).addClass("pic");
					
				}else{
					tips("error",result.msg);
				}
			}
		});
	}
});
$('.media-right').mouseover(function(){
	if($(this).children(".pic").length == 0) return;
	$(this).children(".show").removeClass("hidden").hide().show(1000);
});
$('.media-right').mouseleave(function(){
	if($(this).children(".pic").length == 0) return;
	$(this).children(".show").addClass("hidden");
});

//查看大图点击事件
$(".show").click(function(){
	$("#bigPic img").attr("src",$(this).prev().attr("src"));
	$("#bigPic").modal("show");
});
function delDivision(data){
	$.ajax({
		url:"studentDelDivision.action",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				clear();
				getAndShowDivision();
			}else{
				$("#updatefengong").modal("hide");
				tips("error",result.msg);
			}
		}
	});
}

function addDivision(data){
	$.ajax({
		url:"studentAddDivision.action",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				clear();
				getAndShowDivision();
			}else{
				$("#updatefengong").modal("hide");
				tips("error",result.msg);
			}
		}
	});
}

function getAndShowDivision(){
	$.ajax({
		url:"studentGetDivision.action",
		type:"post",
		data:{"sid":task.subjects[$("#subjectIndex").val()].id},
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

function showSubject(){
	$(".media-list").empty();
	if(task.subjects.length == 0){
		$(".media-list").append($("<li class='media'><h4>该任务还没有题目哦！</h4></li>"));
		return;
	}
	for(var i=0;i<task.subjects.length;i++){
		var newLi = $("<li class='media'></li>");
		var newBody = $("<div class='media-body'></div>")
		newBody.append($("<h4>"+(i+1)+"、"+task.subjects[i].name+"</h4>"));
		if(classTask.type == 2){
			var division = getDivision(task.subjects[i].id);
			if(division.length == 0) newBody.append($("<span>该题目还没有分配负责人！</span>"));
			else{
				var text = "该题目负责人：";
				for(var j=0;j<division.length;j++){
					text += division[j].student.name;
					if(j != division.length - 1) text += "、";
				}
				newBody.append($("<span>"+text+"</span>"));
			}
			if(isLeader && classTask.status != 3) newBody.append($("<span style='margin-left:8px;' class='glyphicon glyphicon-pencil'></span>"));
		}
		newLi.append(newBody);
		var newRight = $("<div class='media-right'></div>");
		var work = getWork(task.subjects[i].id);
		if(work == null){
			newRight.append("<img class='media-object' src='img/upload.png'>");
		}else{
			newRight.append("<img class='media-object pic' src='"+work.picPath+"'>");
		}
		newRight.append("<span class='show hidden' >查看</span>");
		newLi.append(newRight);
		$(".media-list").append(newLi);
	}
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

function getDivision(subjectId){
	var division;
	$.ajax({
		url:"studentGetDivision.action",
		type:"post",
		data:{"sid":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				division = result.division;
			}
		}
	});
	return division;
}

function getWork(subjectId){
	var work;
	$.ajax({
		url:"studentGetWork.action",
		type:"post",
		data:{"subjectId":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 0) work = null;
			if(result.msg == 1) work = result.work;
		}
	});
	return work
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