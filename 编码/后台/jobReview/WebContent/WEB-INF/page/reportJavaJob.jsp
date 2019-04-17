<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	<title>${task.name}</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="codemirror/lib/codemirror.css">
	<link rel="stylesheet" type="text/css" href="css/reportJavaJob.css">
</head>
<body>
<input value="${classTask.id}" class="hidden" id="ctid">
<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="nav-header">
			<a href="studentIndex.action" class="navbar-brand">作业在线评审系统</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mynavbar" >
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="nav navbar-nav navbar-right">
				<div class="dropdown">
					<button type="button" class="navbar-btn btn btn-link dropdown-toggle" data-toggle="dropdown"><span id="name"></span> <span class="caret"></span></button>
					<ul class="dropdown-menu">
						<li><a href="#changePwdModal" data-toggle="modal">修改密码</a></li>
						<li><a href="#logout" data-toggle="modal">注销</a></li>
					</ul>
				</div>
			</ul>
		</div>
	</div>
</nav>

<!-- main-->
<div class="container">
	<!--题干区域-->
	<div class="row subject-box">
		<!--上一题-->
		<div class="col-md-1">
			<button class="btn btn-block btn-info prevSubject"><span class="glyphicon glyphicon-chevron-left"></span></button>
		</div>
		<div class="col-md-10 box">
			<ul class="content-list">
				
			</ul>
		</div>
		<!--下一题-->
		<div class="col-md-1">
			<button class="btn btn-block btn-info nextSubject"><span class="glyphicon glyphicon-chevron-right"></span></button>
		</div>
	</div>
	<!--代码编辑区域-->
	<div class="row code-box">
		<div class="col-md-6 test">
			<textarea id="code">public static void main(String[] args){
  //欢迎使用作业在线评审系统在线编程工具
  
  
}</textarea>
		</div>
		<div class="col-md-1">
			<button class="btn btn-success btn-block" id="run">运行</button>
			<button class="btn btn-primary btn-block" id="submitBtn">提交</button>
		</div>
		<div class="col-md-5">
			<div class="console"></div>
		</div>
	</div>
</div>

<!--调整分工-->
<div class="modal fade" id="updatefengong">
	<input type="hidden" id="moduleId">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">修改分工</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label">小组所有成员：</label>
							<select class="form-control" style="height: 200px" multiple>
							</select>
						</div>
					</div>
					<div class="col-md-2" style="margin-top: 60px;">
						<div class="row">
							<button class="btn btn-info btn-sm btn-block" id="add"><span class="glyphicon glyphicon-chevron-right"></span></button>
							<button class="btn btn-info btn-sm btn-block" id="remove"><span class="glyphicon glyphicon-chevron-left"></span></button>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label">负责该题目的成员：</label>
							<select class="form-control" style="height: 200px" multiple>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" data-dismiss="modal">完成</button>
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
						<input type="password" id="confirm" class="form-control" placeholder="请再次输入新密码">
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

<!-- 确认操作弹框 -->
<div class="modal fade" id="confirmSubmit">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" data-dismiss="modal">&times</span>
				<h4 class="modal-title">你已经提交过了，确认要覆盖吗？</h4>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">取消</button>
				<button class="btn btn-primary">确定</button>
			</div>
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

<!--操作提示模态框-->
<div class="modal fade" id="alert">
	<div class="modal-dialog modal-sm">
		<div class="alert text-center">
			<span id="msg" style="font-size: 18px;"></span>
		</div>
	</div>
</div>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/docs.min.js"></script>
<script src="codemirror/lib/codemirror.js"></script>
<script src="codemirror/mode/clike/clike.js"></script>
<script src="js/code.js"></script>
<script src="js/userInfo.js"></script>
<script src="js/reportJavaJobBasic.js"></script>
</body>
</html>