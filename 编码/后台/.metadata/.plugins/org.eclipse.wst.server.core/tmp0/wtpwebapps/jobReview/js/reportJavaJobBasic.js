//获取任务信息
var ctid = $("#ctid").val();
var classTask;
var task;
//获取显示任务信息
getClassTaskInfo();
showClassTask();

var subjectIndex = 0;
//上一题点击事件
$(".prevSubject").click(function(){
	subjectIndex --;
	var width = $(".content")[0].offsetWidth;
	$(".content-list").animate({"left":-subjectIndex*width},400);
	if(subjectIndex == 0) $(".prevSubject").prop("disabled","disabled");
	$(".nextSubject").prop("disabled","");
});

//下一题点击事件
$(".nextSubject").click(function(){
	subjectIndex ++;
	var width = $(".content")[0].offsetWidth;
	$(".content-list").animate({"left":-subjectIndex*width},400);
	if(subjectIndex == task.subjects.length - 1) $(".nextSubject").prop("disabled","disabled");
	$(".prevSubject").prop("disabled","");
});


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
			var newfengong = $("<div class='fengong'><p></p></div>");
			newLi.append(newfengong);
		}
		$(".content-list").append(newLi);
		$(".content").css("width",100/length+"%");
		$(".prevSubject").prop("disabled","disabled");
		if(length == 1) $(".nextSubject").prop("disabled","disabled");
	}
}

function prohibit(){
	$(".content-list").append($("<h4 style='margin-left:15px;'>该任务还没有添加题目哦！</h4>"));
	$(".prevSubject").prop("disabled","disabled");
	$(".nextSubject").prop("disabled","disabled");
	$("#submitBtn").prop("disabled","disabled");
}
