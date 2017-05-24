package step10.ex1;

public class BitStudent extends Student {
  String school;
  
  // 상속받은 print()메서드에는 school을 출력하는 기능이 없다.
  // 서브클래스의 역할에 맞게끔 재정의한다. 
  // 수퍼클래스의 명령어와 같이 실행되므로 Heap메모리에 name, age, school이 같이 만들어져서 사용하는 것이다. 
//  void print() {
//    // 이렇게 수퍼클래스의 메서드를 재정의할때 기존코드를 복붙하기대신 기존 메서드를 호출하는 것이 편하다. 
//    System.out.printf("이름: %s\n", name);
//    System.out.printf("나이: %d\n", age);
//    System.out.printf("학교: %s\n", school);
//  }
  
  // 이렇게 하자.
  void print() {
    // 재정의 하기 전의 메서드를 가리키기 위해, super라는 키워드를 사용하여 메서드를 호출한다.  
    // 주의! 수퍼 클래스라는 의미가 아니다. 즉, super가 Student class가 아니다. 
    super.print(); // 이 클래스에서 재정의하기 전의 print() 메서드를 호출하라.
    System.out.printf("> 학교: %s\n", school);
  }
}
