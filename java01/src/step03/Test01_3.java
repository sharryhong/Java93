/* 산술연산자 
 * 정수 연산의 최소 단위는 int */
package step03;

public class Test01_3 {

  public static void main(String[] args) {
    int a = 5;
    int b = 2;
    float f = a / b; // int 변수들의 연산결과는 int. 2.5가 아닌 2  
    System.out.println(f); // 2.0
    
    // 1) 명시적 형변환 사용
    float f2 = (float)a / (float)b; // float 변수들의 연산결과는 float
    System.out.println(f2); // 2.5
    
    // 2) 명시적 형변환과 암시적 형변환을 함께 이용
    float f3 = (float)a / b; // float / int = (float) / (float)
    System.out.println(f3); // 2.5
    
    float f4 = a / (float)b;
    System.out.println(f4);
    
  }

}
