//能显示的最大分页条数
var maxShowPage = 5;
//一页最大显示的数据条数
var pageSize = 6;
//当前页数
var taskNowPage;
//数据条数
var taskCount;
//总页数
var taskTotalPage;
//数据
var classTasks;
var classId = $("#classId").val();

initTaskList();
//初始化方法 显示第一页内容
function initTaskList(){
	//初始化当前页数
	taskNowPage = 1;
	getTaskCount("teacherGetClassTaskTotal.action");
	showTaskPage(taskNowPage);
	createTaskTabs();
}

//显示某一页
function showTaskPage(page){
	taskNowPage = page;
	getTaskData("teacherGetClassTaskList.action");
	createTaskTable();
}

//获取数据条数初始化count和totalPage
function getTaskCount(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"classId":classId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				taskCount = result.count;
				taskTotalPage = Math.ceil(taskCount/pageSize);
				if(taskTotalPage == 0) taskTotalPage = 1;
			}
		}
		
	});
}

//获取数据
function getTaskData(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"classId":classId,"startNum":(taskNowPage-1)*pageSize,"pageSize":pageSize},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				classTasks = result.classTasks;
			}
		}
	});
}

//循环生成表格显示数据
function createTaskTable(){
	$("#TaskManager table").empty();
	//创建表头
	var thead = $("<tr>"+
					"<th>序号</th>"+
					"<th>任务名称</th>"+
					"<th>任务类型</th>"+
					"<th>完成类型</th>"+
					"<th>评分占比</th>"+
					"<th>开始时间</th>"+
					"<th>截止时间</th>"+
					"<th>状态</th>"+
					"<th>操作</th>"+
				"</tr>");
	$("#TaskManager table").append(thead);
	//循环创建数据条目
	for(var i=0;i<classTasks.length;i++){
		var status;
		var statusClass;
		var taskType;
		var carryType;
		if(classTasks[i].status == 1){
			status = "未开始";
			statusClass = "text-info";
		}else if(classTasks[i].status == 2){
			status = "进行中";
			statusClass = "text-success";
		}else if(classTasks[i].status == 3){
			status = "已结束";
			statusClass = "text-danger";
		}
		if(classTasks[i].task.type == 1) taskType = "Java 任务";
		if(classTasks[i].task.type == 2) taskType = "Oracle 任务";
		if(classTasks[i].type == 1) carryType="个人任务";
		if(classTasks[i].type == 2) carryType="小组任务";
		
		var tr = $("<tr>"+
						"<td>"+((taskNowPage-1)*pageSize+i+1)+"</td>"+
						"<td>"+classTasks[i].task.name+"</td>"+
						"<td>"+taskType+"</td>"+
						"<td>"+carryType+"</td>"+
						"<td>"+classTasks[i].proportion+"%</td>"+
						"<td>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(classTasks[i].startTime))+"</td>"+
						"<td>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(classTasks[i].endTime))+"</td>"+
						"<td class='"+statusClass+"'>"+status+"</td>"+
						"<td>"+
							" <button class='btn btn-primary btn-sm'>批阅</button>"+
							" <button class='btn btn-info btn-sm'>修改</button>"+
							" <button class='btn btn-danger btn-sm'>删除</button>"+
							" <button class='btn btn-warning btn-sm'>立即截止</button>"+
						"</td>"+
					"</tr>");
		$("#TaskManager table").append(tr);
	}
	
}

//分页条点击事件
$("#TaskManager .pagination").click(function(event){
	if(event.target.nodeName == "A"){
		if($(event.target).attr("class") == "prev"){
			//点击上一页
			taskPrev();
		}else if($(event.target).attr("class") == "next"){
			//点击下一页
			taskNext();
		}else{
			//点击其他分页条目
			taskToPage(event.target);
		}
	}
	
});

//初始化分页条
function createTaskTabs(){
	$("#TaskManager .pagination").empty();
	//生成上一页按钮
	$("#TaskManager .pagination").append($("<li>"+
					"<a href='javascript:' class='prev'>&laquo;</a>"+
					"</li>"));
	//生成跳页按钮
	for(var i=1;i<=maxShowPage&&i<=taskTotalPage;i++){
		$("#TaskManager .pagination").append($("<li><a href='javascript:' >"+i+"</a></li>"));
	}
	$("#TaskManager .pagination li").eq(1).addClass("active");
	//生成下一页按钮
	$("#TaskManager .pagination").append($("<li>"+
			"<a href='javascript:' class='next'>&raquo;</a>"+
			"</li>"));
}

//上一页
function taskPrev(){
	if(taskNowPage <= 1){
		return;
	}else{
		taskNowPage --;
		showTaskPage(taskNowPage);
		if($("#TaskManager .pagination .active").index() > 3){
			$("#TaskManager .pagination .active").removeClass("active").prev().addClass("active");
		}else{
			if(taskNowPage > 2){
				//删除最后一个分页条
				$("#TaskManager .pagination .next").parent().prev().remove();
				//在最前面增加一个分页条
				$("#TaskManager .pagination .prev").parent().after($("<li><a href='javascript:' >"+(taskNowPage-2)+"</a></li>"));
				//.active前移
				$("#TaskManager .pagination .active").removeClass("active").prev().addClass("active");
			}else{
				$("#TaskManager .pagination .active").removeClass("active").prev().addClass("active");
			}
		}
		
	}
}

//下一页
function taskNext(){
	if(taskNowPage >= taskTotalPage){
		return;
	}else{
		taskNowPage ++;
		showTaskPage(taskNowPage);
		if($("#TaskManager .pagination .active").index() < 3){
			$("#TaskManager .pagination .active").removeClass("active").next().addClass("active");
		}else{
			if(taskTotalPage-1 > taskNowPage){
				//删除第一个分页条
				$("#TaskManager .pagination .prev").parent().next().remove();
				//在最后增加一个分页条
				$("#TaskManager .pagination .next").parent().before($("<li><a href='javascript:'>"+(taskNowPage+2)+"</a></li>"));
				//.active下移
				$("#TaskManager .pagination .active").removeClass("active").next().addClass("active");
			}else{
				$("#TaskManager .pagination .active").removeClass("active").next().addClass("active");
			}
		}
		
	}
}

//点击其他分页条目
function taskToPage(target){
	taskNowPage = parseInt($(target).text());
	showTaskPage(taskNowPage);
	//target获取.active
	$(target).parent().addClass("active").siblings().removeClass("active");
	var index = $(target).parent().index();
	if(index < 3){
		for(var i=taskNowPage-index;i>0&&i>taskNowPage-3;i--){
			//删除最后一个分页条
			$("#TaskManager .pagination .next").parent().prev().remove();
			//在最前面增加一个分页条
			$("#TaskManager .pagination .prev").parent().after($("<li><a href='javascript:' >"+i+"</a></li>"));
		}
	}else if(index > 3){
		for(var i=taskNowPage+(6-index);i<=taskTotalPage&&i<taskNowPage+3;i++){
			//删除第一个分页条
			$("#TaskManager .pagination .prev").parent().next().remove();
			//在最后增加一个分页条
			$("#TaskManager .pagination .next").parent().before($("<li><a href='javascript:'>"+i+"</a></li>"));
		}
	}
}


function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}