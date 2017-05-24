/* 상속 문법을 사용한 후 2
 * 1) 새 클래스를 만들어 기능을 추가하자. 
 * 2) BasicCalculator의 기능을 사용하겠다고 선언한다. */
package step09.ex2;

public class Test02 {
  public static void main(String[] args) {
    AdvancedCalculator calc = new AdvancedCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    calc.multiple(2);
    System.out.println(calc.result);
  }
}
