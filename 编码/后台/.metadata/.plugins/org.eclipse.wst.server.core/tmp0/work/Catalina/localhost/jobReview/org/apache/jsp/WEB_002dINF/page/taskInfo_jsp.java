/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2019-04-16 01:45:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class taskInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
  }

  public void _jspDestroy() {
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"img/favicon.ico\" type=\"image/x-icon\">\r\n");
      out.write("\t<title>任务详情</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.page-header{\r\n");
      out.write("\t\t\tmargin-top:20px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.ul-info li:hover{\r\n");
      out.write("\t\t\tbackground: rgb(245,245,245);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.option{\r\n");
      out.write("\t\t\tcursor: pointer;\r\n");
      out.write("\t\t\tdisplay: none;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.update:hover,.add:hover,.download:hover{\r\n");
      out.write("\t\t\tcolor: rgb(51,122,183);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.delete:hover{\r\n");
      out.write("\t\t\tcolor: rgb(169,68,66);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.subjects{\r\n");
      out.write("\t\t\tmargin-bottom: 15px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"hidden\" id=\"taskId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${task.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
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
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<!--任务信息-->\r\n");
      out.write("\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t<h3 class=\"page-header\">任务详情</h3>\r\n");
      out.write("\t\t\t<!--基本信息-->\r\n");
      out.write("\t\t\t<div class=\"panel panel-info\" id=\"taskInfo\">\r\n");
      out.write("\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"panel-title\">基本信息</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"panel-body text-muted\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"list-unstyled ul-info\">\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<span>任务名称：</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-pencil option update\"></span>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<span>任务类型：</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-pencil option update\"></span>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--题目列表-->\r\n");
      out.write("\t\t\t<div class=\"panel panel-info\" id=\"moduleList\" style=\"position: relative;\">\r\n");
      out.write("\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t<span>题目列表</span>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"addSubjectBtn\" class=\"glyphicon glyphicon-plus text-muted option add\" style=\"position: absolute;right: 15px;top: 14px;\"></span></button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"panel-body text-muted\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"list-unstyled ul-info\" id=\"subjectList\">\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--执行任务的班级-->\r\n");
      out.write("\t\t<div class=\"col-md-8\">\r\n");
      out.write("\t\t\t<h3 class=\"page-header\">执行此任务的班级列表</h3>\r\n");
      out.write("\t\t\t<table class=\"table table-hover table-striped\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<ul class=\"pagination pull-right\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</ul>\r\n");
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
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"oldPwd\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"newPwd\" class=\"control-label\">新密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"newPwd\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"confirm\" class=\"control-label\">确认密码：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" id=\"confirm\" class=\"form-control\">\r\n");
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
      out.write("<!--添加题目-->\r\n");
      out.write("<div class=\"modal fade\" id=\"addSubjectModal\">\r\n");
      out.write("\t<div class=\"modal-dialog \">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">请输入题目</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<textarea id=\"subjectName\" class=\"form-control\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary addBtn\">添加</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--修改任务信息模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"updateModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">修改任务名称</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">任务名称：</label>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"taskName\"/>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">任务类型：</label>\r\n");
      out.write("\t\t\t\t\t\t<select class=\"form-control\" id=\"taskType\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">Java 任务</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\">Oracle 任务</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"control-label\">题目名称：</label>\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"6\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"help-block\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\"/>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">修改</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--确认删除-->\r\n");
      out.write("<div class=\"modal fade\" id=\"dleModal\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<span class=\"close\" data-dismiss=\"modal\">&times</span>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">确定要删除吗？</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\">确认</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--操作提示模态框-->\r\n");
      out.write("<div class=\"modal fade\" id=\"alert\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<div class=\"alert text-center\">\r\n");
      out.write("\t\t\t<span id=\"msg\" style=\"font-size:18px;\"></span>\r\n");
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
      out.write("<script src=\"bootstrap/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/docs.min.js\"></script>\r\n");
      out.write("<script src=\"js/userInfo.js\"></script>\r\n");
      out.write("<script src=\"js/taskInfoBasics.js\"></script>\r\n");
      out.write("<script src=\"js/taskInfoData.js\"></script>\r\n");
      out.write("<script src=\"js/taskInfoPaging.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
}
