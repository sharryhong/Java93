package step06;

class Member2 {

  String name;
  int[] scores = new int[3];
  int total;
  float aver;
    
  public static void init(Member2 m, String name, int kor, int eng, int math) {
    m.name = name;
    m.scores[0] = kor;
    m.scores[1] = eng;
    m.scores[2] = math;
  }
  
  public static void compute(Member2 m) {
    m.total = m.scores[0] + m.scores[1] + m.scores[2];
    m.aver = m.total / 3f;
  }
  
  public static void print(Member2 m) {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", m.name, m.scores[0], m.scores[1], m.scores[2], m.total, m.aver);    
  }
}
