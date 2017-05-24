/* 초기화 블록 : static block */
package step07;

public class Test03_1 {
  static class Student {
    static String name = "홍길동"; // 초기화 문장. 변수 선언에 값을 초기화시키는 문장 포함
    static {
      System.out.println(name);
      System.out.println("static...1");
      name = "임꺽정";
      System.out.println(name);
    } 
    // 스테틱 블록은 여러개 해도 상관없다. 
    static {
      System.out.println(name);
      System.out.println("static...2");
      name ="유관순";
      System.out.println(name);
    }
  }

  public static void main(String[] args) {
    // 클래스가 로딩되면 static변수는 자동으로 준비된다. 
    Student.name = "하하하"; 
    // name은 Student class변수일 것이다.
    // role을 깨트리지 말자. 만약 소문자 student라면 class라고 생각못하고 레퍼런스 변수라고 생각할 수도 있을 것이다. 
    System.out.println(Student.name);
  }

}
