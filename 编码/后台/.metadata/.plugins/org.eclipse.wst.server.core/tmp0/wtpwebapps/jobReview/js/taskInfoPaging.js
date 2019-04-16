//能显示的最大分页条数
var maxShowPage = 5;
//一页最大显示的数据条数
var pageSize = 6;
//当前页数
var nowPage;
//数据条数
var count;
//总页数
var totalPage;
//数据
var data;


init();
//初始化方法 显示第一页内容
function init(){
	//初始化当前页数
	nowPage = 1;
	getCount("teacherGetExeTaskClassTotal.action");
	showPage(nowPage);
	createTabs();
}

//显示某一页
function showPage(page){
	nowPage = page;
	getData("teacherGetExeTaskClassList.action");
	createTable();
}

//获取数据条数初始化count和totalPage
function getCount(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"taskId":taskId},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				count = result.count;
				totalPage = Math.ceil(count/pageSize);
				if(totalPage == 0) totalPage = 1;
			}
		}
		
	});
}

//获取数据
function getData(url){
	$.ajax({
		url:url,
		type:"post",
		data:{"taskId":taskId,"startNum":(nowPage-1)*pageSize,"pageSize":pageSize},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				data = result.classTasks;
			}
		}
	});
}

//循环生成表格显示数据
function createTable(){
	$("table").empty();
	//创建表头
	var thead = $("<tr>"+
					"<th>序号</th>"+
					"<th>班级名称</th>"+
					"<th>完成类型</th>"+
					"<th>所属学期</th>"+
					"<th>开始时间</th>"+
					"<th>结束时间</th>"+
					"<th>状态</th>"+
					"<th>操作</th>"+
				"</tr>");
	$("table").append(thead);
	//循环创建数据条目
	for(var i=0;i<data.length;i++){
		var status;
		var bg;
		var type;
		var semester;
		if(data[i].status == 1){
			status = "未开始";
			bg = "text-info"
		}else if(data[i].status == 2){
			status = "进行中";
			bg = "text-success"
		}else if(data[i].status == 3){
			status = "已结束";
			bg = "text-danger"
		}
		data[i].type == 1 ? type = "个人任务" : type = "小组任务";
		
		switch(data[i].semester){
		case 1 : semester = "大一上期";
		case 2 : semester = "大一下期";
		case 3 : semester = "大二上期";
		case 4 : semester = "大二下期";
		case 5 : semester = "大三上期";
		case 6 : semester = "大三下期";
		case 7 : semester = "大四上期";
		case 8 : semester = "大四下期";
		}
		var tr = $("<tr>"+
					"<td>"+((nowPage-1)*pageSize+i+1)+"</td>"+
					"<td>"+data[i].c.name+"</td>"+
					"<td>"+type+"</td>"+
					"<td>"+semester+"</td>"+
					"<td>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(data[i].startTime))+"</td>"+
					"<td>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(data[i].endTime))+"</td>"+
					"<td class='"+bg+"'>"+status+"</td>"+
					"<td><button class='btn btn-sm btn-primary'>批阅</button></td>"+
				"</tr>");
		$("table").append(tr);
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


//分页条点击事件
$(".pagination").click(function(event){
	if(event.target.nodeName == "A"){
		if($(event.target).attr("class") == "prev"){
			//点击上一页
			prev();
		}else if($(event.target).attr("class") == "next"){
			//点击下一页
			next();
		}else{
			//点击其他分页条目
			toPage(event.target);
		}
	}
	
});

//初始化分页条
function createTabs(){
	$(".pagination").empty();
	//生成上一页按钮
	$(".pagination").append($("<li>"+
					"<a href='javascript:' class='prev'>&laquo;</a>"+
					"</li>"));
	//生成跳页按钮
	for(var i=1;i<=maxShowPage&&i<=totalPage;i++){
		$(".pagination").append($("<li><a href='javascript:' >"+i+"</a></li>"));
	}
	$(".pagination li").eq(1).addClass("active");
	//生成下一页按钮
	$(".pagination").append($("<li>"+
			"<a href='javascript:' class='next'>&raquo;</a>"+
			"</li>"));
}

//上一页
function prev(){
	if(nowPage <= 1){
		return;
	}else{
		nowPage --;
		showPage(nowPage);
		if($(".pagination .active").index() > 3){
			$(".pagination .active").removeClass("active").prev().addClass("active");
		}else{
			if(nowPage > 2){
				//删除最后一个分页条
				$(".pagination .next").parent().prev().remove();
				//在最前面增加一个分页条
				$(".pagination .prev").parent().after($("<li><a href='javascript:' >"+(nowPage-2)+"</a></li>"));
				//.active前移
				$(".pagination .active").removeClass("active").prev().addClass("active");
			}else{
				$(".pagination .active").removeClass("active").prev().addClass("active");
			}
		}
		
	}
}

//下一页
function next(){
	if(nowPage >= totalPage){
		return;
	}else{
		nowPage ++;
		showPage(nowPage);
		if($(".pagination .active").index() < 3){
			$(".pagination .active").removeClass("active").next().addClass("active");
		}else{
			if(totalPage-1 > nowPage){
				//删除第一个分页条
				$(".pagination .prev").parent().next().remove();
				//在最后增加一个分页条
				$(".pagination .next").parent().before($("<li><a href='javascript:'>"+(nowPage+2)+"</a></li>"));
				//.active下移
				$(".pagination .active").removeClass("active").next().addClass("active");
			}else{
				$(".pagination .active").removeClass("active").next().addClass("active");
			}
		}
		
	}
}

//点击其他分页条目
function toPage(target){
	nowPage = parseInt($(target).text());
	showPage(nowPage);
	//target获取.active
	$(target).parent().addClass("active").siblings().removeClass("active");
	var index = $(target).parent().index();
	if(index < 3){
		for(var i=nowPage-index;i>0&&i>nowPage-3;i--){
			//删除最后一个分页条
			$(".pagination .next").parent().prev().remove();
			//在最前面增加一个分页条
			$(".pagination .prev").parent().after($("<li><a href='javascript:' >"+i+"</a></li>"));
		}
	}else if(index > 3){
		for(var i=nowPage+(6-index);i<=totalPage&&i<nowPage+3;i++){
			//删除第一个分页条
			$(".pagination .prev").parent().next().remove();
			//在最后增加一个分页条
			$(".pagination .next").parent().before($("<li><a href='javascript:'>"+i+"</a></li>"));
		}
	}
}