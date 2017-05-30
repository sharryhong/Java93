/* 인터페이스 3
 * => 인터페이스는 다중상속 가능
 * => 어차피 구현되지 않은 메서드이기 때문
 */
package step21.ex8;

public interface D extends B, C {
//  void m3(); // 문제는 없지만 부질없어~ 하지말라.
//  int m3(); // Error! 메서드는 리턴타입으로 구분하는게 아니다.
  void m3(int a); // OK! 파라미터가 다르면 "오버로딩"이 가능하기 때문에 괜찮다.
  int m3(int a, int b); // OK!
  void m7();
}
