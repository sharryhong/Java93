/* 변수 선언 : 자바의 원시 데이터 타입*/
package step02;

public class Test01 {

  public static void main(String[] args) {
    
    // Java의 최소 단위 메모리 : primitive data type(원시타입 = 기본타입) 
    // 1~4) 8개의 원시타입 + 나머지는 레퍼런스 타입 
    
    // 1) 정수 변수 : 정수 값을 저장할 때 사용하는 메모리
    byte b;      // 1byte크기의 메모리
    short s;     // 2
    int i;       // 4
    long l;      // 8
    
    // 2) 부동소수점 변수 : 부동소수점 값을 저장할 때 사용하는 메모리
    float f;     // 4
    double d;    // 8
    
    // 3) 문자 변수 : 문자의 유니코드 값을 저장할 때 사용하는 메모리
    char c;      // 2
    
    // 4) 논리값 변수 : 논리 값을 저장할 때 사용하는 메모리
    boolean bool; // Java language명세서에서 크기를 알려주지 않는다. 
      // 다만, JVM 명세서에서 4byte 정수 값을 담는 메모리를 사용한다고 언급하고 있다. 
      // 다만, 배열에서는 1byte 메모리를 사용한다고 설명하고 있다. 
    
    // 5) 레퍼런스 변수
    Object obj;
    String str;
    Thread thread;

  }

}
