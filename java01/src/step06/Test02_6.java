/* class 문법의 용도 : 관련된 메서드를 묶는 용도 */ 

package step06;

public class Test02_6 {
  

  public static void main(String[] args) {

    Member2 m1 = new Member2();
    Member2 m2 = new Member2();
    Member2 m3 = new Member2();
    
    Member2.init(m1, "홍길동", 100, 100, 100);
    Member2.init(m2, "임꺽정", 90, 90, 90);
    Member2.init(m3, "유관순", 80, 80, 80);
    
    Member2.compute(m1);
    Member2.compute(m2);
    Member2.compute(m3);

    Member2.print(m1);
    Member2.print(m2);
    Member2.print(m3);
    
  }

}
