/* 유틸리티 클래스 : Wrapper 2 - equals() 메서드 
 * => String 클래스처럼 수퍼 클래스 Object의 equals()를 
 * 주소가 아닌 값이 같은지 비교하도록 재정의 하였다. */
package step08;

public class Test04_2 {

  public static void main(String[] args) {
  Integer i1 = new Integer(10);
  Integer i2 = new Integer(10);
  
  System.out.println(i1 == i2); // false
  System.out.println(i1.equals(i2)); // true
  
  StringBuffer s1 = new StringBuffer("Hello");
  StringBuffer s2 = new StringBuffer("Hello");
  
  System.out.println(s1 == s2); // false
  System.out.println(s1.equals(s2)); // false 
      // StringBuffer클래스는 equals()를 재정의 하지 않았으므로

  }
}
