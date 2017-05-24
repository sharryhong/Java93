/* 초기화 블록 : 인스턴스 블록 */
package step07;

public class Test03_2 {
  static class Student {
    static String name = "홍길동"; // 초기화 문장. 변수 선언에 값을 초기화시키는 문장 포함
    int age = 20;
    static {
      System.out.println("스태틱 블록 실행");
    } 
    
    { // 인스턴스 블록
      // 인스턴스 주소를 보관한 this라는 변수가 내장되어 있다.
      System.out.println(age);
      System.out.println("인스턴스 블록 실행 1");
      this.age = 30;
    }
    
    {
      System.out.println(age);
      System.out.println("인스턴스 블록 실행 2");
    }

  }

  public static void main(String[] args) {
//    Student.class로딩, 
    // 스태틱블록은 1번만 실행되고
    new Student(); // 인스턴스를 만들었다고해서 꼭 주소를 받아야하는 것은 아니다. 지금의 경우 주소를 받아서 쓰지 않으므로 굳이 주소를 받지 않았다. 
    // 인스턴스 변수를 heap에 만든다.  
    // 인스턴스블록 순서대로 실행
    System.out.println("--------------------------");
    new Student(); 
    // 인스턴스 변수를 heap에 만든다.  
    // 인스턴스블록 순서대로 실행
  }

}
