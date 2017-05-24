/* 소켓 프로그래밍 : 여러 클라이언트의 요청을 처리하기(서버)
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test03_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("=> 서버 소켓 생성 완료!");
    
    while (true) { // 무한루프이기 때문에 언제 탈출(close())할 건지 지정하지 않는다. 
      try ( // 자동 자원 환원. try () 내부에는 자동환원관련 코드만 올 수 있다. 즉, 변수선언, if문 등 올 수 없다.
        Socket socket = serverSocket.accept();
        InputStream in0 = socket.getInputStream();
        OutputStream out0 = socket.getOutputStream();
        Scanner in = new Scanner(in0);
        PrintStream out = new PrintStream(out0);) {
        
        System.out.println("=> 클라이언트 연결 승인!"); 
        String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다. // 이걸 쓰기 위해 Scanner
        out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다. // 이걸 쓰기 위해 PrintStream 
      } catch (Exception e) {} // 예외발생시 무시
    }
  }
}
