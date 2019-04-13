//当前页数
var studentNowPage;
//数据条数
var studentCount;
//总页数
var studentTotalPage;
//数据
var students;

studentInit();
//初始化方法 显示第一页内容
function studentInit(){
	//初始化当前页数
	studentNowPage = 1;
	studentGetCount("teacherGetStudentCount.action");
	studentShowPage(studentNowPage);
	studentcreateTabs();
}

//显示某一页
function studentShowPage(page){
	studentNowPage = page;
	getStudents("teacherGetStudentList.action");
	studentCreateTable();
}

//获取数据条数初始化count和totalPage
function studentGetCount(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"classId":classId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				studentCount = result.count;
				studentTotalPage = Math.ceil(studentCount/pageSize);
				if(studentTotalPage == 0) studentTotalPage = 1;
			}
		}
		
	});
}

//获取数据
function getStudents(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"classId":classId,"startNum":(studentNowPage-1)*pageSize,"pageSize":pageSize},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				students = result.students;
			}
		}
	});
}

//循环生成表格显示数据
function studentCreateTable(){
	$("#StudentManager table").empty();
	//创建表头
	var thead = $("<tr>"+
						"<th>序号</th>"+
						"<th>姓名</th>"+
						"<th>用户名</th>"+
						"<th>密码</th>"+
						"<th>操作</th>"+
					"</tr>");
	$("#StudentManager table").append(thead);
	//循环创建数据条目
	for(var i=0;i<students.length;i++){
		var tr = $("<tr>"+
						"<td>"+((studentNowPage-1)*pageSize+i+1)+"</td>"+
						"<td>"+students[i].studentName+"</td>"+
						"<td>"+students[i].studentUserName+"</td>"+
						"<td>"+students[i].studentPwd+"</td>"+
						"<td>"+
							" <button class='btn btn-danger btn-sm'>删除</button>"+
							" <button class='btn btn-primary btn-sm'>修改</button>"+
						"</td>"+
					"</tr>");
		$("#StudentManager table").append(tr);
	}
	
}

//分页条点击事件
$("#StudentManager .pagination").click(function(event){
	if(event.target.nodeName == "A"){
		if($(event.target).attr("class") == "prev"){
			//点击上一页
			studentPrev();
		}else if($(event.target).attr("class") == "next"){
			//点击下一页
			studentNext();
		}else{
			//点击其他分页条目
			studentToPage(event.target);
		}
	}
	
});

//初始化分页条
function studentcreateTabs(){
	$("#StudentManager .pagination").empty();
	//生成上一页按钮
	$("#StudentManager .pagination").append($("<li>"+
					"<a href='javascript:' class='prev'>&laquo;</a>"+
					"</li>"));
	//生成跳页按钮
	for(var i=1;i<=maxShowPage&&i<=studentTotalPage;i++){
		$("#StudentManager .pagination").append($("<li><a href='javascript:' >"+i+"</a></li>"));
	}
	$("#StudentManager .pagination li").eq(1).addClass("active");
	//生成下一页按钮
	$("#StudentManager .pagination").append($("<li>"+
			"<a href='javascript:' class='next'>&raquo;</a>"+
			"</li>"));
}

//上一页
function studentPrev(){
	if(studentNowPage <= 1){
		return;
	}else{
		studentNowPage --;
		studentShowPage(studentNowPage);
		if($("#StudentManager .pagination .active").index() > 3){
			$("#StudentManager .pagination .active").removeClass("active").prev().addClass("active");
		}else{
			if(studentNowPage > 2){
				//删除最后一个分页条
				$("#StudentManager .pagination .next").parent().prev().remove();
				//在最前面增加一个分页条
				$("#StudentManager .pagination .prev").parent().after($("<li><a href='javascript:' >"+(studentNowPage-2)+"</a></li>"));
				//.active前移
				$("#StudentManager .pagination .active").removeClass("active").prev().addClass("active");
			}else{
				$("#StudentManager .pagination .active").removeClass("active").prev().addClass("active");
			}
		}
		
	}
}

//下一页
function studentNext(){
	if(studentNowPage >= studentTotalPage){
		return;
	}else{
		studentNowPage ++;
		studentShowPage(studentNowPage);
		if($("#StudentManager .pagination .active").index() < 3){
			$("#StudentManager .pagination .active").removeClass("active").next().addClass("active");
		}else{
			if(studentTotalPage-1 > studentNowPage){
				//删除第一个分页条
				$("#StudentManager .pagination .prev").parent().next().remove();
				//在最后增加一个分页条
				$("#StudentManager .pagination .next").parent().before($("<li><a href='javascript:'>"+(studentNowPage+2)+"</a></li>"));
				//.active下移
				$("#StudentManager .pagination .active").removeClass("active").next().addClass("active");
			}else{
				$("#StudentManager .pagination .active").removeClass("active").next().addClass("active");
			}
		}
		
	}
}

//点击其他分页条目
function studentToPage(target){
	studentNowPage = parseInt($(target).text());
	studentShowPage(studentNowPage);
	//target获取.active
	$(target).parent().addClass("active").siblings().removeClass("active");
	var index = $(target).parent().index();
	if(index < 3){
		for(var i=studentNowPage-index;i>0&&i>studentNowPage-3;i--){
			//删除最后一个分页条
			$("#StudentManager .pagination .next").parent().prev().remove();
			//在最前面增加一个分页条
			$("#StudentManager .pagination .prev").parent().after($("<li><a href='javascript:' >"+i+"</a></li>"));
		}
	}else if(index > 3){
		for(var i=studentNowPage+(6-index);i<=studentTotalPage&&i<studentNowPage+3;i++){
			//删除第一个分页条
			$("#StudentManager .pagination .prev").parent().next().remove();
			//在最后增加一个分页条
			$("#StudentManager .pagination .next").parent().before($("<li><a href='javascript:'>"+i+"</a></li>"));
		}
	}
}