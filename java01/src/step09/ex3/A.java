package step09.ex3;

public class A {
  int a;
  
  public A() {
    // 첫 명령어로 이 클래스의 수퍼클래스 생성자를 호출하는 코드를 작성해야한다. 
//    int a;// 만약 super();보다 더 먼저 다른 명령이 있다면 컴파일 오류. 
    super(); // 생략하면 컴파일러가 수퍼클래스의 기본생성자 호출 => step09/ex4에서 증명
    System.out.println("A() 호출");
  }
}
