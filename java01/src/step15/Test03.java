/* 상수 값 다루기 : enum 타입과 객체 그리고 메서드들 */
package step15;

public class Test03 {

  public static void main(String[] args) {
   
    // enum 객체의 기본 값
//    SchoolLevel.values(); // 값들의 목록 리턴
    SchoolLevel[] values = SchoolLevel.values();
    for (SchoolLevel value : values) {
      System.out.printf("name() = %s\n", value.name()); // ex) DOCTOR // 상수이름
      System.out.printf("toString() = %s\n", value.toString()); // ex) DOCTOR
      System.out.printf("ordinal() = %s\n", value.ordinal()); // ex) 3 // 순서 (0부터)
    }
  }
}
