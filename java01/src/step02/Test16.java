/* 사용자 정의 데이터 타입 : 생성자 */
package step02;

public class Test16 {
  
  //
  static class Student {
    String name;
    int[] scores;
    int total;
    float aver;
    
    // 
    Student(String name, int kor, int eng, int math) {
      // 
      this.name = name;
      this.scores = new int[]{kor, eng, math};
      this.total = kor + eng + math;
      this.aver = this.total / 3f;
    }
    
    // 
    public static void printStudent(Student s) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
    }
  }
  public static void main(String[] args) {
     
    Student[] arr1 = new Student[3];

    arr1[0] = new Student("홍길동", 100, 100, 100);
    arr1[1] = new Student("임꺽정", 90, 90, 90);
    arr1[2] = new Student("유관순", 80, 80, 80);
    
    for (int i = 0; i < arr1.length; i++) {
      Student.printStudent(arr1[i]);
    }

  }

}
