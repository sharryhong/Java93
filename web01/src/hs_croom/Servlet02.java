/* 지금까지 응용 - 회원관리 만들기 : 회원목록 출력하기
 * => 회원 목록을 html로 만들어 출력한다. 
 */
package hs_croom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/hs_croom/Servlet02")
public class Servlet02 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
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
    out.println("<title>강의실 관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 목록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      ClassroomDao classroomDao = new ClassroomDao(conPool);
      
      List<Classroom> list = classroomDao.selectList(pageNo, pageSize);
      
      out.println("<a href='form.html'>새강의실</a><br>");
      
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>이름</th></tr>");
      out.println("</thead>");
      out.println("<tbody>");
      
      for (Classroom m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", m.getNo());
        out.printf("<td><a href='Servlet04?no=%d'>%s</a></td>\n", m.getNo(), m.getName());
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
