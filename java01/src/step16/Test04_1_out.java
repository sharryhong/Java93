/* Data Processing Stream 클래스 - BufferdOutputStream 도입 전 
 * 
 * BufferdInputStream/BufferdOutputStream
 * => 데이터를 읽고 쓸 때 중간에 임시 저장소 버퍼(캐시)를 이용한다.
 */
package step16;

import java.io.FileOutputStream;

public class Test04_1_out {

  public static void main(String[] args) throws Exception { 

    FileOutputStream out = new FileOutputStream("temp/test04_1.data");

    long start = System.currentTimeMillis(); // 시간 구하기

    for (int i = 1; i <= 4000000; i++) { // 400만 바이트 출력
      out.write(i); // 맨 끝에 1바이트 계속 출력 
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
  }
}
