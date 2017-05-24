/* 클래스 로딩과 클래스 변수 */
package step07;

public class Test01_2 {
  // 클래스 변수 
  static class Student {
    static String name;
    static int age;
    static boolean working;
    
    static void m1() {
      
    }
  }

  public static void main(String[] args) {
    // 클래스 로딩 시점을 확인하자!
    // 1) 레퍼런스 변수를 만들 때? NO!
    Student s;
    
    // 2) 클래스 변수를 사용할 때? YES! 
//    System.out.println(Student.name);
    
    // 3) 클래스 메서드를 호출할 때? YES!
//    Student.m1();
    
    // 4) new 명령을 사용할 때? YES!
    new Student();

  }

}
