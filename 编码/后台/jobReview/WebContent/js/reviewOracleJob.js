var ctid = $("#ctid").val();
var id = $("#id").val();
var jobStatus;
var task;
var classTask;
getClassTaskInfo();
showSubject();

//点击查看大图
$(".pic").click(function(){
	$("#bigPic img").attr("src",$(this).attr("src"));
	$("#bigPic").modal("show");
});


$("#scoreInput").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	$("#submit").click();
    }
});

//input内容改变事件
var mark = false;
$("#scoreInput").on("input propertychange",function(){
	var value = $(this).val();
	if(/^[1-9][0-9]{0,2}$/.test(value) && value <= 100){
		$(this).parent().parent().addClass("has-success").removeClass("has-error");
		$(this).parent().next().hide();
		mark = true;
	}else{
		$(this).parent().parent().addClass("has-error").removeClass("has-success");
		$(this).parent().next().hide().text("请输入正确的分数！").slideDown(250);
		mark = false
	}
});

//确定点击事件
$("#submit").click(function(){
	if(!mark) {
		$("#scoreInput").focus();
		return;
	}
	$.ajax({
		url:"teacherSubmitScore.action",
		type:"post",
		data:{"score":$("#scoreInput").val(),"id":id,"ctid":ctid},
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				tips("success","打分成功！");
			}else{
				tips("error","出错了！");
			}
		}
	});
});

function getClassTaskInfo(){
	$.ajax({
		url:"teacherGetClassTask.action",
		type:"post",
		data:{"id":id,"ctid":ctid},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.status == 1){
				console.log(task);
				classTask = result.classTask;
				task = result.task;
				jobStatus = result.jobStatus;
			}
		}
	});
}

function showSubject(){
	if(jobStatus != null && jobStatus.score != null) $("#scoreInput").val(jobStatus.score);
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
		}
		newLi.append(newBody);
		var newRight = $("<div class='media-right'></div>");
		var work = getWork(task.subjects[i].id);
		if(work == null){
			newRight.append("<img class='media-object' src='img/wtj.png'>");
		}else{
			newRight.append("<img class='media-object pic' src='"+work.picPath+"'>");
		}
		newRight.append("<span class='show hidden' >查看</span>");
		newLi.append(newRight);
		$(".media-list").append(newLi);
	}
}
function getWork(subjectId){
	var work;
	$.ajax({
		url:"teacherGetWork.action",
		type:"post",
		data:{"ctid":ctid,"id":id,"subjectId":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.status == 0) work = null;
			if(result.status == 1) work = result.work;
		}
	});
	return work
}

function getDivision(subjectId){
	var division;
	$.ajax({
		url:"teacherGetDivision.action",
		type:"post",
		data:{"gid":id,"sid":subjectId},
		dataType:"json",
		async:false,
		success:function(result){
			division = result.division
		}
	});
	return division;
}