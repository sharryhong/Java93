/* 웹 애플리케이션 컴포넌트 - 서블릿 만들기 1 - Servlet 인터페이스 구현
 * => 웹 애플리케이션을 구성하고 있는 구성요소 
 */
package servlets.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/servlets/step01/Servlet01")
public class Servlet01 implements Servlet{
  public Servlet01() {
    System.out.println("Servlet01.HelloServlet()");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet01.init()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet01.getServletConfig()");
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet01.service()");
    
  }

  @Override
  public String getServletInfo() {
    System.out.println("Servlet01.getServletInfo()");
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("Servlet01.destroy()");
    
  }
}
