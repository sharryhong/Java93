/* 저장소  ServletContext 보관소
 * => 여기에 값을 저장하면, 웹 애플리케이션이 실행되는 동안 사용할 수 있다. 
 */
package step07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step07/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    // ServletRequest 보관소에 값 저장하기
    req.setAttribute("v1", "hello");
    
    // ServletContext 보관소에 값 저장하기. 
    // ServletContext는 단 하나만 생성된다. 방법1, 2 모두 같은 ServletContext 객체를 리턴한다. 
    ServletContext sc = req.getServletContext();  // 방법1. ServletRequest를 통해 얻을 수 있다. 
//    ServletContext sc = this.getServletContext();  // 방법2.HttpServlet 클래스로부터 상속받은 메서드를 
    sc.setAttribute("v2", "hi");
    
  }
}
