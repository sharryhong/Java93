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
 * 
 * 
 */
package bitcamp.java93.control;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.TeacherService;

@Component("/auth/login")
public class LoginControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    // get요청
    if (req.getMethod().equals("GET")) {
      return "/auth/form.jsp";
    }
    // post요청
    String userType = req.getParameter("userType");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    
    Member member = null;
    if (userType.equals("teacher")) {
      member = teacherService.getByEmailPassword(email, password);
    }
    if (member != null) { // 로그인 성공!
      HttpSession session = req.getSession(); // 클라이언트를 위한 HttpSession 객체 준비.
      session.setAttribute("loginMember", member);
      String saveEmail = req.getParameter("saveEmail");
      if (saveEmail != null) { // 이메일 저장을 체크했다면,
        Cookie cookie2 = new Cookie("email", email);
        cookie2.setMaxAge(60 * 60 * 24 * 7); // 7일간 유지!
        resp.addCookie(cookie2);
      } else {
        Cookie cookie2 = new Cookie("email", "");
        cookie2.setMaxAge(0); // 유효기간이 0이면 즉시 무효화된다. 즉 제거하라는 의미이다.
        resp.addCookie(cookie2);
      }
      return "redirect:../teacher/list.do";
    } else {
      return "/auth/fail.jsp";
    }
  }
}









