/* 명시적 형변환 - 유니코드 char 타입
 *  
 */

package step03;

public class Test01_4 {

  public static void main(String[] args) {
    int i = '가'; // 유니코드 값 리턴 = 44032
    System.out.println(i); // 44032
    System.out.println((char)i); // 가
  }

}
