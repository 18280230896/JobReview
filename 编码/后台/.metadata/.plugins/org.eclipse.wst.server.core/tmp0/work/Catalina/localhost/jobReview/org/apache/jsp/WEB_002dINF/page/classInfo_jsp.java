/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2019-04-13 13:15:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class classInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\t\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"img/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("\t<title>班级详情</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input id=\"classId\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("<!--导航-->\r\n");
      out.write("<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<a href=\"teacherIndex.action\" class=\"navbar-brand\">作业在线评审系统</a>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#mynavbar\" >\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"mynavbar\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"teacherToClassManage.action\">班级管理</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"teacherToTaskManage.action\">任务管理</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-link navbar-btn\" data-toggle=\"dropdown\"><span id=\"name\"></span> <span class=\"caret\"></span></button>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#changePwdModal\" data-toggle=\"modal\">修改密码</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#logout\" data-toggle=\"modal\">注销</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<ul class=\"nav nav-tabs\">\r\n");
      out.write("\t\t\t<li class=\"active\"><a href=\"#TaskManager\" data-toggle=\"tab\">班级任务管理</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#StudentManager\" data-toggle=\"tab\">班级学生管理</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"#GruopManager\" data-toggle=\"tab\">班级小组管理</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"tab-content\">\r\n");
      out.write("\t\t\t<div id=\"TaskManager\" class=\"tab-pane active\">\r\n");
      out.write("\t\t\t\t<!--任务管理-->\r\n");
      out.write("\t\t\t\t<h3 class=\"page-header\">班级执行的任务列表<button class=\"btn btn-primary pull-right\" data-toggle=\"modal\" data-target=\"#addTask\">添加任务</button></h3>\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover table-striped\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<ul class=\"pagination pull-right\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"StudentManager\" class=\"tab-pane\">\r\n");
      out.write("\t\t\t\t<!-- 学生管理 -->\r\n");
      out.write("\t\t\t\t<h3 class=\"page-header\">班级学生列表\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-primary pull-right\" style=\"margin-left: 10px\">批量导入</button> \r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-info pull-right\" data-toggle=\"modal\" data-target=\"#addStudent\">添加学生</button>\r\n");
      out.write("\t\t\t\t\t<form class=\"hide\" id=\"fileForm\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"file\" id=\"fileInput\" name=\"file\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"classId\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover table-striped\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<ul class=\"pagination pull-right\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"GruopManager\" class=\"tab-pane\">\r\n");
      out.write("\t\t\t\t<h3 class=\"page-header\">班级小组列表\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-primary pull-right\" data-toggle=\"modal\" data-target=\"#addGroupModal\">添加小组</button>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover table-striped\"></table>\r\n");
      out.write("\t\t\t\t<ul class=\"pagination pull-right\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--添加小组弹框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"addGroupModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">添加小组</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">小组编号：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">小组名称：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">小组口号：</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">备注信息：</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--修改学生模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"udpateStudnetModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">修改学生信息</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">姓名:</label>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">密码:</label>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--添加学生模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"addStudent\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">添加学生</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">姓名：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"name\"/>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">用户名：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"username\"/>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" placeholder=\"password\"/>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--确认删除提示框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"delModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\"></h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--修改任务模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"updateModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<div class=\"modal-title\">修改任务起止时间</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">任务名称：</label>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" readonly/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">评分占比：</label>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"form-control\" id=\"updateProportion\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">开始时间：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"updateStartTime\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">截止时间：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"updateEndTime\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--添加任务模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"addTask\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">请选择一个任务</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<div style=\"width: 100%; overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"body-content\" style=\"width: 200%;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-left\" style=\"width: 50%;height: 100%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"control-label\">选择任务：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"teskList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"control-label\">完成类型：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"taskType\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1\">个人任务</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2\">小组任务</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"control-label\">评分占比：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"proportion\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-right\" style=\"width: 50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"control-label\">开始时间：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"startTime\" type=\"text\" class=\"form-control\" placeholder=\"请选择任务开始时间\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"control-label\">截止时间：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"endTime\" type=\"text\" class=\"form-control\" placeholder=\"请选择任务截止时间\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<div style=\"width: 100%;overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-content\" style=\"width: 200%;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-left\" style=\"width: 50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary\" id=\"next\">下一步 <span class=\"glyphicon glyphicon-arrow-right\"></span></button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"pull-right\" style=\"width: 50%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary pull-left\" id=\"prev\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-arrow-left\"></span> 上一步\r\n");
      out.write("\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-primary add\">添加</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--修改密码模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"changePwdModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">修改密码</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"oldPwd\" class=\"control-label\">旧密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"oldPwd\" class=\"form-control\" placeholder=\"请输入旧密码\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"newPwd\" class=\"control-label\">新密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"newPwd\" class=\"form-control\" placeholder=\"请输入新密码\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"confirm\" class=\"control-label\">确认密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"confirm\" class=\"form-control\" placeholder='请再次输入新密码'>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"reset\" class=\"hidden reset\"></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">修改</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--操作提示模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"alert\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"alert text-center\">\r\n");
      out.write("\t\t\t<span id=\"msg\"></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 确认退出弹框 -->\r\n");
      out.write("<div class=\"modal fade\" id=\"logout\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">确定要注销当前用户吗？</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<a href=\"logout.action\"><button class=\"btn btn-primary\">确定</button></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"hide\">\r\n");
      out.write("\t<form action=\"teacherToReviewCase.action\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"ctId\">\r\n");
      out.write("\t\t<button type=\"submit\" id=\"toReviewCaseBtn\"></button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"teacherToReviewBug.action\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"ctId\">\r\n");
      out.write("\t\t<button type=\"submit\" id=\"toReviewBugBtn\"></button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"teacherToGroupInfo.action\" method=\"post\" id=\"toGroupInfo\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"groupId\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"bootstrap/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/docs.min.js\"></script>\r\n");
      out.write("<script src=\"js/classInfoBasic.js\"></script>\r\n");
      out.write("<script src=\"laydate/laydate.js\"></script>\r\n");
      out.write("<script src=\"js/userInfo.js\"></script>\r\n");
      out.write("<script src=\"js/classInfoTaskPaging.js\"></script>\r\n");
      out.write("<script src=\"js/classInfoStudentPaging.js\"></script>\r\n");
      out.write("<script src=\"js/classInfoGroupPaging.js\"></script>\r\n");
      out.write("<script src=\"js/classInfo.js\"></script>\r\n");
      out.write("<script src=\"js/classInfoBasic.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("laydate.render({\r\n");
      out.write("  elem: '#startTime',\r\n");
      out.write("  type: 'datetime'\r\n");
      out.write("});\r\n");
      out.write("laydate.render({\r\n");
      out.write("  elem: '#endTime',\r\n");
      out.write("  type: 'datetime'\r\n");
      out.write("});\r\n");
      out.write("laydate.render({\r\n");
      out.write("  elem: '#updateStartTime',\r\n");
      out.write("  type: 'datetime'\r\n");
      out.write("});\r\n");
      out.write("laydate.render({\r\n");
      out.write("  elem: '#updateEndTime',\r\n");
      out.write("  type: 'datetime'\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/page/classInfo.jsp(230,8) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setBegin(1);
      // /WEB-INF/page/classInfo.jsp(230,8) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setEnd(100);
      // /WEB-INF/page/classInfo.jsp(230,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("i");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("%</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /WEB-INF/page/classInfo.jsp(286,9) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setBegin(1);
      // /WEB-INF/page/classInfo.jsp(286,9) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setEnd(100);
      // /WEB-INF/page/classInfo.jsp(286,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("i");
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("%</option>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
