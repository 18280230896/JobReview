//获取并显示学生基本信息
var student;
$.ajax({
	url:"studentGetStudentInfo.action",
	type:"post",
	dataType:"json",
	success:function(result){
		student = result.student;
		//显示学生信息
		$("#studentInfo .form-control-static:eq(0)").text(student.name);
		$("#studentInfo .form-control-static:eq(1)").text(student.c.name);
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
	if(event.target.nodeName == "BUTTON"){
		var index = $(event.target).parent().parent().index() - 1;
		if($(event.target).text() == "查看详情"){
			$("#studentTaskInfo input").val(classTasks[index].ctId);
			$("#studentTaskInfo button").click();
		}else if($(event.target).text() == "提交用例"){
			$("#case input").val(classTasks[index].ctId);
			$("#case button").click();
		}else if($(event.target).text() == "提交BUG"){
			$("#bug input").val(classTasks[index].ctId);
			$("#bug button").click();
		}
	}
});
