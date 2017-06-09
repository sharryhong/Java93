/* HttpServlet 추상 클래스를 상속받아 서블릿 만들기 2
 * => HttpServlet 추상 클래스에 추가한 service()메서드 오버라이딩하기 
 */
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/Servlet02")
public class Servlet02 extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("안녕하세요!");
    out.println(req.getMethod());
  }
}
