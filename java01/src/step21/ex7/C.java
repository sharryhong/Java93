/* 추상 클래스 3
 * => 추상 클래스를 상속받은 서브클래스는 추상메서드가 있으면 구현해야한다.
 */
package step21.ex7;

public abstract class C extends B {
  
  public void m3() {
    System.out.println("B.m3()...");
  }
  
}
