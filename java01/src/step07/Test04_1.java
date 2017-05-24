/* 인스턴스 변수와 인스턴스 메서드 */
package step07;

public class Test04_1 {
  static class Calculator {
    int result;
    
    // 인스턴스 메서드
    public void plus(int value) {
      this.result += value;
    }
    public void minus(int value) {
      this.result -= value;
    }

  }

  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    c1.plus(10);
    c2.plus(20);
    System.out.println(c1.result);
  }

}
