/* 캡슐화(encapsulation): 기본 접근 제어 범위
 => 기본 : 같은 패키지에 있는 클래스의 접근을 허용한다. */
package step11;

public class Test01 {

  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    c.plus(7);
    c.minus(3);
    
    // 치명적인 문제!
    // => 외부에서 result 접근 가능 
//    c.result = 1000; 
    
    // => 해결책? 외부에서 직접 접근할 수 없게 하기
    System.out.println(c.result);

  }

}
