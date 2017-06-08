/* 저장소  ServletRequest 사용하기
 */
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step06/Servlet02")
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    // ServletRequest 보관소에 저장된 값 꺼내기
    String value = (String)req.getAttribute("v1");
    
    res.setContentType("text/plain);charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println(value);
  }
}
