/* Data Processing Stream 클래스 - BufferdOutputStream 도입 전 2
 * => 버퍼를 이용하여 출력 속도 향상
 */
package step16;

import java.io.FileOutputStream;

public class Test04_2_out {

  public static void main(String[] args) throws Exception { 

    FileOutputStream out = new FileOutputStream("temp/test04_2.data");

    byte[] buf = new byte[8196]; // 8196byte 버퍼를 준비한다. 
    int len = 0;
    long start = System.currentTimeMillis();

    for (int i = 1; i <= 4000000; i++) { // 400만 바이트 출력
   // 버퍼에 넣다가 꽉차면 출력하기 
      buf[len++] = (byte)i; 
      if (len == 8196) {
        out.write(buf);
        len = 0;
      }
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    if (len > 0) { // buf에 꽉 안차더라도, len이 남아있다면 출력하라. 
      out.write(buf, 0, len);
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
  }
}
