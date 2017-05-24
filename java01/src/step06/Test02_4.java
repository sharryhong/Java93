/* class 문법의 용도 : 관련된 메서드를 묶는 용도 */ 

package step06;

public class Test02_4 {
  

  public static void main(String[] args) {
    
    Member.init("홍길동", 100, 100, 100);
    Member.compute();
    Member.print();
  }

}
