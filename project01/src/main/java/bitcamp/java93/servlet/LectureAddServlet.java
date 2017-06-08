/* 지금까지 응용 - 강의관리 만들기 : 강의등록하기
 */
package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.ClassroomDao;
import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.domain.Classroom;
import bitcamp.java93.domain.Manager;

@WebServlet(urlPatterns="/hs_lecture/add")
public class LectureAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
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
      ClassroomDao classroomDao = (ClassroomDao)this.getServletContext().getAttribute("classroomDao");
      ManagerDao managerDao = (ManagerDao)this.getServletContext().getAttribute("managerDao");

//      hs_croom.DBConnectionPool conPool2 = new hs_croom.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
//      hs_croom.ClassroomDao classroomDao = new hs_croom.ClassroomDao(conPool2);
      List<Classroom> crooms = classroomDao.selectNameList();
      
//      hs_manager.DBConnectionPool conPool3 = new hs_manager.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
//      hs_manager.ManagerDao managerDao = new hs_manager.ManagerDao(conPool3);
      List<Manager> mgrs = managerDao.selectNameList();
      
      out.println("<form action='addcheck' method='post'>");
      out.printf("강의명: <input type='text' name='title'><br>\n");
      out.printf("강의설명: <input type='text' name='description'><br>\n");
      out.printf("시작일: <input type='date' name='startDate'><br>\n");
      out.printf("종료일: <input type='date' name='endDate'><br>\n");
      out.printf("수강인원: <input type='text' name='quantity'><br>\n");
      out.printf("수강료: <input type='text' name='price'><br>\n");
      out.printf("총시간: <input type='text' name='thrs'><br>\n");
      out.println("강의실: <select id='fi-classroom' name='classroom'>");

      out.println("<option value='0'>강의실을 선택하세요!</option>");
      for (Classroom croom : crooms) {
        out.printf("<option value='%d'>%s</option>", croom.getNo(), croom.getName());
      }
//      out.printf("<option value='%d'>%s</option>", lecture.getCrmno(), crooms.get(lecture.getCrmno()).getName());
      out.println("</select><br>");
      
      out.println("매니저: <select id='fi-manager' name='manager'>");
      out.println("<option value='0'>매니저를 선택하세요!</option>");
      for (Manager mgr : mgrs) {
        out.printf("<option value='%d'>%s</option>", mgr.getNo(), mgr.getName());
      }
      out.println("</select><br>");
      out.println("<button>등록</button>");
      out.println("<a href='list'>목록</a>");
      
    } catch (Exception e) {
      req.setAttribute("error", e); // ServletRequest 보관소에 오류 정보를 보관한다.
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
  }
}
