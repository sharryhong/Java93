/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법 1. 서블릿 이용하기
 * => 다른 서블릿을 실행하기 전에, 자원을 준비시키는 서블릿을 먼저 실행한다.  
 */
package step08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step08/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    // 
    System.out.println("===> step08.Servlet01.init()...");
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "hello");
  }
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    // 클라이언트가 요청할 때마다 자원을 준비하는 것이 아니기 때문에 
    // service()메서드가 호출될 때 특별히 뭔가 작업할 필요가 없다. 
    System.out.println("===> step08.Servlet01.service()...");
  }
}
