/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.85
 * Generated at: 2024-03-04 07:23:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/template/footer.jsp", Long.valueOf(1709532159187L));
    _jspx_dependants.put("jar:file:/D:/WebStudy/Spring_3.9.15/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springclass-bbs/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1708420406252L));
    _jspx_dependants.put("/WEB-INF/template/header.jsp", Long.valueOf(1709532159230L));
  }

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
      out.write("	<meta charset=\"utf-8\">\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("	<title>Spring MVC 게시판</title>\r\n");
      out.write("	<!--\r\n");
      out.write("		BoardController에서 클래스 레벨에 @RequestMapping 애노테이션을 사용해\r\n");
      out.write("		별도로 경로 매핑을 하지 않고 boardList(Model model) 메서드에만\r\n");
      out.write("		@RequestMapping({\"/boardList\", \"/list\"}) 애노테이션으로 요청 매핑을 설정했다.\r\n");
      out.write("		그리고 WEB-INF/spring/appServlet/servlet-context.xml에서 정적 리소스와\r\n");
      out.write("		관련된 url 맵핑을 아래와 같이 설정했기 때문에\r\n");
      out.write("		<mvc:resources mapping=\"/resources/**\" location=\"/resources/\" />		\r\n");
      out.write("		css의 위치를 \"resources/css/index.css\"와 같이 지정해야 한다.\r\n");
      out.write("	 \r\n");
      out.write("		브라우저 주소 표시줄에 http://localhost:8080/springclass-bbs/list\r\n");
      out.write("		또는 http://localhost:8080/springclass-bbs/boardList 등으로\r\n");
      out.write("		표시되므로 css 디렉터리는 ContextRoot/resources/css에 위치하기 때문에 현재\r\n");
      out.write("		위치를 기준으로 상대 참조 방식으로 \"resources/css/index.css\"를 지정해야 한다.\r\n");
      out.write("	-->	\r\n");
      out.write("	<title>스프링 게시판</title>\r\n");
      out.write("	<link href=\"resources/bootstrap/bootstrap.min.css\" rel=\"stylesheet\" >\r\n");
      out.write("    <style>      	\r\n");
      out.write("    </style>\r\n");
      out.write("	<script src=\"resources/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("	<script src=\"resources/js/formcheck.js\"></script>    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- header  -->\r\n");
      out.write("<div class=\"row border-bottom border-primary\" id=\"global-header\">\r\n");
      out.write("	<div class=\"col-4\">\r\n");
      out.write("		<p><img src=\"https://via.placeholder.com/200x100\"></p>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"col-8\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col\">\r\n");
      out.write("				<ul class=\"nav justify-content-end\">\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<a class=\"nav-link\" href=\"#\">로그인</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<a class=\"nav-link\" href=\"boardList\">게시 글 리스트</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<a class=\"nav-link\" href=\"#\">회원가입</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<a class=\"nav-link\" href=\"#\">주문/배송조회</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"nav-item\">\r\n");
      out.write("						<a class=\"nav-link\" href=\"#\">고객센터</a>\r\n");
      out.write("					</li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col text-end\">로그인시 인사말 출력</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.body }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), out, false);
      out.write("\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("<!-- footer -->\r\n");
      out.write("<div class=\"row border-top border-primary my-5\" id=\"global-footer\">\r\n");
      out.write("	<div class=\"col text-center py-3\">\r\n");
      out.write("		<p>고객상담 전화주문:1234-5678 사업자등록번호 :111-11-123456  \r\n");
      out.write("  	대표이사: 홍길동  통신판매업 서울 제 000000호<br/>\r\n");
      out.write("  	개인정보관리책임자:임꺽정 분쟁조정기관표시 : 소비자보호원, 전자거래분쟁중재위원회<br/>      	\r\n");
      out.write("  	Copyright (c) 2016 Spring2U Corp. All right Reserved.	\r\n");
      out.write("		</p>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("    <script src=\"resources/bootstrap/bootstrap.bundle.min.js\"></script>	\r\n");
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