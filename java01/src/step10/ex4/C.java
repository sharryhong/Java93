package step10.ex4;

public class C extends B {
  int c;
  
  public void m2() {
    System.out.println("C.m2()");
  }
  
  public void m3() {
    System.out.println("C.m3()");
  }
  // 새로 추가 메서드
  public void m5() {
    System.out.println("C.m5()");
  }
  
  public void test1() {
    m1(); // B.m1()
    m2(); // C.m2()
    m3(); // C.m3()
  }
  
  public void test2() {
    super.m1(); // B.m1() // C class에서 재정의하지 않았음. super는 무시
    super.m2(); // B.m2()
    super.m3(); // A.m3()
    m4(); // B.m4() // super안붙으면 현재 클래스부터 찾는다.
    super.m4(); // B.m4() 
//    super.m5(); // Error~! 조상중에 m5메서드가 없다. 
  }
}
