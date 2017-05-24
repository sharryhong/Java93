/* 인스턴스 변수와 클래스 메서드 */
package step07;

public class Test04_8 {
  static class Calculator { 
    int result; 
    
    public static void plus(int value) {
      // 
//      Calculator.this.result += value; // 컴파일 오류!  
    }
    public static void minus(int value) { 
//      result -= value; 
    }

  }

  public static void main(String[] args) {
//    Calculator.plus(10); 
  }

}
