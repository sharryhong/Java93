/* 지금까지 응용 - 강의실관리 만들기 : 강의실 삭제하기
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

@WebServlet(urlPatterns="/hs_croom/delete")
public class ClassroomDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {     
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의실관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 삭제</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ClassroomDao classroomDao = new ClassroomDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      int count = classroomDao.delete(no);
      if (count < 1) {
        throw new Exception(no + "번 강의실을 찾을 수 없습니다.");
      }
      out.println("<p>삭제 성공입니다.</p>");
      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    out.println("<a href='list'>목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
