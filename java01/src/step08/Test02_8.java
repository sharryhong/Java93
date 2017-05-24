/* 유틸리티 클래스 : String 8 - StringBuffer는 문자열을 비교할 수 없다. */ 
package step08;

public class Test02_8 {

  public static void main(String[] args) {

    StringBuffer s1 = new StringBuffer("Hello");  
    StringBuffer s2 = new StringBuffer("Hello"); 

    System.out.println(s1 == s2); // false
    System.out.println(s1.equals(s2)); // false 
    System.out.println(s1.toString().equals(s2.toString())); // true
  }

}
