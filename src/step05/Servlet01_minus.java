/* 화면을 나눠서 처리하기: 포워딩과 인클루딩
 * */
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/step05/Servlet01/minus")  
public class Servlet01_minus extends HttpServlet  {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  //응답할 때 HTTP 프로토콜에 따라 Refresh 헤더를 붙이고 싶다!
    //그런데 ServletResponse 도구에는 HTTP 응답 헤더를 추가시키는 기능이 없다.
    //비밀!
    //만약 서블릿 컨테이너가 웹서버와 연동한다면,  
    HttpServletRequest httpReq = (HttpServletRequest) req; //(타입 캐스팅)
    HttpServletResponse httpRes = (HttpServletResponse) res;
    
//    if (req.getParameter("page") == null) {      
//      httpRes.setHeader("Refresh", "1; url=Servlet01/a");
//      //웹 브라우저에게 명령을 내림: Servlet01이 보낸 결과를 출력 한 후 1초 후에 
//      //다시 웹 서버에서 Servlet01/a url을 요청하라는 명령
//      
//    } else if (req.getParameter("page").equals("b")) {
//      httpRes.setHeader("Refresh", "1; url=Servlet01/b");
//    }
 
    res.setContentType("text/html;charset=UTF-8");  //html을 하면 웹 브라우저에서 html로 인식해서 엔터가 안먹힘
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("   <meta charset='UTF-8'>");
    out.println("   <title>포워딩</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>빼기 결과</h1>");
    
    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));
    String op = req.getParameter("op");
    
    if (op.equals("-")) {
      out.printf("%d - %d = %d\n", a, b, (a-b));
    } else {
      // 다른 서블릿에게 실행 위임한다.
      // 1) 다른 서블릿에게 요청 및 응답 도구를 전달할 객체를 준비한다. (RequestDispatcher : 요청 배달자)
      RequestDispatcher rd = req.getRequestDispatcher("/step05/Servlet01/multiple");
      // 2) 요청 배달자를 이용하여 해당 서블릿에게 실행을 위임한다.
      //    - 위임할 때 서블릿 컨테이너로부터 받은 도구를 그대로 전달한다.
      rd.forward(req, res); 
      // 중요!
      // sendRedirect()와 마찬가지로 포워딩할 때 그 전에 출력한 내용은 취소된다. 
      return; // 리턴(현재 메서드 종료)하는게 좋다. 다음을 실행해봐야 소용없기 때문 
    }
    
    out.println("</body>");
    out.println("</html>");
    
  }  

}