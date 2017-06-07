/* 지금까지 응용 - 회원관리 만들기 : 회원목록 출력하기
 * => java01/step22/ex3 파일들 가져온다. 
 */
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step03/Servlet01")
public class Servlet01 extends GenericServlet {
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
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      MemberDao memberDao = new MemberDao(conPool);
      
      List<Member> list = memberDao.selectList(pageNo, pageSize);
      for (Member m : list) {
        // system.out대신 out하면 바로 클라이언트에 출력된다!
        out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
      }
    } catch (Exception e) {
      out.println("오류 발생!");
      e.printStackTrace(out);
    }
  }
}
