/* 유틸리티 클래스 : String 2 - 레퍼런스 비교
 * 
 */ 
package step08;

public class Test02_2 {

  public static void main(String[] args) {

    // 원래 java.lang.이렇게 패키지 이름을 적어줘야하지만 String만 예외로 안적어도된다. 
    java.lang.String s1 = new java.lang.String("Hello");
    String s2 = new String("Hello");
        
    if (s1 == s2) { // 두 변수에 저장된 주소가 같은지 비교!
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }

  }

}
