/* 상수 값 다루기 : enum 문법 적용 후 */
package step15;

public class Test02 {

  public static void main(String[] args) {
    Student2 s = new Student2();
    s.setName("홍길동");
    s.setAge(20);
    // 반드시 그 상수 타입의 값을 넣어야 한다. 
    s.setSchoolLevel(SchoolLevel.DOCTOR);
//    s.setSchoolLevel(4); // Error! 임의의 숫자를 넣을 수 없다.
    System.out.println(s);
    
  }
}
