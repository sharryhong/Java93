/* 상수 값 다루기 : enum 타입과 객체 그리고 메서드들 */
package step15;

public class Test04 {

  public static void main(String[] args) {
   
    // enum 객체의 기본 값
//    SchoolLevel.values(); // 값들의 목록 리턴
    SchoolLevel2[] values = SchoolLevel2.values();
    for (SchoolLevel2 sl : values) {
      System.out.printf("name() = %s\n", sl.name()); // ex) DOCTOR // 상수이름
      System.out.printf("toString() = %s\n", sl.toString()); // ex) DOCTOR
      System.out.printf("ordinal() = %s\n", sl.ordinal()); // ex) 3 // 순서 (0부터)
      System.out.printf("value() = %d\n", sl.value()); // SchoolLevel2에 추가한 value()함수호출, 보관된 값꺼냄
    }
  }
}
