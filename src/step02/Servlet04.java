/* service() 파라미터 : ServletResponse 1 - 출력하기
 */
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet04")
public class Servlet04 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 브라우저에 출력해보자. 
    PrintWriter out = res.getWriter();
    out.println("Hello, World");
    out.println("안녕하세요");
  }
}
