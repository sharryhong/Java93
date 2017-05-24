/* 인스턴스 메서드와 this 변수 2 */
package step07;

public class Test04_3 {
  static class Calculator {
    int result;
    
    Calculator(int value) {
      Calculator.this.result = value; // 원래 full set 문법 
    }
    public void plus(int value) {
      result += value;
    }
    public void minus(int result) { // 파라미터 변수 result
      this.result -= result; // this.result는 인스턴스 변수. 이렇게 헷갈릴때는 this를 써야한다. 
    }

  }

  public static void main(String[] args) {
    Calculator c1 = new Calculator(5);
    Calculator c2 = new Calculator(5);
    c1.plus(10);
    c2.plus(20);
    System.out.println(c1.result);
    System.out.println(c2.result);
  }

}
