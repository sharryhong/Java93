/* 웹 서버 만들기
 * 1) 기본 클래스 골격 준비
 * 2) 클라이언트 연결 받기
 * 3) 소켓을 통해 입출력을 할 수 있게 스트림 객체를 준비한다. 
 */
package step23.ex4;

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
      try (
        Socket socket = serverSocket.accept();
          // socket.getInputStream()은 입력스트림(바이트) 리턴
          // 브라우저가 웹서버에게 Line단위로 보낸다. 따라서 라인단위로 읽는게 좋겠다/
          // 그 중 BufferedReader가 있다. 
          // 이것은 Reader계열이므로 바이트스트림을 캐릭터스트림으로 바꿔주는 어뎁터가 필요하다.
          // 그 것이 바로 InputStreamReader 클래스이다. 
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          // 출력도 마찬가지로 Line단위로 출력한다. 
          // PrintStream은 바이트 스트림이지만 println이 있으므로 그냥 쓰면된다.
          // BufferedOutputStream가 모았다가 출력한다. 
          // 플러쉬를 하면 남은 것 모두 출력 
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) {
        System.out.println("클라이언트가 연결되었습니다.");
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();

  }

}
