/* 캡슐화 : modifier의 종류 
 * => 캡슐화란? 접근을 제한하는 이유?
 *    - 인스턴스 변수에 무효한 값이 들어가지 않도록 접근을 제한하는 문법
 *    - 무효한 값이 들어가면 클래스를 찾아서 정의(추상화)한 목적이 무너지게된다. 
 *    - 즉, 클래스의 역할이 깨지는 문제 발생!
 * => private
 *    - 클래스 멤버만이 접근 가능
 * => (default) : 아무것도 붙이지 않는 것
 *    - 클래스 멤버 + 같은 패키지의 클래스 
 * => protected 
 *    - 상속 받아서 만든 변수
 *    - 클래스 멤버 + 같은 패키지의 클래스 + 자식 클래스 
 * => public
 *    - 모든 접근 허용 */
package step11;

import step11.ex1.A;

public class Test03 {

  public static void main(String[] args) {
    A obj = new A();
//    obj.v1 = 1; // private이라서 error!
//    obj.v2 = 2; // 다른 패키지라서 error!
//    obj.v3 = 3; // error!
    obj.v4 = 4;
  }

}
