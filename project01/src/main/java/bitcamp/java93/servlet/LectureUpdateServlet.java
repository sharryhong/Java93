/* 지금까지 응용 - 강의관리 만들기 : 강의변경하기
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

import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.domain.Lecture;

@WebServlet(urlPatterns="/hs_lecture/update")
public class LectureUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
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
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 변경</h1>");
    
    try {
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      int count = lectureDao.update(m);
      if (count < 1) {
        throw new Exception(m.getNo() + "번 강의를 찾을 수 없습니다.");
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
