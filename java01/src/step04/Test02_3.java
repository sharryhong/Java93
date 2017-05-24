/* 문장 : 조건문 switch - 사용 가능한 값 */
package step04;

public class Test02_3 {
  // enum 문법(enumeration, 열거형) : 상수 값을 그룹으로 묶어서 쉽게 선언하는 방법
  enum Level {
    GUEST, MEMBER, ADMIN;
  }

  public static void main(String[] args) {
    byte b = 10;
    short s = 10;
    int i = 10;
    long l = 10;
    float f = 10f;
    double d = 10.0;
    boolean bool = true;
    char c = '가';
    String str = "오호라";
    
    // 4byte 크기의 정수 값 가능
    switch (b) {}
    switch (s) {}
    switch (i) {}
//    switch (l) {} // l은 8byte 크기라서 안됨. int와 호환되는 값만 가능
//    switch (f) {} // 부동소수점 안됨
//    switch (d) {} // 부동소수점 안됨
//    switch (bool) {} // boolean값 안됨
    switch (c) {} // char는 0 ~ 65535까지의 값을 갖는 정수형이라 가능 
    
    // 문자열 (java 1.7부터 가능)
    switch (str) {}
    
    // enum 타입(enumeration, 열거형) 가능 => 4 바이트 정수 값이다. 
    switch (Level.GUEST) {}
    

  }

}
