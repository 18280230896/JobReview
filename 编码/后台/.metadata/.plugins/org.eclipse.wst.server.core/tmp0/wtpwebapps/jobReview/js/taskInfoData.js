var task;
var taskId = $("#taskId").val();
//初始任务基本信息
taskInfoInit();
//初始任务基本信息
function taskInfoInit(){
	//获取数据
	$.ajax({
		url:"teacherGetTaskInfo.action",
		type:"post",
		data:{"taskId":taskId},
		dataType:"json",
		success:function(result){
			task = result.task;
			//将任务信息展示到界面
			//基本信息
			$("#taskInfo li:eq(0) span:eq(1)").text(task.name);
			if(task.type === 1) $("#taskInfo li:eq(1) span:eq(1)").text("Java 任务");
			else $("#taskInfo li:eq(1) span:eq(1)").text("Oracle 任务");
			
			//模块列表
			//先清空，在生成
			$("#moduleList .ul-info").empty();
			for(var i=0;i<task.subjects.length;i++){
				if(task.subjects[i].id == null) continue;
				var newli = $("<li class='subjects'>"+
							"<input type='hidden' value='"+task.subjects[i].id+"' />"+
							"<span>"+(i+1)+"、"+task.subjects[i].name+"</span>"+
							" <span class='glyphicon glyphicon-pencil option update'></span>"+
							" <span class='glyphicon glyphicon-remove option delete'></span>"+
						"</li>")
				$("#moduleList .ul-info").append(newli);
			}
			if(task.subjects.length == 0 || task.subjects[0].id == null){
				var newli = $("<li>"+
						"<span>还没有题目哦!</span>"+
					"</li>")
			$("#moduleList .ul-info").append(newli);
			}
		}
	});
}

//确定修改按钮点击监听
$("#updateModal .btn-primary").click(function(){
	var flag = $("#updateModal .modal-footer input:eq(0)").val();
	if(flag == 1){
		if(!updateTaskNameInput) {
			$("#updateModal input:eq(0)").focus(); 
			return;
		}
	}
	if (flag == 1 || flag == 2){
		var key;
		flag == 1 ? key = "name" : key = "type";
		var value;
		flag == 1 ? value = $("#updateModal input:eq(0)").val() : value = $("#updateModal option:selected").val();
		var data = "id="+task.id+"&"+key+"="+value;
		$.ajax({
			url:"teacherUpdateTaskInfo.action",
			type:"post",
			dataType:"json",
			data:data,
			success:function(result){
				if(result.msg == 1){
					$("#updateModal").modal("hide");
					tips("success","修改成功！");
					taskInfoInit();
					$("#updateModal .form-group").removeClass("has-success");
				}
			}
		});
	}
	if(flag == 3){
		//修改题目
		//输入验证
		if(!updateSubjectInput){
			$("#updateModal textarea").focus();
			return;
		}
		var id = $("#updateModal .modal-footer input:eq(1)").val();
		console.log(id);
		var name = $("#updateModal textarea").val();
		console.log(name);
		$.ajax({
			url:"teacherUpdateSubject.action",
			type:"post",
			data:{"id":id,"name":name},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					$("#updateModal").modal("hide");
					tips("success","修改成功！");
					$("#updateModal .form-control:eq(2)").removeClass("has-success");
					taskInfoInit();
				}
			}
		});
	}
});

//确定删除题目按钮点击监听
$("#dleModal .btn:eq(1)").click(function(){
	$.ajax({
		url:"teacherDelSubject.action",
		type:"post",
		data:{"id":$("#dleModal input:eq(0)").val()},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				$("#dleModal").modal("hide");
				tips("success","删除成功！");
				taskInfoInit();
			}
		}
	});
});

//确认添加按钮点击监听
$("#addSubjectModal .btn:eq(1)").click(function(){
	//输入验证
	if(!addSubjectInput){
		$("#subjectName").focus();
		return;
	}
	$.ajax({
		url:"teacheraddSubject.action",
		type:"post",
		data:{"tid":task.id,"name":$("#subjectName").val()},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				$("#addSubjectModal").modal("hide");
				tips("success","添加成功！");
				$("#subjectName").val("").parent().removeClass("has-success");
				addSubjectInput = false;
				taskInfoInit();
			}
		}
	});
});
