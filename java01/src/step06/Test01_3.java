/* class 문법의 용도 3 */ 

package step06;

public class Test01_3 {

  static class Student {
    String name;
    int[] scores = new int[3];
    int total;
    float aver;
    
    // "클래스 메서드(=스테틱 메서드)"
    public static void init(Student s, String name, int kor, int eng, int math) {
      s.name = name;
      s.scores[0] = kor;
      s.scores[1] = eng;
      s.scores[2] = math;
    }
    
    public static void compute(Student s) {
      s.total = s.scores[0] + s.scores[1] + s.scores[2];
      s.aver = s.total / 3f;
    }
    
    public static void print(Student s) {
      System.out.printf("%s, %d, %d, %d, %d, %f\n", s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);    
    }
  }
  
  public static void main(String[] args) {
    Student s1 = new Student(); 
    Student.init(s1, "홍길동", 100, 100, 100);
    Student.compute(s1);
    
    Student s2 = new Student();
    Student.init(s2, "임꺽정", 90, 90, 90);
    Student.compute(s2);
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    
    Student.print(s1);
    Student.print(s2);
    Student.print(s3);
  }

}
