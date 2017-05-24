package step06;

// 
class Student3 {
  String name;
  int[] scores = new int[3];
  int total;
  float aver;
  
  // "생성자(constructor)"
  // 
  public Student3(String name, int kor, int eng, int math) {
    this.name = name;
    this.scores[0] = kor;
    this.scores[1] = eng;
    this.scores[2] = math;
  }
  
  public void compute() {
    this.total = this.scores[0] + this.scores[1] + this.scores[2];
    this.aver = this.total / 3f;
  }
  
  public void print() {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        this.name, this.scores[0], this.scores[1], this.scores[2], this.total, this.aver);    
  }
}
