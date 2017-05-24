/* 소켓 프로그래밍 : 서버 소켓 대기열 - 서버
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test02_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    ServerSocket serverSocket = new ServerSocket(8888, 3); // 3 : 백로그(대기열) 갯수
    System.out.println("=> 서버 소켓 생성 완료!");
    
    Socket socket = serverSocket.accept();
    System.out.println("=> 클라이언트 연결 승인!");
    InputStream in0 = socket.getInputStream();
    OutputStream out0 = socket.getOutputStream();
    
    Scanner in = new Scanner(in0); // 한줄씩 출력하고자.
    PrintStream out = new PrintStream(out0);
    
    String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다. 
    out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다. 
    
    in.close();
    in0.close();
    out.close();
    out0.close();
    socket.close();
    serverSocket.close();
  }
}
