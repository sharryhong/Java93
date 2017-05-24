/* 유틸리티 클래스 : String 3 - 문자열 비교 */ 
package step08;

public class Test02_3 {

  public static void main(String[] args) {

    // 원래 java.lang.이렇게 패키지 이름을 적어줘야하지만 String만 예외로 안적어도된다. 
    java.lang.String s1 = new java.lang.String("Hello");
    String s2 = new String("Hello");
        
    if (s1.equals(s2)) { // 문자열인스턴스주소1.equals(비교하고싶은 문자열인스턴스주소2)  
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }

  }

}
