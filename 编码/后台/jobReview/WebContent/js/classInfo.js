//点击确认添加班级任务按钮
$("#addTask .add").click(function(){
	if(confirmTime() == 1){
		var classId = $("#classId").val();
		var taskId = $("#addTask input").eq(0).val();
		var type = $("#taskType option:selected").val();
		var proportion = $("#proportion option:selected").val();
		var startTime = $("#addTask input").eq(1).val();
		var endTime = $("#addTask input").eq(2).val();
		$.ajax({
			url:"teacherAddClassTask.action",
			type:"post",
			data:{"classId":classId,"taskId":taskId,"type":type,"proportion":proportion,"startTime":startTime,"endTime":endTime},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//弹窗消失
					$("#addTask").modal("hide");
					//刷新数据
					initTaskList();
					//显示提示
					tips("success","添加成功！")
					//重置input
					$("#prev").click();
					$("#addTask .pull-right .form-group").removeClass("has-success");
					$("#addTask .pull-right input").val("");
				}
			}
		});
	}
});

//点击确认修改按钮
$("#updateModal .btn").eq(1).click(function(){
	var ctid = classTasks[$("#updateModal input").eq(0).val()].id;
	var proportion = $("#updateModal option:selected").val();
	var startTime = $("#updateModal input").eq(2).val();
	var endTime = $("#updateModal input").eq(3).val();
	if((new Date(startTime)).getTime() >= (new Date(endTime)).getTime()){
		$("#updateModal .help-block").eq(1).hide().text("截止时间必须大于开始时间！").slideDown(200);
		$("#updateModal .form-group").eq(3).addClass("has-error");
	}else{
		$("#updateModal .help-block").eq(1).slideUp(200);
		$("#updateModal .form-group").eq(3).removeClass("has-error");
		$.ajax({
			url:"teacherUpdateClassTask.action",
			type:"post",
			data:{"id":ctid,"proportion":proportion,"startTime":startTime,"endTime":endTime},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//修改成功
					//弹窗消失
					$("#updateModal").modal("hide");
					//刷新界面
					showTaskPage(taskNowPage);
					//显示提示
					tips("success","修改成功！");
				}
			}
		});
	}
});

//点击确认删除按钮
$("#delModal .btn").eq(1).click(function(){
	var index = $("#delModal input").eq(0).val();
	if(index == 1){
		//删除任务
		var ctId = classTasks[$("#delModal input").eq(1).val()].id;
		$.ajax({
			url:"teacherDeleteClassTask.action",
			type:"post",
			data:{"ctId":ctId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//弹框消失
					$("#delModal").modal("hide");
					//刷新界面
					showTaskPage(taskNowPage);
					//显示提示
					tips("success","删除成功！")
				}
			}
		});
	}else if(index == 2){
		//立即截至任务
		var ctId = classTasks[$("#delModal input").eq(1).val()].id;
		$.ajax({
			url:"teacherEndClassTask.action",
			type:"post",
			data:{"id":ctId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//截止成功
					//弹框消失
					$("#delModal").modal("hide");
					//刷新界面
					showTaskPage(taskNowPage);
					//显示提示
					tips("success","操作成功！")
				}else{
					//任务已经是截止状态
					//弹框消失
					$("#delModal").modal("hide");
					//显示提示
					tips("warning","该任务已经是截止状态！")
				}
			}
		});
	}else if(index == 3){
		//删除学生
		var studentId = students[$("#delModal input").eq(1).val()].id;
		$.ajax({
			url:"teacherDeleteStudent.action",
			type:"post",
			data:{"studentId":studentId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//删除成功
					//弹窗消失
					$("#delModal").modal("hide");
					//刷新界面
					studentShowPage(studentNowPage);
					//显示提示
					tips("success","删除成功！");
				}
			}
		});
	}else if(index == 4){
		//删除小组
		var groupId = groups[$("#delModal input").eq(1).val()].id;
		$.ajax({
			url:"teacherDeleteGroup.action",
			type:"post",
			data:{"groupId":groupId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//删除成功
					//弹窗消失
					$("#delModal").modal("hide");
					//刷新数据
					showPage(nowPage);
					//显示提示
					tips("success","删除成功！");
				}
			}
		});
	}
});
//点击确认添加学生按钮
$("#addStudent .btn").eq(1).click(function(){
	//输入验证
	if(!addStudentNameInput) {
		$("#addStudent input").eq(0).focus();
		return;
	}
	if(!addStudentUserNameInput) {
		$("#addStudent input").eq(1).focus();
		return;
	}
	if(!addStudentPasswordInput) {
		$("#addStudent input").eq(2).focus();
		return;
	}
	var name = $("#addStudent input").eq(0).val();
	var username = $("#addStudent input").eq(1).val();
	var password = $("#addStudent input").eq(2).val();
	$.ajax({
		url:"teacherAddStudent.action",
		type:"post",
		data:{"classId":classId,"name":name,"username":username,"password":password},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//添加成功
				//弹窗消失
				$("#addStudent").modal("hide");
				//刷新界面
				studentInit();
				//显示提示
				tips("success","添加成功！");
				//重置input
				$("#addStudent input").val("");
				addStudentNameInput = false;
				addStudentUserNameInput = false;
				addStudentPasswordInput = false;
				$("#addStudent .form-group").removeClass("has-success");
			}else{
				//弹窗消失
				$("#addStudent").modal("hide");
				//显示提示
				tips("error","用户名已存在！");
				//重置input
				$("#addStudent input").val("");
				addStudentNameInput = false;
				addStudentUserNameInput = false;
				addStudentPasswordInput = false;
				$("#addStudent .form-group").removeClass("has-success");
			}
		}
	});
});

