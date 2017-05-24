/* 클래스 로딩 절차 */
package step07;

public class Test01_3 {
  static class Student {
    // 클래스 변수
    static String name;
    static int age;
    static boolean working;
  }

  public static void main(String[] args) {
    
    System.out.println(Student.name); // null
    System.out.println(Student.age);  // 0
    System.out.println(Student.working); // false
    
    Student.name = "홍길동";
    Student.age = 20;
    Student.working = true;
    
    System.out.println(Student.name); // 홍길동
    System.out.println(Student.age);  // 20
    System.out.println(Student.working); // true
    
    int a; // 주의! 로컬변수는 0으로 자동초기화 되지 않는다. 
//    System.out.println(a); // 초기화시키지 않고 사용하려하면 컴파일오류!
  }

}
