/* 소켓 프로그래밍 응용 : 파일 전송 프로그램 - 서버
 * 연습. 무슨 파일이던지 전송할 수 있게 
 */
package step18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test04_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket serverSocket = new ServerSocket(8888);

    while (true) {
      try (
        Socket socket = serverSocket.accept();
          // BufferedInputStream in1 = new BufferedInputStream(socket.getInputStream()); // 속도 높이기위해
          // DataInputStream in = new DataInputStream(in1); // 데이터타입 종류 많아질 수 있어서
          // 위의 두 줄 합쳐서 (이렇게 하자.)
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());) { // println이라는 한 줄 출력이 있어서
        
        // 클라이어언트 보낸 데이터 읽기
        // 1) 파일명 읽기
        String filename = in.readUTF();
        
        // 2) 파일 크기 읽기
        long length = in.readLong();
        
        // 3) 파일 읽기
        // => 파일 출력 스트림 준비
        try (
          BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("temp/" + filename));) { // temp폴더 아래에 저장
          for (long i = 0; i < length; i++) {
            fileOut.write(in.read()); // 읽은 거 그대로 출력
          }
          fileOut.flush();  // 버퍼에 남아있는 데이터를 마저 출력한다. 
        } catch (Exception e) {
          System.out.println("파일 저장 중 오류 발생!");
        }
        
        // 4) 응답
        out.println("ok");
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }
}
