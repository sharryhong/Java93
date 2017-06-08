/* 지금까지 응용 - 매니저관리 만들기 : 매니저 삭제하기
 */
package hs_manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hs_manager/delete")
public class ManagerDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>매니저관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/hs_croom/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 삭제</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ManagerDao memberDao = new ManagerDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("mrno"));
      int count = memberDao.delete(no);
      if (count < 1) {
        throw new Exception(no + "번 매니저을 찾을 수 없습니다.");
      }
      out.println("<p>삭제 성공입니다.</p>");
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/hs_croom/error");
      rd.forward(req, res);
      return;
    }
    
    // including 기법을 사용하여 각 페이지마다 꼬리말을 붙인다.
    rd = req.getRequestDispatcher("/hs_croom/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
