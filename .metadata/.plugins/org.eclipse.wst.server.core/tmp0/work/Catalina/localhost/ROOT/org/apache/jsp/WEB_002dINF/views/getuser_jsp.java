/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-11-17 04:15:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function getUsers(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: \"users\", type: \"get\", dataType: \"json\",\r\n");
      out.write("			success : function(list){\r\n");
      out.write("				//$(\"#users\").text(list)\r\n");
      out.write("				/*\r\n");
      out.write("				console.log(list)\r\n");
      out.write("				let html = \"<b>아이디 : </b>\" + list[0].name+\"님<br>\"\r\n");
      out.write("				html += \"<b>나이 : </b>\" + list[0].age + \"살<hr>\"\r\n");
      out.write("				\r\n");
      out.write("				html += \"<b>아이디 : </b>\" + list[1].name+\"님<br>\"\r\n");
      out.write("				html += \"<b>나이 : </b>\" + list[1].age + \"살<hr>\"\r\n");
      out.write("				*/\r\n");
      out.write("				let html= \"\"\r\n");
      out.write("				/*\r\n");
      out.write("				for(var i = 0; i<list.length; i++){\r\n");
      out.write("					html += \"<b>아이디 : </b>\" + list[i].name+\"님<br>\"\r\n");
      out.write("					html += \"<b>나이 : </b>\" + list[i].age + \"살<hr>\"\r\n");
      out.write("				}\r\n");
      out.write("				*/\r\n");
      out.write("				$.each(list, function(index, item){\r\n");
      out.write("					html += \"<b>아이디 : </b>\" + item.name+\"님<br>\"\r\n");
      out.write("					html += \"<b>나이 : </b>\" + item.age + \"살<hr>\"\r\n");
      out.write("				})\r\n");
      out.write("				//$(\"#users\").html(html)	//내용을 html로 전부 바꿔줌\r\n");
      out.write("				$(\"#users\").append(html)	//밑에 이어붙여줌\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("	function userInfo(){\r\n");
      out.write("		var userId = $(\"#userId\").val()\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			//url : \"user?id=\" + userId, //경로 : user?id=홍길동1\r\n");
      out.write("			url : \"user/\" + userId,	//경로 : user/홍길동1\r\n");
      out.write("			type : \"get\", \r\n");
      out.write("			dataType: \"json\",\r\n");
      out.write("			success : function(dto){\r\n");
      out.write("				console.log(dto)\r\n");
      out.write("				let html = \"<b>이름 : </b>\" + dto.name+\"님<br>\"\r\n");
      out.write("				html += \"<b>나이 : </b>\" + dto.age + \"살<hr>\"\r\n");
      out.write("				$(\"#users\").html(html)\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("	function modify(){\r\n");
      out.write("		let name = $(\"#name\").val();\r\n");
      out.write("		let age = $(\"#age\").val();\r\n");
      out.write("		let form = { name: name, age:age }\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"modify\",\r\n");
      out.write("			type : \"put\",\r\n");
      out.write("			dataType: \"json\",\r\n");
      out.write("			data : JSON.stringify(form),\r\n");
      out.write("			contentType: \"application/json; charset=utf-8\",\r\n");
      out.write("			success : function(dto){\r\n");
      out.write("				let html = \"<b>이름 : </b>\" + dto.name+\"님<br>\"\r\n");
      out.write("				html += \"<b>나이 : </b>\" + dto.age + \"살<hr>\"\r\n");
      out.write("				$(\"#users\").html(html)\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("	function membership(){\r\n");
      out.write("		/*\r\n");
      out.write("		let uId1 = $(\"#uId\").val();\r\n");
      out.write("		let uName1 = $(\"#uName\").val();\r\n");
      out.write("		let uAge1 = $(\"#uAge\").val();\r\n");
      out.write("		let uAddr1 = $(\"#uAddr\").val();\r\n");
      out.write("		let uPhone1 = $(\"#uPhone\").val();\r\n");
      out.write("		\r\n");
      out.write("		let form = {uId:uId1, uName:uName1, uAge:uAge1, uAddr:uAddr1, uPhone:uPhone1}\r\n");
      out.write("		*/\r\n");
      out.write("		let form = {}\r\n");
      out.write("		let arr = $(\"#fo\").serializeArray()\r\n");
      out.write("		//form 태그로 묶었을때 사용가능. id가 아니라 name값을 본다. \r\n");
      out.write("		console.log(arr)\r\n");
      out.write("		//콘솔창에서 보면 Array에 0: {name: 'uId', value: '아이디'} 이런식으로 저장됨\r\n");
      out.write("		\r\n");
      out.write("		for(var i=0; i<arr.length; i++){\r\n");
      out.write("			form[arr[i].name] = arr[i].value\r\n");
      out.write("		}\r\n");
      out.write("		console.log(\"form : \" + form)\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"membership\", type:\"post\", dataType:\"json\",\r\n");
      out.write("			data : JSON.stringify(form),\r\n");
      out.write("			contentType: \"application/json; charset=utf-8\",\r\n");
      out.write("			success: function(test){\r\n");
      out.write("				alert('저장 성공')\r\n");
      out.write("			},error:function(){\r\n");
      out.write("				alert('문제 발생')\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>getuser.jsp<br>\r\n");
      out.write("	<span id=\"users\"></span>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<button type=\"button\" onclick=\"getUsers()\">사용자 목록 보기</button>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<input type=\"text\" id=\"userId\">\r\n");
      out.write("	<button type=\"button\" onclick=\"userInfo()\">개인 정보 보기</button>\r\n");
      out.write("	\r\n");
      out.write("	<hr>\r\n");
      out.write("	<input type=\"text\" id=\"name\" placeholder=\"수정할 이름 입력(존재하는 이름 입력)\"><br>\r\n");
      out.write("	<input type=\"text\" id=\"age\" placeholder=\"수정할 나이 입력\"><br>\r\n");
      out.write("	<button type=\"button\" onclick=\"modify()\">수정</button>\r\n");
      out.write("	\r\n");
      out.write("	<hr>\r\n");
      out.write("	<h3>회원가입</h3>\r\n");
      out.write("	<form id=\"fo\">\r\n");
      out.write("		<input type=\"text\" id=\"uId\" name=\"uId\" placeholder=\"id\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"uName\" name=\"uName\" placeholder=\"uName\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"uAge\" name=\"uAge\" placeholder=\"uAge\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"uAddr\" name=\"uAddr\" placeholder=\"uAddr\"><br>\r\n");
      out.write("		<input type=\"text\" id=\"uPhone\" name=\"uPhone\" placeholder=\"uPhone\"><br>\r\n");
      out.write("		<input type=\"button\" onclick=\"membership()\" value=\"회원가입\"><br>\r\n");
      out.write("	</form>\r\n");
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
}
