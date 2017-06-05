/* 지금까지 응용 - 매니저관리 만들기 : 매니저 조회하기
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

@WebServlet(urlPatterns="/hs_manager/Servlet04")
public class Servlet04 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {     
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>매니저관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 조회</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      ManagerDao memberDao = new ManagerDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Manager member = memberDao.selectOne(no);
      if (member == null) {
        throw new Exception(no + "번 매니저이 없습니다.");
      } 
      
      out.println("<form action='Servlet05' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", member.getNo());
      out.printf("이름: <input type='text' name='name' value='%s'><br>\n", member.getName());
      out.printf("전화: <input type='text' name='tel' value='%s'><br>\n", member.getTel());
      out.printf("이메일: <input type='text' name='email' value='%s'><br>\n", member.getEmail());
      out.println("암호: <input type='password' name='password'><br>");
      out.println("<button>변경</button>");
      out.println("<button type='button' onClick='doDelete()'>삭제</button>");
      out.println("<button type='button' onClick='doList()'>목록</button>");
      out.println("</form>");

      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='Servlet02'>목록</a>");
    }
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'Servlet06?no=%s'\n", req.getParameterValues("no"));
    out.println("}");
    out.println("function doList() {");
    out.println("  location.href = 'Servlet02'");
    out.println("}");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
