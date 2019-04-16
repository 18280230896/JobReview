<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<title>任务详情</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<style type="text/css">
		.page-header{
			margin-top:20px;
		}
		.ul-info li:hover{
			background: rgb(245,245,245);
		}
		.option{
			cursor: pointer;
			display: none;
		}
		.update:hover,.add:hover,.download:hover{
			color: rgb(51,122,183);
		}
		.delete:hover{
			color: rgb(169,68,66);
		}
		.subjects{
			margin-bottom: 15px;
		}
	</style>
</head>
<body>
<input type="hidden" id="taskId" value="${task.id}">
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
		<!--任务信息-->
		<div class="col-md-4">
			<h3 class="page-header">任务详情</h3>
			<!--基本信息-->
			<div class="panel panel-info" id="taskInfo">
				<div class="panel-heading">
					<h4 class="panel-title">基本信息</h4>
				</div>
				<div class="panel-body text-muted">
					<ul class="list-unstyled ul-info">
						<li>
							<span>任务名称：</span>
							<span></span>
							<span class="glyphicon glyphicon-pencil option update"></span>
						</li>
						<li>
							<span>任务类型：</span>
							<span></span>
							<span class="glyphicon glyphicon-pencil option update"></span>
						</li>
					</ul>
				</div>
			</div>
			<!--题目列表-->
			<div class="panel panel-info" id="moduleList" style="position: relative;">
				<div class="panel-heading">
					<div class="panel-title">
						<span>题目列表</span>
						<span id="addSubjectBtn" class="glyphicon glyphicon-plus text-muted option add" style="position: absolute;right: 15px;top: 14px;"></span></button>
					</div>
				</div>
				<div class="panel-body text-muted">
					<ul class="list-unstyled ul-info" id="subjectList">
					</ul>
				</div>
			</div>
		</div>
		<!--执行任务的班级-->
		<div class="col-md-8">
			<h3 class="page-header">执行此任务的班级列表</h3>
			<table class="table table-hover table-striped">
				
			</table>
			<ul class="pagination pull-right">
				
			</ul>
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
						<input type="password" id="oldPwd" class="form-control">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label for="newPwd" class="control-label">新密码：</label>
						<input type="password" id="newPwd" class="form-control">
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label for="confirm" class="control-label">确认密码：</label>
						<input type="password" id="confirm" class="form-control">
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

<!--添加题目-->
<div class="modal fade" id="addSubjectModal">
	<div class="modal-dialog ">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">请输入题目</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<textarea id="subjectName" class="form-control"></textarea>
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary addBtn">添加</button>
			</div>
		</div>
	</div>
</div>



<!--修改任务信息模态框-->
<div class="modal fade" id="updateModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">修改任务名称</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label class="control-label">任务名称：</label>
						<input type="text" class="form-control" id="taskName"/>
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">任务类型：</label>
						<select class="form-control" id="taskType">
							<option value="1">Java 任务</option>
							<option value="2">Oracle 任务</option>
						</select>
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">题目名称：</label>
						<textarea class="form-control" rows="6"></textarea>
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<input type="hidden"/>
				<input type="hidden"/>
				<button class="btn btn-primary">修改</button>
			</div>
		</div>
	</div>
</div>

<!--确认删除-->
<div class="modal fade" id="dleModal">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">确定要删除吗？</h4>
			</div>
			<div class="modal-footer">
				<input type="hidden">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">确认</button>
			</div>
		</div>
	</div>
</div>

<!--操作提示模态框-->
<div class="modal fade" id="alert">
	<div class="modal-dialog modal-sm">
		<div class="alert text-center">
			<span id="msg" style="font-size:18px;"></span>
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

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/docs.min.js"></script>
<script src="js/userInfo.js"></script>
<script src="js/taskInfoBasics.js"></script>
<script src="js/taskInfoData.js"></script>
<script src="js/taskInfoPaging.js"></script>
</body>
</html>
</html>