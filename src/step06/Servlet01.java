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

@WebServlet(urlPatterns="/step06/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    // ServletRequest 보관소에 값 저장하기
    req.setAttribute("v1", "hello");
    
    RequestDispatcher rd = req.getRequestDispatcher("/step06/Servlet02");
    rd.forward(req, res); 
  }
}
