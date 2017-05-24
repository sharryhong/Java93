package step10.ex1;

public class Student {
  String name;
  int age;
  
  void print() {
    System.out.printf("> 이름: %s\n", name); // Student.this.name인데 생략한거야~(어제배움)
    System.out.printf("> 나이: %d\n", age);
  }
}
