/* 소켓 프로그래밍 응용 : 파일 전송 프로그램 - 클라이언트
 * 연습. 무슨 파일이던지 전송할 수 있게 
 */
package step18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test04_2 {
  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      System.out.println("[사용법] > java -cp bin step18.Test04_2 서버주소 포트번호 파일명");
      return;
    }
    
    File file = new File(args[2]); // Autoclosable규칙에 만든 클래스가 아니라서 try()안에 못들어간다.
    try (
    BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));

    Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
    Scanner in = new Scanner(socket.getInputStream());
 // 소켓으로 여러 데이터 타입 출력하기 위해, 그리고 속도 빠르게 하기 위해
    DataOutputStream out = new DataOutputStream(
                             new BufferedOutputStream(socket.getOutputStream()));) { 
        
      // 서버로 데이터 보내기
      // 1) 파일명 보내기
      out.writeUTF(file.getName());
          
      // 2) 파일크기 보내기
      out.writeLong(file.length());
      
      // 3) 파일 보내기
      for (long i = 0; i < file.length(); i++) {
        out.write(fileIn.read()); // 읽은 걸 출력. 버퍼에서 읽어서 버퍼로 출력
      }
      out.flush();
      
      // 4) 서버가 보낸 데이터 읽기
      System.out.println(in.nextLine());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
