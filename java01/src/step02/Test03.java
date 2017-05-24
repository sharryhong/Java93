/* 변수 선언 : 부동소수점 변수 
 */
package step02;

public class Test03 {

  public static void main(String[] args) {
    float f;     // 4
    double d;    // 8
    
    f = Float.MAX_VALUE;
    System.out.println(f);
    
    f = 9.999999f; // 유효자릿수 7자리
    System.out.println(f);
    
    f = 99999.999f; // 유효자릿수 넘기면? 값이 짤리거나 반올림 한다. 
    System.out.println(f);
    
    f = 3.14141414141414f; // 8번째 자리에서 다른 값이 나올수있으므로 유효자릿수가 7자리이다. 
    System.out.println(f);
    
    d = 3.14141414141414f; // f를 붙이면 이미 float으로 표현(4바이트)하므로 이미 값이 짤린다. 조심! 
    System.out.println(d);
    
    d = 3.14141414141414; // 붙이지말거나 d를 붙이자. 
    System.out.println(d);
  }

}
