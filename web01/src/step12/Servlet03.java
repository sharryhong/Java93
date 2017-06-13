package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 3
 * => 사용 기간 지정하기
 * 사용 기간을 지정하지 않으면, 웹 브라우저가 실행되는 동안만 보관된다. 
 * 중요! 웹 브라우저를 모두 닫으면 사용기간을 지정하지 않은 쿠키는 버려진다. 
 */
@WebServlet("/step12/Servlet03")
public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("c3", "ccc");
    
    cookie.setPath(req.getContextPath());
    
    // 쿠키의 사용기간 지정
    cookie.setMaxAge(60); // 초
    
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet03: 쿠키 보냈음");
  }
}
