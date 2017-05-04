/* 리터럴 - 기본 데이터 타입의 리터럴(literal) 표현 
 */
package stap01;

public class Test02 {

  public static void main(String[] args) {
    
    // 기본 데이터 타입
    // 1) 정수 데이터 형
    System.out.println('가'); // 문자 값. 2byte 크기
    System.out.println(100); // 정수 값. 4byte 크기 정수
    System.out.println(100L); // 정수 값. 8byte 크기 정수
    // 2) 부동소수점 데이터 형
    System.out.println(3.14f); // 부동소수점 값. 4byte 크기
    System.out.println(3.14); // 부동소수점 값. 8byte 크기
    // 3) 논리 데이터 형
    System.out.println(true); // 논리 값. 4byte 크기
    // 4) 객체 데이터 형
    System.out.println("문자열"); // 문자열
//    System.out.println('이건안되') // ''는 한 개의 문자만 표현
  }
}
