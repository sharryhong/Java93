/* 클래스 변수와 인스턴스 메서드 */
package step07;

public class Test04_6 {
  static class Calculator extends java.lang.Object { // extends java.lang.Object가 생략되어있는것이다. 자동 상속됨
    static int result; 
    
    // 인스턴스 메서드
    // 인스턴스가 만들어졌다는 것은 class가 존재한다는 뜻. 따라서 클래스 변수가 존재한다. 
    // 따라서 안전하게 클래스 변수를 사용할 수 있다. 
    public void plus(int value) {
      Calculator.result += value; 
    }
    public void minus(int value) { 
      Calculator.result -= value; 
    }

  }

  public static void main(String[] args) {
    Calculator c = new Calculator(); // 인스턴스 메서드는 반드시 new로서 인스턴스를 생성해야 존재한다. 
    // 자바의 모든 클래스는 Object를 상속받는다. 따라서 new Calculator()를 하면 무조건 인스턴스 변수가 있다.  
    c.plus(10);
//    Calculator.plus(20); // 컴파일 에러! static이 아닌 메소드, 즉 인스턴스 메서드는 반드시 인스턴스 주소를 줘야한다. 
    System.out.println(Calculator.result);
  }

}
