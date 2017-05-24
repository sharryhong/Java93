/* 소켓 프로그래밍 : 여러 클라이언트의 요청을 처리하기(서버) - Thread 적용
 * => 여러 클라이언트 요청을 병행으로 처리
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test03_2 {
  
  // 클라이언트 요청을 처리할 작업자(쓰레드) 정의
  static class MyThread extends Thread {
    Socket socket;
    
    public MyThread(Socket socket) {
      this.socket = socket;
    }
    
    // "main"작업자와 동등한 관계에서 병행으로(동시에) 수행할 작업을 정의
    public void run() {
      try (
          InputStream in0 = socket.getInputStream();
          OutputStream out0 = socket.getOutputStream();
          Scanner in = new Scanner(in0);
          PrintStream out = new PrintStream(out0);) {
          
          System.out.println("=> 클라이언트 연결 승인!"); 
          String str = in.nextLine();
          out.println(str); 
        } catch (Exception e) {}
    }
  }
  
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("=> 서버 소켓 생성 완료!");
    
    
    while (true) { 
      // 대기열에서 한 개의 클라이언트 연결정보를 꺼내 소켓 생성 후
      // 통신을 수행할 작업자 준비
      MyThread t = new MyThread(serverSocket.accept()); // serverSocket.accept() : 소켓 객체 생성
                                                        // 소켓 객체 생성 후 스레드 생성
      
      // 작업자에게 일을 시킨다.
      t.start(); // 일 시킨 후 즉시 리턴
    }
  }
}
