package step12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 읽기 3
 * => 쿠키 값이 url 인코딩되어 있을 때 개발자가 직접 url 디코딩을 수행해야 한다. 
 */
@WebServlet("/step12/CookieReader03")
public class CookieReader03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    Cookie[] cookies = req.getCookies();
    
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s=%s\n", 
            cookie.getName(),    // 쿠키 이름
            URLDecoder.decode(cookie.getValue(), "UTF-8"));   // 쿠키 값
      } 
    } else {
      out.println("쿠키가 한 개도 없습니다.");
    }
  }
}
