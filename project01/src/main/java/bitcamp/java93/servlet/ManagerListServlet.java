/* 지금까지 응용 - 매니저관리 만들기 : 매니저목록 출력하기
 * => 매니저 목록을 html로 만들어 출력한다. 
 */
package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.domain.Manager;

@WebServlet(urlPatterns="/hs_manager/list")
public class ManagerListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
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
    out.println("<meta charset='UTF-8'>");
    out.println("<title>매니저관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 목록</h1>");
    
    try {
      ManagerDao managerDao = (ManagerDao)this.getServletContext().getAttribute("managerDao");
      List<Manager> list = managerDao.selectList(pageNo, pageSize);
      
      out.println("<a href='form.html'>새매니저</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>이름</th><th>전화</th><th>이메일</th><th>직급</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      
      for (Manager m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", m.getNo());
        out.printf("<td><a href='detail?no=%d'>%s</a></td>\n", m.getNo(), m.getName());
        out.printf("<td>%s</td>\n", m.getTel());
        out.printf("<td>%s</td>\n", m.getEmail());
        out.printf("<td>%s</td>\n", m.getPosi());
        out.println("</tr>");
      }
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
    // including 기법을 사용하여 각 페이지마다 꼬리말을 붙인다.
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
