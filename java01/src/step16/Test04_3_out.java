/* Data Processing Stream 클래스 - MyBufferedOutputStream 만들기 
 * 
 * BufferdInputStream/BufferdOutputStream
 * => 데이터를 읽고 쓸 때 중간에 임시 저장소 버퍼(캐시)를 이용한다.
 */
package step16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test04_3_out {
  
  static class MyBufferedOutputStream {
    OutputStream out;
    byte[] buf = new byte[8192];
    int cursor;
    
    MyBufferedOutputStream(OutputStream out) {
      this.out = out;
    }
    
    public void write(int b) throws IOException {
      buf[cursor++] = (byte)b; 
      if (cursor == buf.length) { // 버퍼가 꽉 찼다면
        out.write(buf); // 출력한다. 
        cursor = 0; // 커서는 다시 0으로
      }
    }
    // 버퍼가 꽉 차지 않아도 현재 있는 것까지 출력하기
    public void flush() throws IOException {
      out.write(buf, 0, cursor); // 0부터 커서 위치까지 출력
    }
    
    public void close() {}
  }

  public static void main(String[] args) throws Exception { 

    FileOutputStream out0 = new FileOutputStream("temp/test04_3.data");
    MyBufferedOutputStream out = new MyBufferedOutputStream(out0);

    long start = System.currentTimeMillis(); // 시간 구하기

    for (int i = 1; i <= 4000000; i++) { // 400만 바이트 출력
      out.write(i); // 1byte출력이 아니라 실제로는 8192바이트씩 출력 
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    out.flush();
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
    out0.close();
  }
}
