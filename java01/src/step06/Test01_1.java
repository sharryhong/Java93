/* 객체지향 프로그래밍(Object-Oriented Programming; OOP) 
 * class */ 

package step06;

public class Test01_1 {
  // 1) 사용자 정의 데이터 타입 만들기
  static class Student {
    String name;
    int[] scores = new int[3];
    int total;
    float aver;
  }
  
  public static void main(String[] args) {
    // 2) 사용자 정의 데이터 타입으로 메모리 준비하기
    Student s; // <== 메모리의 주소를 담을 변수 = "레퍼런스(reference)"
    s = new Student(); // <== Student 설계도에 따라 힙에 메모리를 준비시킨다. 
                       // 이렇게 준비된 메모리를 "인스턴스(instance)"라고 부른다.
                       // 현장에서는 보통 그냥 "객체"라고 부른다. 
    // 3) 인스턴스에 값 넣기 => 레퍼런스.변수명 = 값  
    s.name = "홍길동";
    s.scores[0] = 100;
    s.scores[1] = 90;
    s.scores[2] = 80;
    s.total = s.scores[0] + s.scores[1] + s.scores[2];
    s.aver = s.total / 3f;
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
  }

}
