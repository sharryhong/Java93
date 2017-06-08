/* 지금까지 응용 - 강의관리 만들기 : 강의목록 출력하기
 * => 강의 목록을 html로 만들어 출력한다. 
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

import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.domain.Lecture;

@WebServlet(urlPatterns="/hs_lecture/list")
public class LectureListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    int pageNo = 1;
    int pageSize = 5;
    
    try { 
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {} 
    
    try {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 목록</h1>");
    
    try {
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      List<Lecture> list = lectureDao.selectList(pageNo, pageSize);
      
      out.println("<a href='add'>새강의</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>강의명</th><th>시작일</th><th>종료일</th><th>인원</th><th>수강료</th><th>총시간</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      
      for (Lecture m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", m.getNo());
        out.printf("<td><a href='detail?no=%d'>%s</a></td>\n", m.getNo(), m.getTitle());
        out.printf("<td>%s</td>\n", m.getStartDate());
        out.printf("<td>%s</td>\n", m.getEndDate());
        out.printf("<td>%s</td>\n", m.getQuantity());
        out.printf("<td>%s</td>\n", m.getPrice());
        out.printf("<td>%s</td>\n", m.getThrs());
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
