/* Data Processing Stream 클래스 - BufferdOutputStream 도입 후 
 * 
 * BufferdInputStream/BufferdOutputStream
 * => 데이터를 읽고 쓸 때 중간에 임시 저장소 버퍼(캐시)를 이용한다.
 */
package step16;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test04_4_out {

  public static void main(String[] args) throws Exception { 

    FileOutputStream out0 = new FileOutputStream("temp/test04_4.data");
    BufferedOutputStream out = new BufferedOutputStream(out0);

    long start = System.currentTimeMillis(); // 시간 구하기

    for (int i = 1; i <= 4000000; i++) { // 400만 바이트 출력
      out.write(i); // 1byte출력이 아니라 실제로는 8192바이트씩 출력 
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    out.flush(); // 버퍼를 썼을 때는 close하기 전에 반드시 flush를 해야한다. 
                 // 버퍼가 꽉 차지 않으면 출력하지 않는 경우를 방지하기 위해, 현재 버퍼에 있는 데이터를 강제로 출력시킨다.
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
    out0.close();
  }
}
