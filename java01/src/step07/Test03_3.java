/* 초기화 블록 : 생성자 */
package step07;

public class Test03_3 {
  static class Student {
    static String name = "홍길동";
    int age = 20;
    static {
      System.out.println("스태틱 블록 실행");
    } 
    
    { // 인스턴스 블록
      System.out.println("인스턴스 블록 실행");
    }
    // 기본 생성자(default constructor) : 파라미터가 없는 생성자 
    Student() {
      System.out.println("생성자 Student() 호출");
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
