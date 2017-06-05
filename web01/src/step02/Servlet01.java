/* service() 파라미터 : Servlet Container가 넘겨준다. 
 * 1) ServletRequest
 *    클라이언트 요청 정보를 다루는 도구 
 * 2) ServletResponse
 *    클라이언트 응답 정보를 다루는 도구 
 */
package step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet01")
public class Servlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // Request 주요 메서드들 
    System.out.printf("RemoteHost: %s\n", req.getRemoteHost()); // 클라이언트 이름. 원격 접속 (접속한pc)
    System.out.printf("RemoteAddr: %s\n", req.getRemoteAddr()); // 클라이언트 IP
    System.out.printf("RemotePort: %s\n", req.getRemotePort()); // 클라이언트 포트번호. os에 의해 자동
    System.out.printf("Scheme: %s\n", req.getScheme()); // 프로토콜 명. 클라이언트와 통신할 때 사용하는 프로토콜이 무엇인가
    System.out.printf("Parameter(name): %s\n", req.getParameter("name")); 
    System.out.printf("Parameter(age): %s\n", req.getParameter("age"));
  }
}
