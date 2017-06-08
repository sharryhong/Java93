package bitcamp.java93.servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import bitcamp.java93.dao.ClassroomDao;
import bitcamp.java93.dao.LectureDao;
import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.utill.DBConnectionPool;

// 웹 애플리케이션이 시작될 때 이 서블릿 객체를 자동생성
@WebServlet(urlPatterns="/InitServlet", loadOnStartup=1)
public class InitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      // DBConnectionPool의 객체주소를 memberDao가 가지고 있으므로 메서드 호출이 끝나더라도 누군가 주소를 가지고 있으면 heap에 유지되어있다.
      // 현재는 memberDao를 ServletContext에 보관해놓았다. 
      MemberDao memberDao = new MemberDao(conPool);
      ClassroomDao classroomDao = new ClassroomDao(conPool);
      LectureDao lectureDao = new LectureDao(conPool);
      ManagerDao managerDao = new ManagerDao(conPool);
      
      // 모든 서블릿이 사용할 수 있도록 memberDao 객체를 ServletContext에 보관한다.
      ServletContext sc = this.getServletContext();
      sc.setAttribute("memberDao", memberDao);
      sc.setAttribute("classroomDao", classroomDao);
      sc.setAttribute("lectureDao", lectureDao);
      sc.setAttribute("managerDao", managerDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
