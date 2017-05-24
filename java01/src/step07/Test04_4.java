/* 클래스 변수와 클래스 메서드 */
package step07;

public class Test04_4 {
  static class Calculator {
    static int result; 
    
    // 클래스 메서드
    public static void plus(int value) {
      // Calculator 클래스 변수 result. 기본값 0으로 세팅
      Calculator.result += value;
    }
    public static void minus(int value) { 
      Calculator.result -= value; 
    }

  }

  public static void main(String[] args) {
    Calculator.plus(10);
    System.out.println(Calculator.result);
  }

}
