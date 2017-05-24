/* 다형성 - 다형적 변수와 instanceof 연산자 
 * => instanceof 연산자는 레퍼런스에 들어있는 인스턴스가 어떤 클래스의 인스턴스인지 검사한다. */
package step10.ex2;

public class Test04 {

  public static void main(String[] args) {

    checkReference(new Member()); // Member의 인스턴스이다.
    checkReference(new Student()); // Member의 인스턴스이다. Student의 인스턴스이다.
    checkReference(new Manager()); // Member의 인스턴스이다. Manager의 인스턴스이다.
    checkReference(new Teacher()); // Member의 인스턴스이다. Teacher의 인스턴스이다.
    checkReference(new FreeStudent()); // Member의 인스턴스이다. Student의 인스턴스이다. FreeStudent의 인스턴스이다.
  }
  
  static void checkReference(Object obj) {
    if (obj instanceof Member) System.out.println("Member의 인스턴스이다.");
    if (obj instanceof Student) System.out.println("Student의 인스턴스이다.");
    if (obj instanceof Manager) System.out.println("Manager의 인스턴스이다.");
    if (obj instanceof Teacher) System.out.println("Teacher의 인스턴스이다.");
    if (obj instanceof FreeStudent) System.out.println("FreeStudent의 인스턴스이다.");
    System.out.println("------------------------");
  }

}
