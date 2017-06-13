package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 읽기 1
 * => 웹브라우저가 보낸 쿠키 정보 읽기
 */
@WebServlet("/step12/CookieReader01")
public class CookieReader01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    // 1) 요청 헤더에서 쿠키정보를 추출하기
    // 웹 브라우저가 쿠키를 보내지 않았다면 null을 리턴한다. 
    Cookie[] cookies = req.getCookies();
    
    // 2) 읽은 쿠키 정보 출력하기 
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s=%s\n", 
            cookie.getName(),    // 쿠키 이름
            cookie.getValue());   // 쿠키 값
      } 
    } else {
      out.println("쿠키가 한 개도 없습니다.");
    }
  }
}
