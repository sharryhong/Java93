/* 캡슐화 : 패키지 멤버 클래스(일반 클래스)에 붙일 수 있는 modifier의 종류 
 * => (default) : 아무것도 붙이지 않는 것
 *    - 같은 패키지의 클래스 
 * => public
 *    - 모든 접근 허용 */
package step11.ex1;

public class Test07 {

  // public 클래스는 다른 패키지에서도 접근 가능
  step11.ex1.A obj1 = new step11.ex1.A();
  
  // default 클래스는 같은 패키지에 있으므로 접근 가능
  step11.ex1.B obj2 = new step11.ex1.B();

}
