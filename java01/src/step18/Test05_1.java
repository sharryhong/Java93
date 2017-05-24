/* 소켓 프로그래밍 응용 : HTTP 클라이언트 만들기
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

public class Test05_1 {
  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("[사용법] > java -cp bin step18.Test05_1 URL");
      return;
    }
    
    // URL에서 host주소, 포트번호, 자원경로를 분리한다.
    // 예) http://www.google.com:80/test.html 일 경우
    // => host주소 : www.google.com
    // => port : 80
    // => path : /test.html
    String url = args[0].replace("http://", ""); // http:// 지우기
    
    // host를 뽑아보자. 콜론, 슬래시 만나기 전
    String host = null;
    // url에 콜론(:)이 있다면 포트번호가 있다는 것
    int port = 80; // 포트번호 기본이 80번
    int colonIndex = url.indexOf(":");
    int firstSlashIndex = url.indexOf("/");
    String path = url.substring(firstSlashIndex); // path 구하기
    
    if (colonIndex >= 0) { // 콜론이 있다면
      host = url.substring(0, colonIndex); // 콜론 전까지가 host주소
      port = Integer.parseInt(url.substring(colonIndex + 1, firstSlashIndex)); // 포트번호 뽑기
    } else {
      host = url.substring(0, firstSlashIndex); // 콜론이 없다면 0 ~ 슬래시 전까지가 host주소
    }
    

    try (
      Socket socket = new Socket(host, port);
      // charactor stream으로 읽는다.
        // socket.getInputStream() 리턴값은 바이트스트림이다. InputStreamReader에 꽂으면 캐릭터스트림으로 해준다.
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(
                             new BufferedOutputStream(socket.getOutputStream()));) { 

      // HTTP서버에게 요청 데이터 보내기 
      // 1) request line(요청라인) - 예) GET /test/ok/index.html HTTP/1.1 CRLF
      out.printf("GET %s HTTP/1.1\n", path);

      // 2) header(genaral + request + entity) 일반헤더, 요청헤더, 엔티티헤더
      //    예) Host: www.daum.net
      // => 최소 Host 헤더 데이터는 보내야한다. 
      out.printf("Host: %s\n", host);
      
      // 3) 요청 데이터의 끝을 의미하는 줄 바꿈 코드를 보낸다.
      out.println();
      out.flush();
      
      // [HTTP 서버가 응답한 데이터를 읽는다.]
      String str = null;
      while (true) {
        str = in.readLine();
        System.out.println(str);
        if (str.length() == 0) { 
          break;
        }
      }
      
      int ch;
      while ((ch = in.read()) != -1) {
        System.out.print((char)ch); // 읽은 것 출력
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
