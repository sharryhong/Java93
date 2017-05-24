/* Data Processing Stream 클래스 - BufferdInputStream를 만들어보자.
 * => 버퍼를 준비하여 일정량 만큼 읽는다. 
 */
package step16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test04_3_in {

  public static void main(String[] args) throws Exception { 
    
    class MyBufferedInputStream {
      InputStream in;
      byte[] buf = new byte[8192];
      int len; // 버퍼의 전체길이
      int cursor; // 커서 정보
      // 생성자
      MyBufferedInputStream(InputStream in) {
        this.in = in;
      }
      
      public int read() throws IOException {
        if (cursor == len) { // 버퍼를 다 읽었다면 
          cursor = 0;
          len = in.read(buf); // 새로 읽는다.
          if (len < 0) return -1; // 파일을 모두 읽었다면 -1을 리턴하여 호출자에게 알려준다. 
        }
        return buf[cursor++] & 0x000000FF; // 암시적형변환에 의해 byte가 int로 될 경우 빈자리가 부호비트로 채워진다. 
                                           // 값이 -1이 되는걸 막자. 그래서 & 로서.. 둘다 1일때만 1이 되도록 한다. 
      }
      public void close() {}
    }

    FileInputStream in0 = new FileInputStream("temp/jls8.pdf");
    MyBufferedInputStream in = new MyBufferedInputStream(in0);

    int b = 0; // 1byte씩 읽듯이 하면 BufferdInputStream이 내부적으로 8kb 사용해서 알아서 해준다.
    int count = 0;
    long start = System.currentTimeMillis();

    while ((b = in.read()) != -1) { // 값이 ff면 
        if ((++count % 10000) == 0) System.out.print("."); 
        if ((count % 500000) == 0) System.out.println();
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    in.close();
    in0.close();
  }
}
