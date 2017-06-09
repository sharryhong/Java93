package bitcamp.java93.servlet;
/* 포워드 적용 : 오류 처리 부분
 * 인크루딩 적용 : 웹페이지의 꼬리말 출력 부분
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/member/list")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    
    // 페이지 번호, 페이지당 출력 개수
    int pageNo = 1;
    int pageSize = 5;
    
    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다.
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {} // 예외 발생 시 무시 (숫자가 아니거나, 정상적으로 넘어오지 않는다면)
    
    try {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원관리</title>");
    
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    
    out.println("</head>");
    out.println("<body>");
    
    Member loginMember = (Member)this.getServletContext().getAttribute("id_" + req.getParameter("sessionId"));
    out.printf("<p>%s(%s)</p>\n", loginMember.getName(), loginMember.getEmail()); // 로그인 정보 출력
    out.println("<h1>회원 목록</h1>");
    
    try {
      MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");
      List<Member> list = memberDao.selectList(pageNo, pageSize);
      
      out.println("<a href='form.html'>새회원</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>이름</th><th>전화</th><th>이메일</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      
      for (Member m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", m.getNo());
        out.printf("<td><a href='detail?no=%d'>%s</a></td>\n", m.getNo(), m.getName());
        out.printf("<td>%s</td>\n", m.getTel());
        out.printf("<td>%s</td>\n", m.getEmail());
        out.println("</tr>");
      }
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    // including기법을 사용하여 각 페이지마다 꼬리말을 붙인다. 
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
