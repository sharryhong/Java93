/* 지금까지 응용 - 매니저관리 만들기 : 매니저등록하기
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

@WebServlet(urlPatterns="/hs_manager/add")
public class ManagerAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
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
    RequestDispatcher rd = req.getRequestDispatcher("/hs_croom/style/core");
    rd.include(req, res);
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
      out.println("<p>등록 성공입니다.</p>");
      res.sendRedirect("list");
      
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
