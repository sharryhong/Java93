/* 지금까지 응용 - 강의관리 만들기 : 강의 조회하기
 */
package hs_lecture;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hs_croom.Classroom;
import hs_manager.Manager;

@WebServlet(urlPatterns="/hs_lecture/Servlet04")
public class Servlet04 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {     
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 조회</h1>");
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      // DB커넥션을 관리할 객체를 만든다.
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      // DAO에 DB커넥션 풀을 전달한다. 
      LectureDao lectureDao = new LectureDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      
      Lecture lecture = lectureDao.selectOne(no);
      
      hs_croom.DBConnectionPool conPool2 = new hs_croom.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      hs_croom.ClassroomDao classroomDao = new hs_croom.ClassroomDao(conPool2);
//      System.out.println(classroomDao.selectNameList());
      List<Classroom> crooms = classroomDao.selectNameList();
      
//      Gson gson = new Gson();
//      String json = gson.toJson(crooms);
//      System.out.println(json);
      Writer writer = new FileWriter("Output.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(crooms, writer);
      
      hs_manager.DBConnectionPool conPool3 = new hs_manager.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      hs_manager.ManagerDao managerDao = new hs_manager.ManagerDao(conPool3);
      List<Manager> mgrs = managerDao.selectNameList();
      
      if (lecture == null) {
        throw new Exception(no + "번 강의가 없습니다.");
      } 
      
      out.println("<form action='Servlet05' method='post'>");
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

      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='Servlet02'>목록</a>");
    }
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'Servlet06?no=%s'\n", req.getParameterValues("no"));
    out.println("}");
    out.println("function doList() {");
    out.println("  location.href = 'Servlet02'");
    out.println("}");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
}
