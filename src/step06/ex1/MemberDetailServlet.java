/* 지금까지 응용 - 회원관리 만들기 : 회원 조회하기
 */
package step06.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step06/detail")
public class MemberDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     
    
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
    out.println("<h1>회원 조회</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      MemberDao memberDao = new MemberDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Member member = memberDao.selectOne(no);
      if (member == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      } 
      
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", member.getNo());
      out.printf("이름: <input type='text' name='name' value='%s'><br>\n", member.getName());
      out.printf("전화: <input type='text' name='tel' value='%s'><br>\n", member.getTel());
      out.printf("이메일: <input type='text' name='email' value='%s'><br>\n", member.getEmail());
      out.println("암호: <input type='password' name='password'><br>");
      out.println("<button>변경</button>");
      out.println("<button type='button' onClick='doDelete()'>삭제</button>");
      out.println("<button type='button' onClick='doList()'>목록</button>");
      out.println("</form>");

      out.println("<script>");
      out.println("function doDelete() {");
      out.printf("  location.href = 'delete?no=%s'\n", req.getParameterValues("no"));
      out.println("}");
      out.println("function doList() {");
      out.println("  location.href = 'list'");
      out.println("}");
      out.println("</script>");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/step06/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/step06/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
