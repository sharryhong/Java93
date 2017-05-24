/* 클래스 변수와 인스턴스 메서드 2 */
package step07;

public class Test04_7 {
  static class Calculator extends java.lang.Object { // extends java.lang.Object가 생략되어있는것이다. 자동 상속됨
    static int result; 
    
    public void plus(int value) {
      this.result += value; // 클래스명 대신 this 사용 가능. 
      // 다만 this다음에 변수명을 주면 인스턴스 변수라고 오해할 가능성이 높다. 따라서 실무에서는 this를 통해 클래스변수를 사용하지 말라.
      // 인스턴스에 result라는 변수가 없으면 자동으로 클래스변수를 찾는다. 그래서 오류는 아니지만 ㅋㅋㅋ 빅 똥임 
    }
    public void minus(int value) { 
      // 인스턴스 메서드에서 로컬변수가 아닌경우, 변수명앞에 this를 자동으로 붙인다.
      // 문법 허용이유?
      result -= value; 
//      Calculator.this.result 
    }

  }

  public static void main(String[] args) {
    Calculator c = new Calculator(); // 인스턴스 메서드는 반드시 new로서 인스턴스를 생성해야 존재한다. 
    // 자바의 모든 클래스는 Object를 상속받는다. 따라서 new Calculator()를 하면 무조건 인스턴스 변수가 있다.  
    c.plus(10);
//    Calculator.plus(20); // 컴파일 에러! static이 아닌 메소드, 즉 인스턴스 메서드는 반드시 인스턴스 주소를 줘야한다. 
    System.out.println(Calculator.result);
    c.minus(5);
    System.out.println(Calculator.result);
  }

}
