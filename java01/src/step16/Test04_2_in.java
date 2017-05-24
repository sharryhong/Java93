/* Data Processing Stream 클래스 - BufferdInputStream 도입 전 2
 * => 버퍼를 준비하여 일정량 만큼 읽는다. 
 */
package step16;

import java.io.FileInputStream;

public class Test04_2_in {

  public static void main(String[] args) throws Exception { 

    FileInputStream in = new FileInputStream("temp/jls8.pdf");

    byte[] buf = new byte[8196]; // 보통 8kbyte정도로 준비한다. 1024*8
    int len = 0; // 읽은 갯수
    int countPoint = 0;
    
    long start = System.currentTimeMillis(); // 시간 구하기
    while ((len = in.read(buf)) != -1) { // 최대 8196byte읽어. 예를들어 8197바이트면 첫번째 8196, 두번째 1, 그 다음 -1
        System.out.print(".");
        if ((++countPoint % 50) == 0) {
          System.out.println();
        }
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    in.close();
  }
}
