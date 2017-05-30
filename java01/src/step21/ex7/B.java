/* 추상 클래스 2
 * => 추상 클래스는 추상메서드를 가질 수 있다.
 * => 
 */
package step21.ex7;

public abstract class B {
  
  // 일반메서드
  public void m1() {
    System.out.println("A.m1()...");
  }
  
  // 추상메서드
  public abstract void m2();
}
