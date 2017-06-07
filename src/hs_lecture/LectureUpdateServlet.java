/* 지금까지 응용 - 강의관리 만들기 : 강의변경하기
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

@WebServlet(urlPatterns="/hs_lecture/update")
public class LectureUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    Lecture m = new Lecture();
    m.setNo(Integer.parseInt(req.getParameter("no")));
    m.setTitle(req.getParameter("title"));
    m.setDescription(req.getParameter("description"));
    m.setStartDate(req.getParameter("startDate"));
    m.setEndDate(req.getParameter("endDate"));
    m.setQuantity(Integer.parseInt(req.getParameter("quantity")));
    m.setPrice(Integer.parseInt(req.getParameter("price")));
    m.setThrs(Integer.parseInt(req.getParameter("thrs")));
    m.setCrmno(Integer.parseInt(req.getParameter("classroom")));
    m.setMrno(Integer.parseInt(req.getParameter("manager")));
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 등록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      LectureDao lectureDao = new LectureDao(conPool);
      
      int count = lectureDao.update(m);
      if (count < 1) {
        throw new Exception(m.getNo() + "번 강의를 찾을 수 없습니다.");
      }
      out.println("<p>변경 성공입니다.</p>");
      
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
