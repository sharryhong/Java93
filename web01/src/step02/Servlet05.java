/* service() 파라미터 : ServletResponse 2 - 한글 출력이 깨지는 현상
 */
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet05")
public class Servlet05 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Hello, World");
    out.println("안녕하세요");
  }
}
