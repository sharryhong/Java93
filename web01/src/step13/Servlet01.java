package step13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step13/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  // url로 들어오거나 a링크 누르거나 등..
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원기본정보</h1>");
    out.println("<form action='Servlet01' method='post'>");
    out.println("이름: <input type='text' name='name'><br>");
    out.println("전화: <input type='text' name='tel'><br>");
    out.println("이메일: <input type='text' name='email'><br>");
    out.println("암호: <input type='password' name='password'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  // form method='post'
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Member member = new Member();
    member.name = req.getParameter("name");
    member.tel = req.getParameter("tel");
    member.email = req.getParameter("email");
    member.password = req.getParameter("password");
    
    // 다른 서블릿에서 쓸 수 있도록 HttpSession 
    HttpSession session = req.getSession();
    session.setAttribute("member", member); // member 인스턴스 주소 저장
    
    resp.sendRedirect("Servlet02");
  }
}
