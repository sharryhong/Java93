/* 서블릿 만들기
 * 1) 서블릿을 만드는 데 필요한 라이브러리를 가져온다. 
 */
package step24;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {
  
  public HelloServlet() {
    System.out.println("HelloServlet()"); // 객체 한번만 생성됨을 테스트하자. 
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("service()");
    
    res.setContentType("text/plain);charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Hello, world!");
  }

  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo()");
    return null;
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()");
    return null;
  }
  
  @Override
  public void destroy() {
    System.out.println("destroy()");
    
  }
  
}
