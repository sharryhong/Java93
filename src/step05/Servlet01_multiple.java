/* 화면을 나눠서 처리하기: 포워딩과 인클루딩
 * */
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/step05/Servlet01/multiple")  
public class Servlet01_multiple extends HttpServlet  {
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
    out.println("<h1>곱하기 결과</h1>");
    
    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));
    String op = req.getParameter("op");
    
    if (op.equals("*")) {
      out.printf("%d * %d = %d\n", a, b, (a*b));
    } else {
      //다른 서블릿에게 위임한다.
      out.printf("%s 연산을 지원하지 않습니다.\n", op);
    }
    
    out.println("</body>");
    out.println("</html>");
    
  }  

}