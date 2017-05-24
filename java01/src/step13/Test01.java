/* nested class(=inner class) 
 * => 클래스나 메서드 안에 클래스를 정의하는 문법 
 * 특정 클래스 안에서만 사용되는 클래스는 클래스 안에 정의한다. 
 * 특정 메서드 안에서만 사용되는 클래스는 클래스 안에 정의한다. 
 * => 종류
 * 1) static nested class
 * 2) (non-static) nested class = inner class
 * 3) local class
 * 4) anonymous(익명) class */
package step13;

// package member class
public class Test01 {
  
  // 1) static nested class 
  static class A {}
  
  // 2) (non-static) nested class = inner class 
  class B {}

  public static void main(String[] args) {
    
    // 3) local class
    class C {}
    
    // 4) anonymous(익명) class
    Object obj = new Object() {}; // 이름이 없어서 바로 
    
    // lamda(람다)로 nested class 표현
    Runnable obj2 = () -> {};

  }

}

