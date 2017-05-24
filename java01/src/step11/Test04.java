/* 캡슐화 : modifier의 종류 
 * => private
 *    - 클래스 멤버만이 접근 가능
 * => (default) : 아무것도 붙이지 않는 것
 *    - 클래스 멤버 + 같은 패키지의 클래스 
 * => protected 
 *    - 클래스 멤버 + 같은 패키지의 클래스 + 자식 클래스 
 * => public
 *    - 모든 접근 허용 */
package step11;

import step11.ex1.A;

public class Test04 extends A {

  public void test() {
//    this.v1 = 1; // error!
//    this.v2 = 2; // error!
    this.v3 = 3; // protected. 상속 받아서 만든 변수이기 때문에 가능 
    this.v4 = 4; // public이므로 가능
  }
  public static void main(String[] args) {
    A obj = new A();
//    obj.v1 = 1; // private이라서 에러
//    obj.v2 = 2; // 상속 받아서 만든 변수가 아니라서
//    obj.v3 = 3; // 에러
    obj.v4 = 4;
  }

}
