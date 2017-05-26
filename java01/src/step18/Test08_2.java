/* 소켓 프로그래밍 : 채팅 서버 만들기 - v2
 * => ChatJob들의 연락처를 구축하여 공유한다.
 * => 이렇게 구축된 연락처는 
 *    클라이언트로부터 받은 메시지를 다른 클라이언트에게 보낼 때 사용한다.      
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Test08_2 {
  //제네릭을 써서 이 ArrayList에는 ChatJob type만 저장
  ArrayList<ChatJob> chatJobs = new ArrayList<>();
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new Thread(new ChatJob(serverSocket.accept())).start(); // Runnable 규칙에 따라 만든 것이 들어온다.
    }
  }
  
  // sendAll() : 스레드에서 서버로 보내는 메서드
  // 스레드 중 한 스레드가 sendAll()하면, 서버가 스레드들에게 send()한다. 실제 일하는 것은 각 스레드이다. 
  // 먼저 요청한 스레드 순서대로 작업을 실행시킨다. 뮤텍스 적용.
  synchronized public void sendAll(String message) {
    for (int i = chatJobs.size() - 1; i >= 0; i--) {
      // 프로그램을 실행하다가 예외발생하더라도 catch문안의 명령을 실행하고
      // 시스템을 멈추지 않고 계속 실행하게 만드는 예외처리문법의 전형적인 예
      try {
        chatJobs.get(i).send(message);
      } catch (Exception e) {
        chatJobs.remove(i);  // 만약 보내다가 에러나면, 그 객체를 제거한다.
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    Test08_2 server = new Test08_2(); // 클래스가 로딩된 상태이기 때문에 자기자신을 쓰는데 문제가 없다.
    server.listen(8888);
  }
  
  class ChatJob implements Runnable {
    Socket socket ;
    String address;
    PrintStream out;
    
    public ChatJob(Socket socket) {
      this.socket = socket;
      this.address = ((InetSocketAddress)socket.getRemoteSocketAddress()).getHostString();
      System.out.println(address);
      chatJobs.add(this);
    }
    
    public void run() {
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) {
        this.out = out; // 다른 스레드가 메시지를 보낼 때 사용한다.
        String alias = in.readLine(); // 첫번째 줄로 넘어온걸 별명으로
        sendAll(String.format("[%s:%s]님이 입장하였습니다.", alias, address)); // String.format(문자열, 값) => 문자열이 자리에 놓인다.
        
        while (true) {
          String message = in.readLine();
          if (message == null) // 클라이언트에서 종료 신호를 보낸다면 
            break; // 입출력을 끝낸다.  (FIN packet받으면 끝낸다.)
          
          sendAll(String.format("[%s:%s] %s", alias, address, message));
        }
      } catch (Exception e) {
        e.printStackTrace(); // 클라이언트와 대화중 예외발생시 그 이유 출력
      }
    }
    
    public void send(String message) throws Exception {
      out.println(message);
      out.flush();
    }
  }
}