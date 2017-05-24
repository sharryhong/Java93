package step09.ex4;

public class B extends A {
  int b;
  
  public B(int value) { // 기본 생성자를 없애면?
//    super();
    System.out.printf("B() 호출 %d\n", value);
  }
}
