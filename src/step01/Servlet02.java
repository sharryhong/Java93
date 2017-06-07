/* 웹 애플리케이션 컴포넌트 - 서블릿 만들기 1 - GenericServlet 추상 클래스 상속 받기
 * => 웹 애플리케이션을 구성하고 있는 구성요소 
 */
package step01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step01/Servlet02")
public class Servlet02 extends GenericServlet {
  // 안써도 문제는 없다. 인수인계 때 필요하다. 
  private static final long serialVersionUID = 1L;

  public Servlet02() {
    System.out.println("Servlet02.HelloServlet()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet02.service()");
    
  }
}
