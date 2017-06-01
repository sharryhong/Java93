/* 웹 애플리케이션 실행하기 
 * 1) ex7 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) ex8 클라이언트가 요청한 자원을 처리한다.
 * 3) ex9 HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) ex10 Command 패턴 적용
 */
package step23.ex10;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HttpServer {
  int port;
  
  //클라이언트 요청을 처리할 객체를 담는다. 
  HashMap<String, Command> servletMap = new HashMap<>();
   
  public HttpServer(int port) {
    this.port = port;
     
    // url과 url을 처리할 객체를 맵에 보관한다.
    servletMap.put("/hello", new HelloServlet());
    servletMap.put("/ok", new OkServlet());
    servletMap.put("error", new ErrorServlet());
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }

}
