/* 캡슐화 : modifier의 종류 
 * => private
 *    - 클래스 멤버만이 접근 가능
 * => (default) : 아무것도 붙이지 않는 것
 *    - 클래스 멤버 + 같은 패키지의 클래스 
 * => protected 
 *    - 클래스 멤버 + 같은 패키지의 클래스 + 자식 클래스 
 * => public
 *    - 모든 접근 허용 */
package step11.ex1;

public class Test05 {

  public static void main(String[] args) {
    A obj = new A();
//    obj.v1 = 1; // private이라서 에러
    obj.v2 = 2; // 같은 패키지라서 가능
    obj.v3 = 3; // 상동
    obj.v4 = 4;
  }

}
