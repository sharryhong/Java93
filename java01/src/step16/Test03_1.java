/* Binary File I/O (바이너리 파일 입출력) - ByteArrayOutputStream
 * => 바이트 배열 메모리를 출력하는 클래스 
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Test03_1 {

  public static void main(String[] args) throws Exception { 
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    /* 스트리밍 방식이 아니라 일반 방식으로 데이터 저장하기
     * byte[] buf = new byte[3];
     * buf[0] = 0x99;
     * buf[1] = 0x44;
     * buf[2] = 0x78; 
     */
    
    // 스트리밍 API를 사용
    // 이 출력 스트림 객체는 파일이 아니라 내부에서 따로 관리하는 바이트 배열 메모리로 출력한다. 
    out.write(0x66778899); // 99
    out.write(0x77445544); // 44
    out.write(0x77445578);  // 78
    
    //==========================================================
    
    // 이 출력 스트림 객체가 관리하는 바이트 배열 얻기
    byte[] buf = out.toByteArray();
    
    /* 스트리밍 방식이 아니라 일반 방식으로 데이터 읽기 
    for (byte b : buf) {
      System.out.printf("%x ", b); // 99 44 78 
    }
    out.close(); */
    
    // 스트리밍 API를 사용해서 바이트배열에서 값을 읽어보자. 
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    int b = 0;
    while (true) {
      b = in.read(); // value가 -1을 리턴한다면, 끝에 도달했다는 의미이다. 
      if (b == -1) break; // 반복 종료
      System.out.printf("%x ", b);
    }
    out.close();
  }
}
