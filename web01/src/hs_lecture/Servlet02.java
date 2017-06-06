/* 지금까지 응용 - 강의관리 만들기 : 강의목록 출력하기
 * => 강의 목록을 html로 만들어 출력한다. 
 */
package hs_lecture;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/hs_lecture/Servlet02")
public class Servlet02 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
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
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 목록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      LectureDao lectureDao = new LectureDao(conPool);
      
      List<Lecture> list = lectureDao.selectList(pageNo, pageSize);
      
      out.println("<a href='form.html'>새강의</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>강의명</th><th>시작일</th><th>종료일</th><th>인원</th><th>수강료</th><th>총시간</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      
      for (Lecture m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", m.getNo());
        out.printf("<td><a href='Servlet04?no=%d'>%s</a></td>\n", m.getNo(), m.getTitle());
//        out.printf("<td>%s</td>\n", m.getDescription());
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
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    out.println("</body>");
    out.println("</html>");
  }
}
