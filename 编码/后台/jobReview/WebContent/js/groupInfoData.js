//全局变量
var classId = $("#classId").val();
var groupId = $("#groupId").val();
var member;
var students;
//显示数据
initBasicInfo();
//显示添加小组成员是加载数据
$("#addMember").on("show.bs.modal",function(){
	$.ajax({
		url:"teacherGetNotStudentList.action",
		type:"post",
		data:{"classId":classId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//请求成功
				students = result.students;
				$("#addMember select").empty();
				for(var i=0;i<students.length;i++){
					var option = $("<option>"+students[i].name+"</option>");
					$("#addMember select").append(option);
				}
				
			}
		}
	});
});
//点击确认添加按钮
$("#addMember .btn").eq(1).click(function(){
	//判断是否选择了学生
	if($("#addMember option:selected").length == 0){
		//没有选择，显示提示
		$("#addMember .form-group").addClass("has-error");
		$("#addMember .help-block").hide().text("请至少选择一个学生！").slideDown(200);
		return;
	}
	var count = 0;
	for(var i=0;i<$("#addMember option:selected").length;i++){
		$.ajax({
			url:"teacherAddStudentToGroup.action",
			type:"post",
			data:{"groupId":groupId,"studentId":students[$("#addMember option:selected").eq(i).index()].id},
			async:false,
			success:function(result){
				if(result.msg == 1) count = count + 1;
			}
		});
	}
	//弹窗消失
	$("#addMember").modal("hide");
	//刷新数据
	initBasicInfo();
	if(count > 0){
		//显示提示
		tips("success","添加成功!");
	}else{
		tips("error","添加异常!");
	}
	
	//重置input
	$("#addMember .form-group").removeClass("has-error");
	$("#addMember .help-block").slideUp(200);
});

//点击确认操作按钮
$("#confirm .btn").eq(1).click(function(){
	if($("#confirm input:eq(0)").val() == 1){
		//移除学生
		var studentId = member[$("#confirm input:eq(1)").val()].id;
		$.ajax({
			url:"teacherRemoveStudentToGroup.action",
			type:"post",
			data:{"studentId":studentId,"groupId":groupId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//移除成功
					//弹窗消失
					$("#confirm").modal("hide");
					//刷新数据
					initBasicInfo();
					//显示提示
					tips("success","移除成功!");
				}
			}
		});
	}else if($("#confirm input:eq(0)").val() == 2){
		//任命为组长
		var studentId = member[$("#confirm input:eq(1)").val()].id;
		$.ajax({
			url:"teacherAddLeader.action",
			type:"post",
			data:{"studentId":studentId,"groupId":groupId},
			dataType:"json",
			success:function(result){
				if(result.msg == 1){
					//任命成功
					//弹窗消失
					$("#confirm").modal("hide");
					//刷新数据
					initBasicInfo();
					//显示提示
					tips("success","任命成功!");
				}
			}
		});
	}
});

//输入框输入验证
var updateGroupNumInput = true;
var updateGroupNameInput = true;
$("#updateGroupInfo .form-control").on("input propertychange",function(){
	var index = $(this).parent().index();
	var value = $(this).val();
	if(index == 0){
		if(value.length < 1 || value.length > 10){
			updateGroupNumInput = false;
			$(this).next().hide().text("只能输入1-10个字符！").slideDown(200);
			$(this).parent().addClass("has-error").removeClass("has-success");
		}else{
			updateGroupNumInput = true;
			$(this).next().slideUp(200);
			$(this).parent().addClass("has-success").removeClass("has-error");
		}
	}else if(index == 1){
		if(value.length < 1 || value.length > 10){
			updateGroupNameInput = false;
			$(this).next().hide().text("只能输入1-10个字符！").slideDown(200);
			$(this).parent().addClass("has-error").removeClass("has-success");
		}else{
			updateGroupNameInput = true;
			$(this).next().slideUp(200);
			$(this).parent().addClass("has-success").removeClass("has-error");
		}
	}
});

//点击确定修改按钮
$("#updateGroupInfo .btn").eq(1).click(function(){
	var index = $(this).next().val();
	var key;
	var value = $("#updateGroupInfo .form-control").eq(index).val();
	//输入验证
	if(index == 0){
		if(!updateGroupNumInput){
			$("#updateGroupInfo .form-control").eq(index).focus();
			return;
		}
		key = "num";
	}else if(index == 1){
		if(!updateGroupNameInput){
			$("#updateGroupInfo .form-control").eq(index).focus();
			return;
		}
		key = "name";
	}
	var data = "id="+groupId+"&"+key+"="+value;
	$.ajax({
		url:"teacherUpdateGroupInfo.action",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				//修改成功
				//弹窗消失
				$("#updateGroupInfo").modal("hide");
				//刷新数据
				initBasicInfo();
				//显示提示
				tips("success","修改成功!");
				//重置input
				$("#updateGroupInfo .form-control").removeClass("has-success");
			}
		}
	});
});

//获取小组信息并显示在界面上的函数
function initBasicInfo(){
	$.ajax({
		url:"teacherGetGroupInfo.action",
		type:"post",
		data:{"groupId":groupId},
		dataType:"json",
		success:function(result){
			if(result.msg == 1){
				var group = result.group;
				member = result.group.member;
				//显示小组基本信息
				$(".groupInfo li:eq(0) .info-content").text(group.num);
				$(".groupInfo li:eq(1) .info-content").text(group.name);
				//显示小组成员
				$(".table").empty();
				//生成表头
				var thead = $("<tr>"+
							"<th>序号</th>"+
							"<th>姓名</th>"+
							"<th>权限</th>"+
							"<th>操作</th>"+
						"</tr>");
				$(".table").append(thead);
				//将组长放在第一个位置
				if(group.leader != null){
					for(var i=0;i<member.length;i++){
						if(member[i].id == group.leader.id){
							var a = member[0];
							member[0] = member[i];
							member[i] = a;
							break;
						}
					}
				}
				
				var index = 1;
				//第一行数据显示组长信息
				if(group.leader != null){
					var tr = $("<tr>"+
						"<td>"+(index++)+"</td>"+
						"<td>"+group.leader.name+"</td>"+
						"<td>组长</td>"+
						"<td>"+
							"<button class='btn btn-danger btn-sm'>移除</button>"+
						"</td>"+
					"</tr>")
					$(".table").append(tr);
				}
				//循环生成成员数据
				for(var i=0;i<member.length;i++){
					if(group.leader == null || member[i].id != group.leader.id){
						var tr = $("<tr>"+
										"<td>"+(index++)+"</td>"+
										"<td>"+member[i].name+"</td>"+
										"<td>组员</td>"+
										"<td>"+
											" <button class='btn btn-danger btn-sm'>移除</button>"+
											" <button class='btn btn-warning btn-sm'>任为组长</button>"+
										"</td>"+
									"</tr>")
						$(".table").append(tr);
					}
				}
			}
		}
	});
}