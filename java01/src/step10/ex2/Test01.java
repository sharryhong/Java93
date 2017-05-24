/* 다형성 - 다형적 변수 
 * => 어떤 레퍼런스 변수는 그 타입의 인스턴스 뿐만 아니라, 
 * 그 타입의 서브 클래스의 인스턴스(의 주소)까지 저장할 수 있다.*/
package step10.ex2;

public class Test01 {

  public static void main(String[] args) {
    /*
    학생 <-- 비트의 회원이다.
    강사 <-- 비트의 회원이다.
    매니저 <-- 비트의 회원이다.
    국비지원수강생 <-- 비트의 회원이다. 특히 학생이다.
    => 이런 상식을 코드로 바꿔보자. 
    */
    Member m = new Member();
    // 한개의 레퍼런스변수가 다양한 객체의 주소를 담을 수 있다. 
    // 물론 서브클래스의 객체주소만 담을 수 있다는 제약이 있다.
//    ==> "다형적 변수(polymorphic variable)"이라고 한다. 
    // 다형성(polymorphism)의 한 개념이다. 
    Member m2 = new Student(); // 부모클래스의 참조변수 m2는 자식클래스의 인스턴스 주소를 담을 수 있다.
    Member m3 = new Teacher();
    Member m4 = new FreeStudent();
    Student s1 = new FreeStudent();
    
//    Student s2 = new Member(); // Error! 서브클래스의 참조변수 s2는 수퍼클래스의 주소를 담을 수 없다. 당연하지 

  }

}
