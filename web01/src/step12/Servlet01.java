package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기
 * 쿠키(Cookie?)
 * - 웹서버가 웹브라우저에게 보내는 데이터
 * - 웹브라우저는 웹서버로부터 받은 쿠키 데이터를 내부메모리 또는 별도의 폴더에 저장한다. 
 * - 그리고 그 웹서버를 방문할 때마다 쿠키를 요청헤더에 담아 다시 전달한다. 
 */
@WebServlet("/step12/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1) 쿠키 생성 : Cookie 클래스 객체 생성
    // => 쿠키의 이름은 'ISO-8859-1'이어야 한다. 즉, 한글 안된다. 
    // => 쿠키의 값은 'ISO-8859-1' 문자열이어야 한다. 즉, 한글을 저장하고 싶다면, URL인코딩하여 저장하라. 
    Cookie cookie = new Cookie("c1", "aaaaaa"); // "이름", "값"
    
    // 2) 쿠키를 응답 헤더에 포함시켜 보내기
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet01: 쿠키 보냈음");
  }
}
