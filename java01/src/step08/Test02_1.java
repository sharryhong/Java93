/* 유틸리티 클래스 : String
 * => char[] 을 이용하여 내부적으로 문자열 처리
 */ 
package step08;

public class Test02_1 {

  public static void main(String[] args) {
    // 
    String s1;
    
    //
    s1 = new String("Hello");
    
    String s2 = s1; // 같은 주소 
    
    if (s1 == s2) {
      System.out.println("s1 == s2");
    }

  }

}
