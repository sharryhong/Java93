/*  final : 변수에 final 붙이기 
 * => 딱 한번만 값 저장
 * => 주로 상수를 표현할 때 사용 */
package step12.ex3;

public class C {

  public void m1() { // 일반 메서드 안의 로컬변수에서 final사용
    int a;
    a = 10;
    a = 20; // ok
    
    final int b;
    b = 20;
    b = 30; // Error!
  }

}