//批量添加学生
$("#fileInput").change(function(){
	var formData = new FormData($("#fileForm")[0]);
	$.ajax({
		url:"teacherBatchAddStudent.action",
		type:"post",
		data:formData,
		dataType:"json",
		cache: false,  
        contentType: false,  
        processData: false,
		success:function(result){
			if(result.msg == 1){
				//添加成功
				//刷新界面
				studentInit();
				//显示提示
				tips("success","成功导入"+result.success+"条数据！");
				//重置input
				$("#fileInput").val("");
			}else if(result.msg == 2){
				//没有选择文件
				tips("warning","你还没有选择文件！");
			}else if(result.msg == 3){
				//文件类型不符合
				tips("error","只支持后缀名为xlsx、xls的文件！");
			}
		}
	});
});

//点击确认修改学生按钮
$("#udpateStudnetModal .btn").click(function(){
	//输入验证
	if(!updateStudentNameInput) {
		$("#udpateStudnetModal input").eq(0).focus();
		return;
	}
	if(!updateStudentPwdInput){
		$("#udpateStudnetModal input").eq(1).focus();
		return;
	}
	var studentId = students[$("#udpateStudnetModal input").eq(2).val()].id;
	var name = $("#udpateStudnetModal input").eq(0).val();
	var password = $("#udpateStudnetModal input").eq(1).val();
	$.ajax({
		url:"teacherUpdateStudent.action",
		type:"post",
		data:{"id":studentId,"name":name,"password":password},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//修改成功
				//弹窗消失
				$("#udpateStudnetModal").modal("hide");
				//刷新数据
				studentShowPage(studentNowPage);
				//显示提示
				tips("success","修改成功！");
				//重置input
				$("#udpateStudnetModal .form-group").removeClass("has-success");
			}
		}
	});
});

//点击确认添加小组按钮
$("#addGroupModal .btn").eq(1).click(function(){
	//输入验证
	if(!addGroupNumInput) $("#addGroupModal input").eq(0).focus();
	else if(!addGroupNameInput) $("#addGroupModal input").eq(1).focus();
	else{
		//提交
		var num = $("#addGroupModal input").eq(0).val();
		var name = $("#addGroupModal input").eq(1).val();
		$.ajax({
			url:"teacherAddGroup.action",
			type:"post",
			data:{"classId":classId,"num":num,"name":name},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//添加成功
					//弹窗消失
					$("#addGroupModal").modal("hide");
					//刷新数据
					init();
					//显示提示
					tips("success","添加成功！");
					//清空input
					$("#addGroupModal input").val("");
					$("#addGroupModal textarea").val("");
					$("#addGroupModal .form-group").removeClass("has-success");
				}
			}
		});
	}
});