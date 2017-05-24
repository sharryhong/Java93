/* 유틸리티 클래스 : Object - toString()
 * => 원본과 재정의 */ 
package step08;

public class Test03_2 {
  
  static class Student1 {
    String name;
    int age;
    
    // toString() 재정의 하기 전
    
  }

  static class Student2 {
    String name;
    int age;
    
    // toString() 재정의 : 오버라이딩
    public String toString() {
      return String.format("이름: %s\n나이: %d\n", name, age);
    }
  }
  
  public static void main(String[] args) {
    Student1 s1 = new Student1();
    s1.name = "임꺽정";
    s1.age = 30;
    System.out.println(s1.toString()); // 오리지널(super class인 Object의) toString() 호출
    
    Student2 s2 = new Student2();
    s2.name = "임꺽정";
    s2.age = 30;
    System.out.println(s2.toString()); // 재정의한 toString() 호출
  }

}
