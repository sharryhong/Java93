/* 지금까지 응용 - 강의관리 만들기 : 강의 조회하기
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
import bitcamp.java93.domain.Lecture;
import bitcamp.java93.domain.Manager;

@WebServlet(urlPatterns="/hs_lecture/detail")
public class LectureDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     
    
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
    out.println("<h1>강의 조회</h1>");
    
    try {
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      ClassroomDao classroomDao = (ClassroomDao)this.getServletContext().getAttribute("classroomDao");
      ManagerDao managerDao = (ManagerDao)this.getServletContext().getAttribute("managerDao");
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Lecture lecture = lectureDao.selectOne(no);
      
//      hs_croom.DBConnectionPool conPool2 = new hs_croom.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
//      hs_croom.ClassroomDao classroomDao = new hs_croom.ClassroomDao(conPool2);
//      System.out.println(classroomDao.selectNameList());
      List<Classroom> crooms = classroomDao.selectNameList();
      
//      hs_manager.DBConnectionPool conPool3 = new hs_manager.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
//      hs_manager.ManagerDao managerDao = new hs_manager.ManagerDao(conPool3);
      List<Manager> mgrs = managerDao.selectNameList();
      
      if (lecture == null) {
        throw new Exception(no + "번 강의가 없습니다.");
      } 
      
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", lecture.getNo());
      out.printf("강의명: <input type='text' name='title' value='%s'><br>\n", lecture.getTitle());
      out.printf("강의설명: <input type='text' name='description' value='%s'><br>\n", lecture.getDescription());
      out.printf("시작일: <input type='date' name='startDate' value='%s'><br>\n", lecture.getStartDate());
      out.printf("종료일: <input type='date' name='endDate' value='%s'><br>\n", lecture.getEndDate());
      out.printf("수강인원: <input type='text' name='quantity' value='%d'><br>\n", lecture.getQuantity());
      out.printf("수강료: <input type='text' name='price' value='%d'><br>\n", lecture.getPrice());
      out.printf("총시간: <input type='text' name='thrs' value='%d'><br>\n", lecture.getThrs());
      out.println("강의실: <select id='fi-classroom' name='classroom'>");
      System.out.println(lecture.getCrmno());
      out.println("<option value='0'>강의실을 선택하세요!</option>");
      for (Classroom croom : crooms) {
        if (lecture.getCrmno() == croom.getNo()) {
          out.printf("<option value='%d' selected>%s</option>", croom.getNo(), croom.getName());
        } else {
          out.printf("<option value='%d'>%s</option>", croom.getNo(), croom.getName());
        }
      }
//      out.printf("<option value='%d'>%s</option>", lecture.getCrmno(), crooms.get(lecture.getCrmno()).getName());
      out.println("</select><br>");
      
      out.println("매니저: <select id='fi-manager' name='manager'>");
      out.println("<option value='0'>매니저를 선택하세요!</option>");
      for (Manager mgr : mgrs) {
        if (lecture.getMrno() == mgr.getNo()) {
          out.printf("<option value='%d' selected>%s</option>", mgr.getNo(), mgr.getName());
        } else {
          out.printf("<option value='%d'>%s</option>", mgr.getNo(), mgr.getName());
        }
      }
      out.println("</select><br>");
      
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
