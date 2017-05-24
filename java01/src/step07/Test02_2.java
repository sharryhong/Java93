/* 인스턴스 변수와 클래스 변수 */
package step07;

public class Test02_2 {
  static class Student {
    // 클래스 변수 : 클래스가 로딩된 후 자동으로 Method Area에 생성됨 
    static int guest = 0;
    static int member = 1;
    static int admin = 2;

    // 인스턴스 변수 : new 명령을 실행할 때 생성됨
    String name; 
    int age;
    boolean working;
    int level;
  }

  public static void main(String[] args) {

    Student s1 = new Student(); 
    Student s2 = new Student(); 
    
    s1.name = "홍길동";
    s1.age = 20;
    s1.working = true;
    s1.level = Student.guest; // s1.quest라고 해도 되지만, guest는 클래스 변수이므로 Student.guest로 적도록한다. 
    
    s2.name = "임꺽정";
    s2.age = 30;
    s2.working = true;
    s2.level = Student.admin;

    System.out.println(s1.name); 
    System.out.println(s1.age); 
    System.out.println(s1.working);
    System.out.println(s1.level);
    
    System.out.println(s2.name); 
    System.out.println(s2.age); 
    System.out.println(s2.working);
    System.out.println(s2.level);
  }

}
