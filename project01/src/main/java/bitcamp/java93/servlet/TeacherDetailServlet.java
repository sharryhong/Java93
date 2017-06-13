package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/teacher/detail")
public class TeacherDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강사관리</title>");
    
    // including 기법을 사용하여 각 페이지에 기본 CSS 스타일 코드를 출력한다.
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    
    out.println("</head>");
    out.println("<body>");
    
    rd = req.getRequestDispatcher("/header");
    rd.include(req, res);
    
    out.println("<h1>강사 조회</h1>");
    
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      TeacherService teacherService = (TeacherService)this.getServletContext().getAttribute("teacherService");      
      
      Teacher teacher = teacherService.get(no);
      if (teacher == null) {
        throw new Exception(no + "번 강사가 없습니다.");
      }
      
      out.printf("<form action='update' method='POST'>\n");
      out.printf("번호:<input type='text' name='no' value='%d' readonly><br>\n", teacher.getNo());
      out.printf("이름:<input type='text' name='name' value='%s'><br>\n", teacher.getName());
      out.printf("전화:<input type='text' name='tel' value='%s'><br>\n", teacher.getTel());
      out.printf("이메일:<input type='text' name='email' value='%s'><br>\n", teacher.getEmail());
      out.printf("홈페이지:<input type='text' name='homepage' value='%s'><br>\n", teacher.getHomepage());
      out.printf("페이스북:<input type='text' name='facebook' value='%s'><br>\n", teacher.getFacebook());
      out.printf("트위터:<input type='text' name='twitter' value='%s'><br>\n", teacher.getTwitter());
      out.println("암호:<input type='password' name='password'><br>");
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");
      
      out.println("<script>");
      out.println("function doDelete() {");
      out.printf("  location.href = 'delete?no=%s'\n", req.getParameter("no"));
      out.println("}");
      out.println("function doList() {");
      out.println("  location.href = 'list'\n");
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









