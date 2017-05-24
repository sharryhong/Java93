/* 다형성 - 오버로딩(overloading) */
package step10.ex3;

public class Test01 {

  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    c1.plus(1);
    c1.plus(2);
    c1.plus(10, 7);

    System.out.println(c1.result);
  }

}
