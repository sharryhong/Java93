/* 지금까지 응용 - 매니저관리 만들기 : 매니저등록하기
 */
package hs_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/hs_manager/Servlet03")
public class Servlet03 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    Manager mr = new Manager();
    mr.setName(req.getParameter("name"));
    mr.setTel(req.getParameter("tel"));
    mr.setEmail(req.getParameter("email"));
    mr.setPassword(req.getParameter("password"));
    
    mr.setPosi(req.getParameter("posi"));
    mr.setFax(req.getParameter("fax"));
    mr.setPath(req.getParameter("path"));
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>매니저관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 등록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      step03.DBConnectionPool conPool2 = new step03.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      step03.MemberDao memberDao = new step03.MemberDao(conPool2);
      memberDao.insert(mr);
      
      
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      ManagerDao managerDao = new ManagerDao(conPool);
      managerDao.insert(mr);
//      out.println("<p>등록 성공입니다.</p>");
      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    out.println("<a href='Servlet02'>목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
