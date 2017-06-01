/* 웹 서버 만들기
 * 1) 기본 클래스 골격 준비
 * 2) 클라이언트 연결 받기
 * 3) 소켓을 통해 입출력을 할 수 있게 스트림 객체를 준비한다. 
 * 4) HTTP 요청과 응답 처리
 * 5) 멀티 스레드 적용 
 */
package step23.ex6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  int port;

  public HttpServer(int port) {
    this.port = port;
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      // serverSocket.accept() : 클라이언트가 대기열에 있으면 소켓 만들고 리턴 
      new HttpProcessor(serverSocket.accept()).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
  
  class HttpProcessor extends Thread {
    Socket socket;
    
    public HttpProcessor(Socket socket) {
      this.socket = socket;
    }
    
    public void run() {
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) {
        
        String line = null;
        // 첫 줄만 출력하자.
        boolean requestLine = true;
        while (true) {
          line = in.readLine();
          if (line.isEmpty())
            break;
          if (requestLine) {
            System.out.println(line);
            requestLine = false; // 첫줄만 requestLine이고 그 다음부터는 header이므로
          }
        }
        out.println("HTTP/1.1 200 OK");
        out.println("Server: BIT Server");
        out.println(); // 빈 라인
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>hello</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <h1>안녕하세요</h1>");
        out.println("<body>");
        out.println("</html>");
        out.flush();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

}
