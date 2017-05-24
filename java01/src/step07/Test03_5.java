/* 초기화 블록 : 생성자 3 여러개의 생성자 중에서 호출될 생성자를 지정하기 */
package step07;

public class Test03_5 {
  static class Student {
    int age = 20;
    // 기본 생성자(default constructor) : 파라미터가 없는 생성자 
    Student() {
      System.out.println("Student()... 호출");
    }
    
    Student(int a) {
      System.out.println("Student(int)... 호출");
      this.age = a;
    }
    
//    Student(int b) { // 변수명이 다른 것은 상관없다. 파라미터 타입과 개수가 중요하다. 
//      System.out.println("Student(int b)... 호출");
//      this.age = b;
//    }
    
    Student(int a, String n) {
      System.out.println("Student(int, String)... 호출");
      this.age = a;
    }
    
    Student(String n, int a) {
      System.out.println("Student(String, int)... 호출");
      this.age = a;
    }

  }

  public static void main(String[] args) {
    // 호출될 생성자는 넘겨주는 값의 개수와 타입으로 결정된다. 
    new Student();
    new Student(20);
//    new Student(20L); // long 값을 받는 생성자가 없다. 컴파일 오류!
    new Student("홍길동", 20);
    new Student(20, "홍길동");
  }

}
