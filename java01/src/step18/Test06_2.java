/* 소켓 프로그래밍 응용 : Echo 클라이언트 만들기
 * => echo할 때마다 서버주소주고 출력
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

public class Test06_2 {
  public static void main(String[] args) throws Exception {
    if (args.length < 3) {
      System.out.println("[사용법] > java -cp bin step18.Test06_2 서버 포트 메시지");
      return;
    }
    
    try (
      Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());
    ) { 

      out.println(args[2]); // 읽어서
      System.out.println(in.nextLine()); // 바로 출력
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
