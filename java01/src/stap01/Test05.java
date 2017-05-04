/* 리터럴 - 정수 리터럴과 2진수, 8진수, 10진수, 16진수 (부동소수점은 표현못함)
 */
package stap01;

public class Test05 {

  public static void main(String[] args) {
    System.out.println(100); // 10진수
    System.out.println(0144); // 8진수. 앞에 0 붙인다.
    System.out.println(0x64); // 16진수. 앞에 0x, 0X붙인다. 소문자 더 많이 사용
    System.out.println(0XA9); // 16진수의 숫자에서 a ~ f는 대, 소문자 모두 가능 
    System.out.println(0b01100100); // 2진수. 앞에 0b, 0B붙인다. 소문자 더 많이 사용
  }
}
