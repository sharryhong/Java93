/*  final : 변수에 final 붙이기 
 * => 딱 한번만 값 저장
 * => 주로 상수를 표현할 때 사용 */
package step12.ex3;

public class B {
  int a;
  final int b = 20; // 아예 선언과 동시에 초기화
  
  public B() {
    a = 10;
    b = 20; // Error!
  }

}
