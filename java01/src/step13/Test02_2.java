/* nested class
 * static nested class 를 주로 사용하는 경우 
 * => 계층 구조로 상수 값을 관리하고 싶을 때
 * 특히 안드로이드 프로그래밍에서 ID값을 관리하기 위해 이 문법을 사용한다. 
s */
package step13;

public class Test02_2 {
 
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }

  public static void main(String[] args) {
    // static nested class 적용 전 : 일반 클래스로 만든 상수 값을 사용해보자.
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "111-1111";
    m.schoolLevel = CSchool.BACHELOR;
    m.userType = CUserType.TEACHER;
    m.working = CWork.NOT_WORKING;
    m.language = CLanguage.JAVA;
    // 위처럼 상수 사용 이유 : 실제 DB에는 숫자가 들어간다. 소스코드 읽기 쉽다. 
  }

}
