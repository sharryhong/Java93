/* 초기화 블록 : 생성자 2 */
package step07;

public class Test03_4 {
  static class Student {
    int age = 20;
    // 기본 생성자(default constructor) : 파라미터가 없는 생성자 
    Student() {
      System.out.println("기본 생성자 Student() 호출");
    }
  }
  
  static class Student2 {
    int age = 20;
    // 생성자를 작성하지 않으면 다음과 같은 기본 생성자가 자동으로 추가된다.
    // 즉, 생성자 없는 class는 Java의 세계에서 존재 하지 않는다. 
//    Student2() {}
  }

  public static void main(String[] args) {
    // 인스턴스 생성시 호출될 생성자를 지정하지 않으면 컴파일 오류!
//    new Student;
    // 존재하는 기본 생성자 호출
    new Student(); 
    // 컴파일러가 자동으로 추가한 기본 생성자 호출
    new Student2();
    // 주어진 값을 받을 수 있는 생성자가 존재하지 않을 때 컴파일 오류!
//    new Student(20);
  }

}
