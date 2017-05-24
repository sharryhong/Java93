/* 산술연산자 
 * 정수 연산의 최소 단위는 int */
package step03;

public class Test01_2 {

  public static void main(String[] args) {
    byte b1 = 10;
    byte b2 = 20; 
    byte b3 = 10 + 20;
    System.out.println(b3);
    /* 상수와 상수의 연산 결과는 상수이다.
     * 
     */
//    byte b33 = 10 + 118; // 상수 값을 메모리에 담을 수 없어서 컴파일 오류!
    
    /* 변수와 변수, 변수와 상수의 연산 결과는 변수
     * 변수 연산의 최소 단위는 int 
     */
//    byte b4 = b1 + b2; // 컴파일 오류! b1는 1byte, + 연산의 최소 단위는 4byte
//    byte b5 = b1 + 20; // 컴파일 오류!
//    byte b6 = 10 + b2; // 컴파일 오류!
    /*
     * 변수의 값 계산시 법칙 : 암시적 형변환
     */
    int i1 = 10;
    long l1 = 20;
    
//    int i2 = i1 + l1; // error!
    long l2 = i1 + l1; // ok!
    
    float f1 = 10.0f;
//    long l3 = f1 + l1; // error! 연산결과는 float
    float f2 = f1 + l1; // ok! 
    
    float f3 = l1 + l2; // long + long = long ---> float으로 저장할 수 있다. 그러나 값이 짤릴 수 있다. 
  }

}
