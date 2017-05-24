/* 다형성 - 오버로딩(overloading) */
package step10.ex3;

public class Test02 {

  public static void main(String[] args) {    
    Calculator c1 = new Calculator();
//    c1.plus(20);
//    c1.plus(30);
//    c1.plus(40);
//    c1.plus(50);
    
    int[] values = {20, 30, 40, 50};
    c1.plus(values);
    System.out.println(c1.result);
  }

}
