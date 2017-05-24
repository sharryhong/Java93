/* Data Processing Stream 클래스 - BufferdInputStream 도입 전 
 * 
 * BufferdInputStream/BufferdOutputStream
 * => 데이터를 읽고 쓸 때 중간에 임시 저장소 버퍼(캐시)를 이용한다.
 * ObjectInputStream/ObjectOutputStream
 * => 객체를 바이트 배열로 만들어 출력, 다시 객체로 복원 
 */
package step16;

import java.io.FileInputStream;

public class Test04_1_in {

  public static void main(String[] args) throws Exception { 

    FileInputStream in = new FileInputStream("temp/jls8.pdf");

    int b = 0;
    int count = 0;
    int countPoint = 0;
    
    long start = System.currentTimeMillis(); // 시간 구하기
    while ((b = in.read()) != -1) { // in.read() : 1byte씩 읽어서 b에 넣는다. -1이 아니라면 : 값이 있다면
      if (++count == 1000) { // 1000byte마다 점찍기 => 용서가 안되! ㅋㅋ
        count = 0;
        System.out.print(".");
        if ((++countPoint % 50) == 0) System.out.println();
      }
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    in.close();
  }
}
