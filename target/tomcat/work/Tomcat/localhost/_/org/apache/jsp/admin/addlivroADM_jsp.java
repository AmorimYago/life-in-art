/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2024-11-29 23:24:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addlivroADM_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html data-bs-theme=\"light\" lang=\"pt-br\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\">\r\n");
      out.write("    <title>biblioteca</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/fonts/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/fonts/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/fonts/fontawesome5-overrides.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        <nav class=\"navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark\" style=\"background: linear-gradient(rgb(2,72,115), #022840), rgb(2,72,115);\">\r\n");
      out.write("            <div class=\"container-fluid d-flex flex-column p-0\"><a class=\"navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0\" href=\"#\">\r\n");
      out.write("                    <div class=\"sidebar-brand-icon rotate-n-15\"><i class=\"fas fa-book\"></i></div>\r\n");
      out.write("                    <div class=\"sidebar-brand-text mx-3\"><span>Biblioteca</span></div>\r\n");
      out.write("                </a>\r\n");
      out.write("                <hr class=\"sidebar-divider my-0\">\r\n");
      out.write("                <ul class=\"navbar-nav text-light\" id=\"accordionSidebar\">\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"indexADM\"><i class=\"fa fa-book\"></i><span>Livros</span></a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link active\" href=\"addlivroADM.jsp\"><i class=\"far fa-edit\" style=\"margin-right: 4px;font-size: 12px;\"></i><span>Adicionar livro</span></a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"gerenciarusersADM\"><i class=\"fas fa-user\"></i><span>Gerenciar usuários</span></a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"gerenciaremprestimosADM\"><i class=\"far fa-calendar-alt\"></i><span>Gerenciar empréstimos</span></a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"confADM.jsp\"><i class=\"fas fa-user-circle\"></i><span>Configurações de ADM</span></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div class=\"d-flex flex-column\" id=\"content-wrapper\">\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <nav class=\"navbar navbar-expand bg-white shadow mb-4 topbar\">\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"button\" onclick=\"window.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout'\" style=\"width: 100.7656px;background: rgb(2,72,115);border-color: rgb(2,72,115);\">Sair</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <h3 class=\"text-dark mb-1\">Adicionar livro</h3>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <div class=\"card shadow mb-3\">\r\n");
      out.write("                            <div class=\"card-header py-3\">\r\n");
      out.write("                                <p class=\"text-primary m-0 fw-bold\">Dados do livro</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <form action=\"/create-livro\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"titulo\"><strong>Titulo</strong></label><input class=\"form-control\" type=\"text\" id=\"titulo\" placeholder=\"Titulo\" name=\"titulo\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"autor\"><strong>Autor</strong></label><input class=\"form-control\" type=\"text\" id=\"autor\" placeholder=\"Autor\" name=\"autor\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"editora\"><strong>Editora</strong></label><input class=\"form-control\" type=\"text\" id=\"editora\" placeholder=\"Editora\" name=\"editora\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"quantidade\"><strong>Quantidade</strong></label><input class=\"form-control\" type=\"text\" id=\"quantidade\" placeholder=\"Quantidade\" name=\"quantidade\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"anoPublicacao\"><strong>Ano de publicação</strong></label><input class=\"form-control\" type=\"text\" id=\"anoPublicacao\" placeholder=\"Ano de publicação\" name=\"anoPublicacao\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"isbn\"><strong>ISBN 10 ou 13</strong></label><input class=\"form-control\" type=\"text\" id=\"isbn\" placeholder=\"ISBN\" name=\"isbn\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"location\"><strong>Localização</strong></label><input class=\"form-control\" type=\"text\" id=\"location\" placeholder=\"Localização\" name=\"location\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"categoria\"><strong>Categoria</strong></label><input class=\"form-control\" type=\"text\" id=\"categoria\" placeholder=\"Categoria\" name=\"categoria\" required></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\" for=\"sinopse\"><strong>Sinopse</strong></label><textarea class=\"form-control\" id=\"sinopse\" style=\"height: 160px;\" name=\"sinopse\" required></textarea></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col\">\r\n");
      out.write("                                            <div class=\"mb-3\"><label class=\"form-label\"><strong>Imagem de capa</strong></label><input class=\"form-control\" type=\"file\" name=\"image\" id=\"image\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"mb-3\"><button class=\"btn btn-primary btn-sm\" type=\"submit\">Salvar</button></div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <footer class=\"bg-white sticky-footer\">\r\n");
      out.write("                <div class=\"container my-auto\">\r\n");
      out.write("                    <div class=\"text-center my-auto copyright\"><span>Biblioteca</span></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </footer>\r\n");
      out.write("        </div><a class=\"border rounded d-inline scroll-to-top\" href=\"#page-top\"><i class=\"fas fa-angle-up\"></i></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"../assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"../assets/js/theme.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
