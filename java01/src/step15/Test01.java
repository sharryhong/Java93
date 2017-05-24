/* 상수 값 다루기 : enum 문법 적용 전 */
package step15;

public class Test01 {

  public static void main(String[] args) {
    Student s = new Student();
    s.setName("홍길동");
    s.setAge(20);
    // 다음과 같이 상수를 사용하는 것이 코드를 읽을 때 좋다. 
    s.setSchoolLevel(Student.DOCTOR);
    // 물론 어떤 값을 넣어야하는지 알고 있다면 다음과 같이 직접 값을 넣을 수 있다.
    // 문제 : 잘못된 값을 넣을 수 있다. 그래서 가능한한 상수를 사용하도록 하라.
//    s.setSchoolLevel(4);
    System.out.println(s); // = s.toString() // Student Class에서 오버라이딩했음
  }
}
