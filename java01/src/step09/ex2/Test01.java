/* 상속 문법을 사용하기 전 1 */
package step09.ex2;

public class Test01 {
  public static void main(String[] args) {
    BasicCalculator calc = new BasicCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    System.out.println(calc.result);
  }
}
