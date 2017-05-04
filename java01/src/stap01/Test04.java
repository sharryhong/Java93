/* 리터럴 - 정수 리터럴과 자릿수 표시
 */
package stap01;

public class Test04 {

  public static void main(String[] args) {
    // 언더바(_)로 표시할 수 있다. 우리나라는 4자리로 나누면 편하다.
    // 그러나 외국애들은 3자리마다 끊으므로 이렇게하면 소통하기 어렵다. 
    // 그래도 소스코드를 읽는 개발자를 위한 것이므로 알아서하면된다. 
    System.out.println(21_4748_3647);
    System.out.println(-2_147_483_648);
    System.out.println(9223372036854775807L);
    System.out.println(-9223372036854775808L);
  }
}
