/* 로그아웃 서블릿 : HttpServlet 로그아웃 처리하기*/
package bitcamp.java93.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("/auth/logout")
public class LogoutControl implements Controller {
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    req.getSession().invalidate(); 
    return "redirect:../auth/login.do";
  }
}