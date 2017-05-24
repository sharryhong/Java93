package step10.ex4;

public class B extends A {
  int b;
  
  // 수퍼클래스 오버라이딩
  public void m1() { 
    System.out.println("B.m1()");
  }
  //수퍼클래스 오버라이딩
  public void m2() {
    System.out.println("B.m2()");
  }
  // 새로 추가 메서드
  public void m4() {
    System.out.println("B.m4()");
  }
}
