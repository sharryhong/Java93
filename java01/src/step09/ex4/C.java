package step09.ex4;

public class C extends B {
  int c;
  
  public C() {
//    super(); // 생략시 수퍼클래스의 기본생성자를 호출하는데, B클래스에는 기본 생성자가 없다. 컴파일 오류!
    
    // 해결방법? 수퍼클래스의 생성자를 호출하라. 
    super(5); // int값 받는 생성자 있으므로
    System.out.println("C() 호출");
  }
}
