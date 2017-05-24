/* 리터럴 - 정수 리터럴
 */
package stap01;

public class Test03 {

  public static void main(String[] args) {
    // 1)
    System.out.println(-10);
    System.out.println(10);
    // 4byte 양의 정수 최대값 : 2의 32승 - 1 (4바이트=32비트) 이 중 음수가 있으므로 나누기 2 = 2147483647
    // 4byte 음의 정수 최대값 : -2147483648
    System.out.println(2147483647); // 약 21억. 즉 우리나라 예산(약 400조) 표현 못한다. 
    System.out.println(-2147483648);
    
    // 2)
    // 금융시스템은 이것도 부족. bigInt, bigFloat등 특수한 것 이용
    // 과학기술용 언어 따로있다. 자바는 일반적 프로그래밍 언어이다. 
    System.out.println(-10L);
    System.out.println(10l);
    System.out.println(9223372036854775807L); // 8byte 양의 정수 최대값. 약 922경
    System.out.println(-9223372036854775808L); // 8byte 음의 정수 최대값
  }
}
