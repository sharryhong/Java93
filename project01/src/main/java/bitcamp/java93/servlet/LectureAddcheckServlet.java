/* 지금까지 응용 - 강의관리 만들기 : 강의등록하기
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
import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.domain.Lecture;
import bitcamp.java93.utill.DBConnectionPool;

@WebServlet(urlPatterns="/hs_lecture/addcheck")
public class LectureAddcheckServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    Lecture m = new Lecture();
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
    out.println("<h1>강의 등록</h1>");
    
    try {
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      
      lectureDao.insert(m);
      res.sendRedirect("list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
  }
}
