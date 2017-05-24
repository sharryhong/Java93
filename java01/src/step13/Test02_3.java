/* nested class
 * static nested class 를 주로 사용하는 경우 
 * => 계층 구조로 상수 값을 관리하고 싶을 때
 * 특히 안드로이드 프로그래밍에서 ID값을 관리하기 위해 이 문법을 사용한다. 
s */
package step13;

public class Test02_3 {
 
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }

  public static void main(String[] args) {
    // static nested class로 정의된 상수 값 사용하기
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "111-1111";
    m.schoolLevel = Constants.school.BACHELOR;
    m.userType = Constants.userType.TEACHER;
    m.working = Constants.work.NOT_WORKING;
    m.language = Constants.lang.JAVA; 
  }

}
