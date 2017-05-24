package step06;

class Member {

  static String name;
  static int[] scores = new int[3];
  static int total;
  static float aver;
    
  public static void init(String n, int k, int e, int m) {
    name = n;
    scores[0] = k;
    scores[1] = e;
    scores[2] = m;
  }
  
  public static void compute() {
    total = scores[0] + scores[1] + scores[2];
    aver = total / 3f;
  }
  
  public static void print() {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", name, scores[0], scores[1], scores[2], total, aver);    
  }
}
