<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<title>${c.name}</title>
</head>
<body>
<input id="classId" type="hidden" value="${c.id}">
<!--导航-->
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a href="teacherIndex.action" class="navbar-brand">作业在线评审系统</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mynavbar" >
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="nav navbar-nav">
				<li><a href="teacherToClassManage.action">班级管理</a></li>
				<li><a href="teacherToTaskManage.action">任务管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<div class="dropdown">
					<button class="btn btn-link navbar-btn" data-toggle="dropdown"><span id="name"></span> <span class="caret"></span></button>
					<ul class="dropdown-menu">
						<li><a href="#changePwdModal" data-toggle="modal">修改密码</a></li>
						<li><a href="#logout" data-toggle="modal">注销</a></li>
					</ul>
				</div>
			</ul>
		</div>
	</div>
</nav>

<div class="container">
	<div class="row">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#TaskManager" data-toggle="tab">班级任务管理</a></li>
			<li><a href="#StudentManager" data-toggle="tab">班级学生管理</a></li>
			<li><a href="#GruopManager" data-toggle="tab">班级小组管理</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="tab-content">
			<div id="TaskManager" class="tab-pane active">
				<!--任务管理-->
				<h3 class="page-header">班级执行的任务列表<button class="btn btn-primary pull-right" data-toggle="modal" data-target="#addTask">添加任务</button></h3>
				<table class="table table-hover table-striped">
					
				</table>
				<ul class="pagination pull-right"></ul>
			</div>
			<div id="StudentManager" class="tab-pane">
				<!-- 学生管理 -->
				<h3 class="page-header">班级学生列表
					<button class="btn btn-primary pull-right" style="margin-left: 10px">批量导入</button> 
					<button class="btn btn-info pull-right" data-toggle="modal" data-target="#addStudent">添加学生</button>
					<form class="hide" id="fileForm" enctype="multipart/form-data">
						<input type="file" id="fileInput" name="file"/>
						<input type="hidden" value="${c.id}" name="cid">
					</form>
				</h3>
				<table class="table table-hover table-striped">
					
				</table>
				<ul class="pagination pull-right"></ul>
			</div>
			<div id="GruopManager" class="tab-pane">
				<h3 class="page-header">班级小组列表
					<button class="btn btn-primary pull-right" data-toggle="modal" data-target="#addGroupModal">添加小组</button>
				</h3>
				<table class="table table-hover table-striped"></table>
				<ul class="pagination pull-right"></ul>
			</div>
		</div>
	</div>
</div>

<!--添加小组弹框-->
<div class="modal fade" id="addGroupModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">添加小组</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label class="control-label">小组编号：</label>
						<input type="text" class="form-control">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">小组名称：</label>
						<input type="text" class="form-control">
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">提交</button>
			</div>
		</div>
	</div>
</div>

<!--修改学生模态框-->
<div class="modal fade" id="udpateStudnetModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">修改学生信息</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label class="control-label">姓名:</label>
						<input class="form-control" type="text">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">密码:</label>
						<input class="form-control" type="password">
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<input type="hidden">
				<button class="btn btn-primary">提交</button>
			</div>
		</div>
	</div>
</div>

<!--添加学生模态框-->
<div class="modal fade" id="addStudent">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">添加学生</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label class="control-label">姓名：</label>
						<input type="text" class="form-control" placeholder="name"/>
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">用户名：</label>
						<input type="text" class="form-control" placeholder="username"/>
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">密码：</label>
						<input type="password" class="form-control" placeholder="password"/>
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">提交</button>
			</div>
		</div>
	</div>
</div>

<!--确认删除提示框-->
<div class="modal fade" id="delModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<input type="hidden">
				<input type="hidden">
				<button class="btn btn-primary">提交</button>
			</div>
		</div>
	</div>
</div>

<!--修改任务模态框-->
<div class="modal fade" id="updateModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<div class="modal-title">修改任务起止时间</div>
			</div>
			<div class="modal-body">
				<form>
					<input type="hidden">
					<div class="form-group">
						<label class="control-label">任务名称：</label>
						<input class="form-control" type="text" readonly/>
					</div>
					<div class="form-group">
						<label class="control-label">评分占比：</label>
							<select class="form-control" id="updateProportion">
								<c:forEach begin="1" end="100" var="i">
									<option value="${i}">${i}%</option>
								</c:forEach>
							</select>
					</div>
					<div class="form-group">
						<label class="control-label">开始时间：</label>
						<input type="text" id="updateStartTime" class="form-control">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">截止时间：</label>
						<input type="text" id="updateEndTime" class="form-control">
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">提交</button>
			</div>
		</div>
	</div>
