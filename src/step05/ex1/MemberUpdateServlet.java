/* 지금까지 응용 - 회원관리 만들기 : 회원변경하기
 */
package step05.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step05/update")
public class MemberUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    Member m = new Member();
    m.setNo(Integer.parseInt(req.getParameter("no")));
    m.setName(req.getParameter("name"));
    m.setTel(req.getParameter("tel"));
    m.setEmail(req.getParameter("email"));
    m.setPassword(req.getParameter("password"));
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/step05/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 변경</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      MemberDao memberDao = new MemberDao(conPool);
      
      int count = memberDao.update(m);
      if (count < 1) {
        throw new Exception(m.getNo() + "번 회원을 찾을 수 없습니다.");
      }
      out.println("<p>변경 성공입니다.</p>");
      
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      rd = req.getRequestDispatcher("/step05/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/step05/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
