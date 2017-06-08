/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법 1. 서블릿 이용하기
 * => 클라이언트가 요청하지 않아도 웹 애플리케이션이 시작될 때 
 *    서블릿 객체를 자동생성하는 방법 두가지 
 *    1) web.xml DD file에 설정 
 *    2) 애노테이션 @WebServlet 에 설정
 */
package step08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step08/Servlet02", loadOnStartup=1)
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    // 
    System.out.println("===> step08.Servlet02.init()...");
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v2", "hi");
  }

}
