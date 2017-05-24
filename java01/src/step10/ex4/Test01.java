/* super 키워드의 사용
 * => 재정의하기 전의 메서드를 호출할 때 사용한다.
 * 자신을 뺀 조상 클래스로 따라 올라가면서 메서드를 찾는다.
 * 없으면 컴파일 오류! */
package step10.ex4;

public class Test01 {

  public static void main(String[] args) {
    C obj = new C();
    obj.test1();
    System.out.println("-----------------------------");
    obj.test2();
  }

}
