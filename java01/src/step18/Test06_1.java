/* 소켓 프로그래밍 응용 : Echo 서버 만들기
 */
package step18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test06_1 {
  static class EchoThread extends Thread {
    Socket socket;
    
    public EchoThread(Socket socket) {
      this.socket = socket; // socket객체 받아 저장
    }
    
    public void run() {
      try (
        Socket socket = this.socket; // try () 내에서 이렇게 처리해야 try catch 나갈때 자동으로 close된다. 
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
       ) {
        String message = in.nextLine(); // 읽는다.
        out.println("[메롱]" + message); // 읽은거 그대로 돌려준다. 이게 바로 에코서버
      } catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new EchoThread(serverSocket.accept()).start(); // 클라이언트와 연결되는 순간 
                                                     // new EchoThread(serverSocket.accept()) 
    }
  }
}
