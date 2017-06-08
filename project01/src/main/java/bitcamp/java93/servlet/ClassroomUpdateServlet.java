/* 지금까지 응용 - 강의실관리 만들기 : 강의실변경하기
 */
package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.ClassroomDao;
import bitcamp.java93.domain.Classroom;
import bitcamp.java93.utill.DBConnectionPool;

@WebServlet(urlPatterns="/hs_croom/update")
public class ClassroomUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    Classroom m = new Classroom();
    m.setNo(Integer.parseInt(req.getParameter("no")));
    m.setName(req.getParameter("name"));
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의실관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 등록</h1>");
    
    try {
      ClassroomDao classroomDao = (ClassroomDao)this.getServletContext().getAttribute("classroomDao");
      int count = classroomDao.update(m);
      if (count < 1) {
        throw new Exception(m.getNo() + "번 강의실을 찾을 수 없습니다.");
      }
      out.println("<p>변경 성공입니다.</p>");
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
    // including 기법을 사용하여 각 페이지마다 꼬리말을 붙인다.
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
