package step10.ex5;

public class C extends B {
  public void m1() { // 오버라이딩
    System.out.println("C.m1()...");
  }
  
  @Override  // 이걸 붙이면 자바 컴파일러가 체크해준다. 
             // 만약에 실수로 메서드이름 잘못쓸 경우 에러. 실수 예방
  // 애너테이션 : 자바 컴파일러에게 전달하는 특별한 주석. 오버라이딩 여부 검사하라는 명령
  public void m2() { // 오버라이딩
    System.out.println("C.m2()...");
  }
}
