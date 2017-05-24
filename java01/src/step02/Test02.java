/* 변수 선언 : 정수변수 
 * 실무에서는 일반 숫자는 int를 많이쓴다. 자바의 기본 연산단위가 int
 * */
package step02;

public class Test02 {

  public static void main(String[] args) {
    byte b;      // 1byte크기의 메모리 (-128 ~ 127)
    short s;     // 2 (-32768 ~ 32767)
    int i;       // 4 (-2147483648 ~ 2147483647)
    long l;      // 8 (-9223372036854775808 ~ 9223372036854775807)
    
    b = -128; 
    b = Byte.MAX_VALUE; // 127. Byte 클래스 블록 안에 선언된 변수
    System.out.println(b);
    
    s = Short.MIN_VALUE;
    System.out.println(s);
    
    i = Integer.MAX_VALUE;
    System.out.println(i);
    
  // i = 100L; // 100L은 8바이트 정수 값을 의미한다.
    
    l = Long.MIN_VALUE; 
    l = Long.MAX_VALUE;
//    l = -9223372036854775809L; // 8byte 정수값의 표현범위를 어겨서 발생하는 오류(out of range)
    l = 9223372036854775807L;
    System.out.println(l);

  }

}
