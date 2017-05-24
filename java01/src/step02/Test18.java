/* 변수 선언 : 블록과 변수의 범위 */
package step02;

//public int i = 100; // Error! 클래스 밖에 명령어를 작성할 수 없다. C에서는 글로벌변수로 가능
public class Test18 {
  
  static int a = 10; // 클래스 안에서 무제한 사용."클래스 변수(class variable)"라 부른다. 

  public static void main(String[] args) {
    System.out.println(a); // 10
    m1(30);
    System.out.println(a); // 200
    
    int b = 20; // main() 메서드 안에서 사용. 로컬 변수라 부른다. 
    
  }
  
  // c, d : m1()메서드 호출시에 로컬변수 생성되고, 호출이 끝나면 사라지는 변수
  public static void m1(int c) { // c는 m1() 메서드 안에서 사용. 로컬 변수. 
    // 로컬 변수 중에서 메서드를 호출할 때 넘겨주는 값을 받는 로컬 변수를 "파라미터(parameter)"라 부른다. 

//    d = 50; // Java는 호이스팅(hoisting)을 지원하지 않아 컴파일 오류! 선언을 먼저 해야한다. 
    int d = 40; // 그냥 로컬 변수. m1() 메서드 안에서만 사용
    a = 200;
  }

}
