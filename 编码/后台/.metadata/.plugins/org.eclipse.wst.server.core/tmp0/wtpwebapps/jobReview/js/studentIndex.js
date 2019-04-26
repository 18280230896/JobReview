//获取并显示学生基本信息
var student;
$.ajax({
	url:"studentGetStudentInfo.action",
	type:"post",
	dataType:"json",
	success:function(result){
		student = result.student;
		//显示学生信息
		$("title").text("欢迎你！"+student.name);
		$("#studentInfo .form-control-static:eq(0)").text(student.num);
		$("#studentInfo .form-control-static:eq(1)").text(student.name);
		$("#studentInfo .form-control-static:eq(2)").text(student.c.name);
		if(student.group != null){
			var numNode = $("<div class='form-group'>"+
							"<label class='col-md-5 control-label'>小组编号：</label>"+
							"<div class='col-md-7'>"+
								"<p class='form-control-static'>"+student.group.num+"</p>"+
							"</div>"+
						"</div>");
			var nameNode = $("<div class='form-group'>"+
					"<label class='col-md-5 control-label'>小组名称：</label>"+
					"<div class='col-md-7'>"+
						"<p class='form-control-static'>"+student.group.name+"</p>"+
					"</div>"+
				"</div>");
			$("#groupInfo").append(numNode).append(nameNode);
		}else{
			$("#groupInfo").append("<p>你还没有分组</p>");
		}
	}
});

//表格按钮点击事件
$("table").click(function(event){
	if($(event.target).hasClass("btn")){
		var index = $(event.target).parent().parent().index() - 1;
		if(classTasks[index].type == 2 && student.group == null) tips("warning","你还没有分组,不能查看该任务！");
		else {
			$(event.target).next()[0].click();
		}
	}
});
