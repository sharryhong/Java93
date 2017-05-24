/* 클래스 메서드들 끼리 호출하기 */
package step07;

public class Test04_9 {
  static class Calculator { 
    
    public static void m1() {
      Calculator.m2(); 
    }
    
    public static void m2() {
      m3(); // Calculator. 자동으로 붙는다. 단, Calculator를 붙이는 것이 클래스 메서드라고 명시적으로 보여주므로 붙이는게 좋다. 
    }
    
    public static void m3() {
      System.out.println("m3()...");
    }

  }

  public static void main(String[] args) {
    Calculator.m1();
  }

}
