/* 지금까지 응용 - 회원관리 만들기 : 회원 조회하기
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

@WebServlet(urlPatterns="/hs_croom/detail")
public class ClassroomDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     
    
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
    out.println("<h1>강의실 조회</h1>");
    
    try {
      ClassroomDao classroomDao = (ClassroomDao)this.getServletContext().getAttribute("classroomDao");
      int no = Integer.parseInt(req.getParameter("no"));
      
      Classroom classroom = classroomDao.selectOne(no);
      if (classroom == null) {
        throw new Exception(no + "번 회원이 없습니다.");
      } 
      
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", classroom.getNo());
      out.printf("이름: <input type='text' name='name' value='%s'><br>\n", classroom.getName());
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
