/* 웹 애플리케이션 실행하기 
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리한다.
 */
package step23.ex8;

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
        boolean requestLine = true;
        String url = null;
        
        while (true) {
          line = in.readLine();
          System.out.println(line);
          if (line.isEmpty())
            break;
          if (requestLine) {
            requestLine = false;
            // line에서 url추출 
            url = extractUrl(line);
            
          }
        }
        // url추출한 값이 따라서 메서드 실행 
        if (url.equals("/hello")) {
          // hello()메서드 호출. 출력스트림을 넘긴다.
          hello(out);
        } else if (url.equals("/ok")) {
          ok(out);
        } else {
          error(out);
        }
        
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } // run
    
    private String extractUrl(String requestLine) {
      return requestLine.substring((requestLine.indexOf(" ") + 1), requestLine.lastIndexOf(" "));
    }
    
    private void hello(PrintStream out) {
      out.println("HTTP/1.1 200 OK");
      out.println("Server: BIT Server");
      out.println();
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>hello</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  <h1>/hello 입니다 :) </h1>");
      out.println("<body>");
      out.println("</html>");
      out.flush();
    }
    
    private void ok(PrintStream out) {
      out.println("HTTP/1.1 200 OK");
      out.println("Server: BIT Server");
      out.println();
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>hello</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  <h1>/ok를 요청하셨네요 :) </h1>");
      out.println("<body>");
      out.println("</html>");
      out.flush();
    }
    
    private void error(PrintStream out) {
      out.println("HTTP/1.1 200 OK");
      out.println("Server: BIT Server");
      out.println();
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>hello</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  <h1>요청한 자원을 찾을 수 없습니다.</h1>");
      out.println("<body>");
      out.println("</html>");
      out.flush();
    }
  }

}
