/* class 문법의 용도 : 관련된 메서드를 묶는 용도 */ 

package step06;

public class Test02_5 {
  

  public static void main(String[] args) {
//    Test02_4는 회원의 성적을 개별적으로 관리할 수 없다. 
    // Why? 클래스에 선언된 static변수 때문
    Member.init("홍길동", 100, 100, 100);
    Member.compute();
    Member.print();
  }

}
