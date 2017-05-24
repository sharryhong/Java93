/* 인스턴스 메서드들 끼리 호출하기 */
package step07;

public class Test04_10 {
    
  static class Calculator {
    int value;
    
    // 생성자
    Calculator(int value) {
      this.value = value;
    }
    
    public void m1() {
      Calculator.this.m2(); 
      System.out.println(this);
    }
    
    public void m2() {
      m3(); // Calculator.this. 자동으로 붙는다.
      // 모든 인스턴스 변수는 인스턴스 주소를 앞에 줘야한다. 지금은 생략한것임 
    }
    
    public void m3() {
//      System.out.println(Calculator.this.value);
      System.out.println(value); // Calculator.this 생략
    }

  }

  public static void main(String[] args) {
    // 인스턴스 메서드를 호출하려면 반드시 인스턴스가 있어야한다.
    Calculator c1 = new Calculator(100);
    Calculator c2 = new Calculator(200);
    Calculator c3 = new Calculator(300);
    c1.m1();
    c2.m1();
    c3.m1();
  }

}
