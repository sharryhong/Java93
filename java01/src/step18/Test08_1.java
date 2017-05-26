/* 소켓 프로그래밍 응용 : 채팅 서버 만들기 - v1
 * => 기본기능 : 클라이언트와 연결한 후 메시지 주고 받기 
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test08_1 {
  class Value {
    int v1;
    int v2;
    String op;
  }
  
  class ChatJob implements Runnable {
    Socket socket;
    public ChatJob(Socket socket) {
      this.socket = socket;
      System.out.println("클라이언트와 연결되었음!");
    }
    public void run() {

      try(
          Socket socket = this.socket; 
          BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        String alias = in.readLine(); // 첫번째 줄로 넘어온걸 별명으로 
        out.printf("[%s]님이 입장하였습니다.\n", alias);
        
        while (true) {
          String message = in.readLine(); // 읽을때 
          if (message == null) break; // 클라이언트에서 종료신호를 보내면 입출력을 끝낸다. (FIN packet받으면 끝낸다.)
          
          out.println(message); // 쓸때. 출력
          out.flush(); // 캐쉬에 있는 것 방출
        }
        System.out.println("=> 클라이언트와 연결 끊김");
      } catch (Exception e) {
        e.printStackTrace(); // 클라이언트와 대화중 예외발생시 그 이유 출력
      }
    }
  }
  public void listen(int port) throws Exception { // static 아니다. 인스턴스 메서드 
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new Thread(new ChatJob(serverSocket.accept())).start(); // Runnable 규칙에 따라 만든 것이 들어온다. 
    }
  }
  
  public static void main(String[] args) throws Exception {
    Test08_1 server = new Test08_1(); // Test07_1 클래스가 로딩된 상태이기 때문에 자기자신을 쓰는데 문제가 없다.
    server.listen(8888);
    
  }
}