</div>


<!--添加任务模态框-->
<div class="modal fade" id="addTask">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">请选择一个任务</h4>
			</div>
			<div class="modal-body">
				<div style="width: 100%; overflow: hidden;">
					<div class="body-content" style="width: 200%;">
						<div class="pull-left" style="width: 50%;height: 100%;">
							<div class="form-group">
								<label class="control-label">选择任务：</label>
								<select class="form-control" id="teskList">
								</select>
								<span class="help-block"></span>
							</div>
							<div class="form-group">
								<label class="control-label">完成类型：</label>
								<select class="form-control" id="taskType">
									<option value="1">个人任务</option>
									<option value="2">小组任务</option>
								</select>
								<span class="help-block"></span>
							</div>
							<div class="form-group">
								<label class="control-label">评分占比：</label>
								<select class="form-control" id="proportion">
									<c:forEach begin="1" end="100" var="i">
										<option value="${i}">${i}%</option>
									</c:forEach>
								</select>
								<span class="help-block"></span>
							</div>
						</div>
						<div class="pull-right" style="width: 50%;">
							<form>
								<input type="hidden">
								<div class="form-group">
									<label class="control-label">开始时间：</label>
									<input id="startTime" type="text" class="form-control" placeholder="请选择任务开始时间"/>
									<span class="help-block"></span>
								</div>
								<div class="form-group">
									<label class="control-label">截止时间：</label>
									<input id="endTime" type="text" class="form-control" placeholder="请选择任务截止时间"/>
									<span class="help-block"></span>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div style="width: 100%;overflow: hidden;">
					<div class="footer-content" style="width: 200%;">
						<div class="pull-left" style="width: 50%;">
							<button class="btn btn-default" data-dismiss="modal">取消</button>
							<button class="btn btn-primary" id="next">下一步 <span class="glyphicon glyphicon-arrow-right"></span></button>
						</div>
						<div class="pull-right" style="width: 50%;">
							<button class="btn btn-primary pull-left" id="prev">
								<span class="glyphicon glyphicon-arrow-left"></span> 上一步
							</button>
							<button class="btn btn-default" data-dismiss="modal">取消</button>
							<button class="btn btn-primary add">添加</button>
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
</div>

<!--修改密码模态框-->
<div class="modal fade" id="changePwdModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">修改密码</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="oldPwd" class="control-label">旧密码：</label>
						<input type="password" id="oldPwd" class="form-control" placeholder="请输入旧密码">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label for="newPwd" class="control-label">新密码：</label>
						<input type="password" id="newPwd" class="form-control" placeholder="请输入新密码">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label for="confirm" class="control-label">确认密码：</label>
						<input type="password" id="confirm" class="form-control" placeholder='请再次输入新密码'>
						<span class="help-block"></span>
					</div>
					<button type="reset" class="hidden reset"></button>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">修改</button>
			</div>
		</div>
	</div>
</div>


<!--操作提示模态框-->
<div class="modal fade" id="alert">
	<div class="modal-dialog modal-sm">
		<div class="alert text-center">
			<span id="msg" style="font-size: 17px;"></span>
		</div>
	</div>
</div>

<!-- 确认退出弹框 -->
<div class="modal fade" id="logout">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">确定要注销当前用户吗？</h4>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<a href="logout.action"><button class="btn btn-primary">确定</button></a>
			</div>
		</div>
	</div>
</div>

<div class="hide">
	<form action="teacherToReviewBug.action" method="post">
		<input type="hidden" name="ctId">
		<button type="submit" id="toReviewBugBtn"></button>
	</form>
	<form action="teacherToGroupInfo.action" method="post" id="toGroupInfo">
		<input type="hidden" name="groupId">
	</form>
</div>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/docs.min.js"></script>
<script src="laydate/laydate.js"></script>
<script src="js/userInfo.js"></script>
<script src="js/classInfoTaskPaging.js"></script>
<script src="js/classInfoStudentPaging.js"></script>
<script src="js/classInfoGroupPaging.js"></script>
<script src="js/classInfoBasic.js"></script>
<script src="js/classInfo.js"></script>
<script>
laydate.render({
  elem: '#startTime',
  type: 'datetime'
});
laydate.render({
  elem: '#endTime',
  type: 'datetime'
});
laydate.render({
  elem: '#updateStartTime',
  type: 'datetime'
});
laydate.render({
  elem: '#updateEndTime',
  type: 'datetime'
});
</script>
</body>
</html>