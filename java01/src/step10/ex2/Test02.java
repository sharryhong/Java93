/* 다형성 - 다형적 변수 2 
 * => 왜 수퍼클래스의 인스턴스를 저장할 수 없는가? */
package step10.ex2;

public class Test02 {

  public static void main(String[] args) {
//    Member m = new Member(); // OK!
//    Member m = new Student(); // OK!
    Member m = new FreeStudent(); // OK!
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";
    m.tel = "111-1111";
    m.email = "hong@test.com";
    
//    Student s = new Student(); // OK! 
    Student s = new FreeStudent(); // OK! 항상 서브클래스에는 수퍼클래스보다 더 갖고있다. 
//    Student s = new Member(); // Error!!! 
      // new Member() 로 생성되는 변수는 Member변수밖에 없다. 
      // Student 클래스가 원하는 변수, 메서드 등이 없다.
    s.name = "홍길동";
    s.id = "hong";
    s.password = "1111";
    s.tel = "111-1111";
    s.email = "hong@test.com";
    s.schoolName = "비트대학교";
    s.grade = 4;
    
  }

}
