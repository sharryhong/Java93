/* 소켓 프로그래밍 : 서버 프로그램 만들기
 * => 소켓(socket)?
 *   
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    // 1) 서버 소켓 만들기
    ServerSocket serverSocket = new ServerSocket(8888);
    
    // 2) 대기열(대기하고 있는 열)의 첫번째 클라이언트 접속 승인
    // 
    Socket socket = serverSocket.accept(); // serverSocket.accept()가 소켓 객체를 리턴한다. 
    
    ////// => 네트워킹 프로그램은 위 의 두 줄이 끝이다. 
    
    // 3) 소켓을 통해 입출력할 수 있도록 스트림 객체 만든다. 
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    
    // 4) 소켓으로 클라이언트와 연결되면, 데이터를 주고받는 순서는 상관없다. 
    // 
    int b = in.read(); // 클라이언트에서 1바이트를 보낼 때까지 계속 기다린다. => blocking 모드
    System.out.printf("%x\n", b);
    
    out.write(0x01); // 무조건 1 리턴
    
    // 5) 클라이언트와 데이터입출력이 끝났으면 연결끊기
    in.close();
    out.close();
    socket.close();
    serverSocket.close();
  }
}
