/* 화면전환하기 : Refresh 헤더 이용
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

@WebServlet(urlPatterns="/step04/Servlet01/b")
public class Servlet01_B extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프래시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면 B</h1>");

    out.println("</body>");
    out.println("</html>");
  }
}
