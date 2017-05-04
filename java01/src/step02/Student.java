package step02;

class Student {
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
  public static void print(Student s) {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
  }
}