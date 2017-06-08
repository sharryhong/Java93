/* 화면전환하기 : <meta> 이용
 * 방법 1) 응답 헤더에 추가
 *  예) Refresh: 1;url=Servlet02
 * 방법 2) html문서에 삽입하기
 *  예) <meta http-equiv="Refresh" content="1;url=Servlet02">
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step04/Servlet02")
public class Servlet02 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");

    if (req.getParameter("page") == null) {
      out.println("<meta http-equiv='Refresh' content='1;url=Servlet01/a'>");
    } else if (req.getParameter("page").equals("b")) {
      out.println("<meta http-equiv='Refresh' content='1;url=Servlet01/b'>");
    }
    
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프래시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면 1</h1>");

    out.println("</body>");
    out.println("</html>");
  }
}
