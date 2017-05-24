/* 클래스 변수와 클래스 메서드 2 */
package step07;

public class Test04_5 {
  static class Calculator {
    static int result; 
    
    // 클래스 메서드
    public static void plus(int value) {
      // Calculator 클래스 변수 result. 기본값 0으로 세팅
      result += value; // 로컬변수가 헷갈리지 않는다면 클래스명 생략 
    }
    public static void minus(int result) { 
      Calculator.result -= result; // 파라미터와 헷갈리므로 클래스명 적어야한다. 
    }

  }

  public static void main(String[] args) {
    Calculator.plus(10);
    System.out.println(Calculator.result);
    Calculator.minus(5);
    System.out.println(Calculator.result);
  }

}
