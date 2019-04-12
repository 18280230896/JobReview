//分页显示教师
var maxShowPage = 5;
var pageSize = 6;
var nowPage;
var count;
var totalPage;
var teachers;
init();
//初始化方法 显示第一页内容
function init(){
	//初始化当前页数
	nowPage = 1;
	getCount("adminGetTeacherNum.action");
	showPage(nowPage);
	createTabs();
}

//显示某一页
function showPage(page){
	nowPage = page;
	getData("adminGetTeacherList.action");
	createTable();
}

//获取数据条数初始化count和totalPage
function getCount(url){
	$.ajax({
		url:url,
		type:"post",
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
		data:{"startNum":(nowPage-1)*pageSize,"pageSize":pageSize},
		dataType:"json",
		async:false,
		success:function(result){
			if(result.msg == 1){
				teachers = result.teachers;
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
				"<th>姓名</th>"+
				"<th>用户名</th>"+
				"<th>密码</th>"+
				"<th>操作</th>"+
			"</tr>");
	$("table").append(thead);
	//循环创建数据条目
	for(var i=0;i<teachers.length;i++){
		var tr = $("<tr>"+
				"<td>"+((nowPage-1)*pageSize+i+1)+"</td>"+
				"<td>"+teachers[i].name+"</td>"+
				"<td>"+teachers[i].username+"</td>"+
				"<td>"+teachers[i].password+"</td>"+
				"<td>"+
					" <button class='btn btn-warning btn-sm' id='update'>修改</button>"+
					" <button class='btn btn-danger btn-sm' id='delete'>删除</button>"+
				"</td>"+
			"</tr>");
		$("table").append(tr);
	}
	
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