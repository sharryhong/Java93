/* 로그인 서블릿 : HttpSession 객체 이용하기
 * => 특정 클라이언트 전용 HttpSession 보관소 준비하기
 *    - HttpServletRequest.getSession()
 * => getSession() 실행 과정
 *    1 만약 클라이언트가 쿠키로 세션아이디를 보냈다면,
 *      1.1) 마침 서블릿컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고
 *           그 HttpSession 객체가 유효하다면, 
 *           => 그 HttpSession 객체를 리턴한다.
 *      1.2) 마침 서블릿컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고
 *           그 HttpSession 객체가 무효하다면,
 *           => 새 HttpSession 객체를 만들어 리턴한다.
 *      2.3) 무효한 세션아이디라면,
 *           => 새 HttpSession 객체를 만들어 리턴한다.
 *    2. 만약 클라이언트가 쿠키로 세션아이디를 보내지 않았다면,
 *       => 새 HttpSession 객체를 만들어 리턴한다.
 */
package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/auth/login")
public class LoginServlet extends HttpServlet  {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // GET요청이 들어오면 로그인폼 출력
    // 1) "email" 쿠키가 있으면 꺼낸다. 
    Cookie[] cookies = req.getCookies();
    String email = "";
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("email")) {
          email = cookie.getValue();
          break;
        }
      }
    }
    
    // 2) 로그인 폼을 출력한다. 그리고 쿠키에 이메일이 있으면 기본 값으로 설정한다.     
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, resp);
    out.println("</head>");
    out.println("<body>");
    rd = req.getRequestDispatcher("/header");
    rd.include(req, resp);
    out.println("<h1>회원 로그인</h1>");
    out.println("<form action='login' method='POST'>");
    out.printf("<p>이메일: <input type='text' name='email' value='%s'></p>\n", email);
    out.println("<p>암호: <input type='password' name='password'></p>");
    out.println("<input type='checkbox' name='saveEmail'> 이메일 저장");
    out.println("<p><button>로그인</button></p>");
    out.println("</form>");
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, resp);
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    
    try {
      
      MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao"); 
      Member member = memberDao.selectOneByEmailPassword(email, password);
      if (member != null) { //로그인에 성공!      
        // 클라이언트를 위해 HttpSesstion 보관소(객체) 준비하기 
        HttpSession session = req.getSession();
        // HttpSession 보관소에 로그인 회원 정보 저장
        session.setAttribute("loginMember", member);
        
        // 이메일 저장, 제거
        String saveEmail = req.getParameter("saveEmail");
        if (saveEmail != null) { // 이메일 저장을 체크했다면 
          Cookie cookie2 = new Cookie("email", email);
          cookie2.setMaxAge(60 * 60 * 24 * 7); // 일주일 유지
          res.addCookie(cookie2);
        } else {
          Cookie cookie2 = new Cookie("email", ""); // 지우기
          cookie2.setMaxAge(0); // 0이면 즉시 무효화(제거). 따로 제거하라는 명령어 없이 유효기간을 0을 준다.  
          res.addCookie(cookie2);
        }
        
        res.sendRedirect("../member/list");
        
      } else {
        res.setContentType("text/html;charset=UTF-8");  //html을 하면 웹 브라우저에서 html로 인식해서 엔터가 안먹힘
        PrintWriter out = res.getWriter(); //위에서 "text/html;charset=UTF-8"해줬기 때문에 사실상은 필요없음
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");
        
        //including을 사용하여 각 페이지에 기본 CSS 스타일 코들를 출력한다.
        RequestDispatcher rd = req.getRequestDispatcher("/style/core");
        rd.include(req, res);
        
        out.println("</head>");
        out.println("<body>");
        res.setHeader("Refresh", "2;url=login");
        out.println("<h1>로그인 오류</h1>");    
        out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
        rd = req.getRequestDispatcher("/footer");
        rd.include(req, res);
        
        out.println("</body>");
        out.println("</html>");
      }
            
    } catch(Exception e) {
      req.setAttribute("error", e); //포워딩 하기 전에 서블릿리퀘스트 보관소에 오류 정보를 보관한다.
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }   
  }  
}