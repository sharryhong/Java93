/* 화면전환하기 : Refresh 헤더 이용
 * 방법 1) 응답 헤더에 추가
 *  예) Refresh: 1;url=Servlet02
 * 방법 2) html문서에 삽입하기
 *  예) <meta http-equiv="Refresh" content="1;url=Servlet02">
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step04/Servlet01")
public class Servlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    // 응답할 때 HTTP 프로토콜에 따라 Refresh 헤더를 붙이고 싶다. 
    // 그런데, ServletResponse 도구에는 HTTP응답헤더를 추가시키는 기능이없다. 
    // => 서블릿 컨테이너가 웹서버와 연동한다면(현재 거의 대부분) 
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;

    if (req.getParameter("page") == null) {
      // httpRes에 있는 메서드 이용
      httpRes.setHeader("Refresh", "1;url=Servlet01/a"); // 1초후에 현재 위치에 (웹브라우저가) url요청
    } else if (req.getParameter("page").equals("b")) {
      httpRes.setHeader("Refresh", "1;url=Servlet01/b"); 
    } 
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프래시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면 1</h1>");

    out.println("</body>");
    out.println("</html>");
  }
}
