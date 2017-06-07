/* 지금까지 응용 - 회원관리 만들기 : 회원 조회하기
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

@WebServlet(urlPatterns="/hs_croom/detail")
public class ClassroomDetailServlet extends GenericServlet {
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
    out.println("<h1>강의실 조회</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      ClassroomDao classroomDao = new ClassroomDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Classroom classroom = classroomDao.selectOne(no);
      if (classroom == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      } 
      
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", classroom.getNo());
      out.printf("이름: <input type='text' name='name' value='%s'><br>\n", classroom.getName());
      out.println("<button>변경</button>");
      out.println("<button type='button' onClick='doDelete()'>삭제</button>");
      out.println("<button type='button' onClick='doList()'>목록</button>");
      out.println("</form>");

      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='list'>목록</a>");
    }
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'delete?no=%s'\n", req.getParameterValues("no"));
    out.println("}");
    out.println("function doList() {");
    out.println("  location.href = 'list'");
    out.println("}");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
