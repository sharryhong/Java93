/* 웹 애플리케이션 컴포넌트 - 서블릿 만들기 3 - HTTPServlet 추상 클래스 상속 받기
 * 
 */
package servlets.step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/servlets/step01/Servlet03")
public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // GET요청이 들어오면 
    System.out.println("Servlet03.doGet()");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // POST요청이 들어오면 
    System.out.println("Servlet03.doPost()");
  }
}
