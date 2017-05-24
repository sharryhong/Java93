/* 상속 문법을 사용한 후 3 */
package step09.ex2;

public class Test03 {
  public static void main(String[] args) {
    MasterCalculator calc = new MasterCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    calc.multiple(2);
    calc.divide(3);
    System.out.println(calc.result);
  }
}
