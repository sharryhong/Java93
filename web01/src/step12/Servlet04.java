package step12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 4
 * => 한글 보내기 
 * 
 */
@WebServlet("/step12/Servlet04")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 웹서버 중에서 쿠키 값을 유니코드로 그대로 내보내는 서버는 다음과 같이 평소방법으로 설정하면 된다. 
//    Cookie cookie = new Cookie("c4", "ABC가각간");
    
    // 만약 웹서버가 한글을 포함한 문자열을 내보내는 서버가 아니라면 다음과 같이 개발자가 url인코딩을 수행해야 한다.  
    Cookie cookie = new Cookie("c4", URLEncoder.encode("ABC가각간", "UTF-8")); // URLEncoder : ASCII 코드화 한다.
    
    cookie.setPath(req.getContextPath());
    
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet04: 쿠키 보냈음");
  }
}
