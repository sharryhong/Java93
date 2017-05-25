/* 소켓 프로그래밍 응용 : H's 메신저 서버 만들기
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test07_hs {
  class Value {
    String msgBox;
    String nickname;
  }
  
  class messenger implements Runnable {
    Socket socket;
    public messenger(Socket socket) {
      this.socket = socket;
      System.out.println("클라이언트와 연결되었음!");
    }
    public void run() {
      int count = 0;
      try(
          Socket socket = this.socket; 
          BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {
        // connectionful : 연결되어 있는 동안 계속 클라이언트와 통신하기
        // 클라이언트에서 연결끊을 때 까지 
        while (true) {
          String json = in.readLine(); // 읽을때 
          if (json == null) break;
          
          // Gson 객체를 이용해 JSON 문자열을 Value객체로 만든다.
          Gson gson = new Gson();
          Value value = gson.fromJson(json, Value.class); // json으로부터 받아 Value class 자바 객체로 만든다.
                      // .class : class변수이다. class정보가 담겨있다.나중에 Reflection배울때 자세히 배움

//          System.out.println(value.toString());
          String result = "";
          if (count == 0) { // 처음 접속 시
            result = value.nickname + "님이 입장하였습니다.";
            count++;
          } else {
            result = "[" + value.nickname + "] " + value.msgBox;
          }
          out.println(result);
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
//      messenger job = new messenger(serverSocket.accept()); // 한번 사용하기 때문에 임시변수 사용하지 않아도된다. 아래처럼
      new Thread(new messenger(serverSocket.accept())).start(); // Runnable 규칙에 따라 만든 것이 들어온다. 
    }
  }
  
  public static void main(String[] args) throws Exception {
    Test07_hs server = new Test07_hs(); // Test07_1 클래스가 로딩된 상태이기 때문에 자기자신을 쓰는데 문제가 없다.
    server.listen(8888);
    
  }
}
