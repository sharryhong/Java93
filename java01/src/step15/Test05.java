/* 상수 값 다루기 : enum 문법 적용 후 */
package step15;

public class Test05 {

  public static void main(String[] args) {
    Student3 s = new Student3();
    s.setName("홍길동");
    s.setAge(20);
    // 반드시 그 상수 타입의 값을 넣어야 한다. 
    s.setSchoolLevel(SchoolLevel2.MASTER);
    System.out.println(s);
    System.out.println(s.getSchoolLevel().value()); // 3 // DB에 넣을 값
  }
}
