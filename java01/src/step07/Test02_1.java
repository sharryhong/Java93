/* 인스턴스 변수 */
package step07;

public class Test02_1 {
  static class Student {
    // 인스턴스 변수
    // 사실 이 자체가 인스턴스 변수가 아니라, 클래스를 로딩한 후 메모리를 만들라는 명령어이다.
    // 예) int a; 이게 변수가 아니다! 메모리를 준비하라는 명령어임을 잊지말자. 
    String name; // new 명령어를 실행할 때 Heap에 변수를 만들라는 명령
    int age;
    boolean working;
  }

  public static void main(String[] args) {
//    Student s; // 항상 로컬변수는 값을 설정한 다음에 사용해야 한다. 
    Student s1 = new Student(); // class파일 로딩, class의 설계도에 따라 메모리 만듬 
    Student s2 = new Student(); // class파일 이미 로딩되었으므로 재로딩은 하지않고, class의 설계도에 따라 메모리 만듬
    System.out.println(s1.name); // null
    System.out.println(s1.age);  // 0
    System.out.println(s1.working); // false
    
    s1.name = "홍길동";
    s1.age = 20;
    s1.working = true;
    
    System.out.println(s1.name); // 홍길동
    System.out.println(s1.age);  // 20
    System.out.println(s1.working); // true
    
    System.out.println(s2.name); // null
    System.out.println(s2.age);  // 0
    System.out.println(s2.working); // false

  }

}
