/* 화면전환하기 : HTTP 응답의 status 코드를 사용하여 화면 전환하기 
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

@WebServlet(urlPatterns="/step04/Servlet03")
public class Servlet03 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리다이렉트</title>");
    out.println("</head>");
    out.println("<body>");
      out.println("<h1>이 내용은 클라이언트로 보내지 않습니다.</h1>");
    
    for (int i = 0; i < 1000; i++) {
      out.println("1234567890");
    }
    out.println("</body>");
    out.println("</html>");
    
    // redirect기능은 http프로토콜과 관련된 기능이다. 따라서 원래타입인 HttpServletResponse로 타입캐스팅해서 쓰자.
    HttpServletResponse httpRes = (HttpServletResponse) res;
    if (req.getParameter("page") == null) {
      // sendRedirect()를 호출하면 이전에 출력된 내용은 취소된다. 
      httpRes.sendRedirect("Servlet01/a");
    } else if (req.getParameter("page").equals("b")) {
      httpRes.sendRedirect("Servlet01/b");
    }
  }
}
