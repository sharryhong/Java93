/*  final : 변수에 final 붙이기 
 * => 딱 한번만 값 저장
 * => 주로 상수를 표현할 때 사용 */
package step12.ex3;

public class A {
  int a;
  final int b;
  
  public A() {
    a = 10;
    b = 20; // 딱 한번만 값을 넣을 수 있다. 
  }
  
  public void m() {
    b = 30; // Error!
  }
}
