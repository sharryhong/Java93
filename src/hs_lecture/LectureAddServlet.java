/* 지금까지 응용 - 강의관리 만들기 : 강의등록하기
 */
package hs_lecture;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import hs_croom.Classroom;
import hs_manager.Manager;

@WebServlet(urlPatterns="/hs_lecture/add")
public class LectureAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { 
    req.setCharacterEncoding("UTF-8");
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 등록</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      LectureDao lectureDao = new LectureDao(conPool);
      
      hs_croom.DBConnectionPool conPool2 = new hs_croom.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      hs_croom.ClassroomDao classroomDao = new hs_croom.ClassroomDao(conPool2);
      List<Classroom> crooms = classroomDao.selectNameList();
      
      hs_manager.DBConnectionPool conPool3 = new hs_manager.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      hs_manager.ManagerDao managerDao = new hs_manager.ManagerDao(conPool3);
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
      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='list'>목록</a>");
    }
    
    out.println("<a href='list'>목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
