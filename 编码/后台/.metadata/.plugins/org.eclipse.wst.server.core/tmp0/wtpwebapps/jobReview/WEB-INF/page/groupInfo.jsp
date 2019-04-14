<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<title>小组详情</title>
	<style type="text/css">
		.groupInfo li{
			line-height: 34px;
			font-size: 14px;
		}
		.glyphicon-pencil{
			display: none;
			cursor: pointer;
		}
		.glyphicon-pencil:hover{
			color: rgb(51,122,183);
		}
	</style>
</head>
<body>
<input type="hidden" value="${group.id}" id="groupId">
<input type="hidden" value="${group.c.id}" id="classId">
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
	<ul class="breadcrumb">
	  <li><a href="teacherIndex.action">主页</a></li>
	  <li><a href="teacherToClassManage.action">班级管理</a></li>
	  <li><a href="javaScript:" id="toClassInfoBtn">班级详情</a></li>
	  <li class="active">小组详情</li>
	</ul>
	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-info" style="margin-top: 10px;">
				<div class="panel-heading">
					<h4 class="panel-title">基本信息</h4>
				</div>
				<div class="panel-body">
					<ul class="list-unstyled groupInfo">
					<li>
						<span class="info-title">小组编号：</span>
						<span class="info-content"></span>
						<span class="glyphicon glyphicon-pencil"></span>
					</li>
					<li>
						<span class="info-title">小组名称：</span>
						<span class="info-content"></span>
						<span class="glyphicon glyphicon-pencil"></span>
					</li>
				</ul>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<h4 class="page-header" style="margin-top: 20px;">小组成员
				<button class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#addMember">添加成员</button>
			</h4>
			<table class="table table-hover table-striped"></table>
		</div>
	</div>
</div>

<!--操作确认弹框-->
<div class="modal fade" id="confirm">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">xxxxxx</h4>
			</div>
			<div class="modal-footer">
				<input type="hidden">
				<input type="hidden">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">确定</button>
			</div>
		</div>
	</div>
</div>

<!--添加组员模态框-->
<div class="modal fade" id="addMember">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">添加成员</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label class="control-label">请选择要添加的学生：</label>
						<select class="form-control" multiple>
						</select>
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">添加</button>
			</div>
		</div>
	</div>
</div>

<!--修改基本信息模态框-->
<div class="modal fade" id="updateGroupInfo">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">修改小组基本信息</h4>
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
					<div class="form-group">
						<label class="control-label">小组口号：</label>
						<textarea class="form-control"></textarea>
						<span class="help-block"></span>
					</div>
					<div class="form-group">
						<label class="control-label">备注信息：</label>
						<textarea class="form-control"></textarea>
						<span class="help-block"></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">修改</button>
				<input type="hidden">
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
			<span id="msg" style="font-size: 18px;"></span>
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
	<form action="teacherToClassInfo.action" method="post" id="toClassInfo">
		<input name="classId" type="hidden" value="${group.c.id}">
	</form>
</div>
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/docs.min.js"></script>
<script src="js/userInfo.js"></script>
<script src="js/groupInfoBasic.js"></script>
<script src="js/groupInfoData.js"></script>
<script>
	$("#toClassInfoBtn").click(function(){
		$("#toClassInfo")[0].submit();
	});
</script>
</body>
</html>