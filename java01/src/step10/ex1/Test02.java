/* 수퍼 클래스의 메서드를 재정의 하는 방법 */
package step10.ex1;

public class Test02 {

  public static void main(String[] args) {
    BitStudent s = new BitStudent();
    s.name = "홍길동";
    s.age = 20;
    s.school = "비트대학교";
    s.print();
  }

}
