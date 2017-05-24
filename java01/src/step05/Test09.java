/* 메서드 : 사용자 정의 타입과 힙(heap) 메모리  
 * 
 */
package step05;

public class Test09 {
  static class Student {
    String name;
    int age;
    boolean working;
    int[] scores;
  }
  
  // Student의 인스턴스 주소를 리턴한다. 오로지 인스턴스의 주소만 넘기고 리턴받는 것을 유의하자. 
  public static Student createStudent() {
    Student s = new Student();
    s.name = "홍길동";
    s.age = 20;
    s.working = false;
    s.scores = new int[]{100, 90, 90};
    return s;
  }
  
  public static void main(String[] args) {
    Student s = createStudent();
    System.out.printf("이름=%s\n", s.name);
    System.out.printf("나이=%d\n", s.age);
    System.out.printf("재직여부=%b\n", s.working);
    System.out.printf("점수=%d, %d, %d\n", s.scores[0], s.scores[1], s.scores[2]);
  }
}

