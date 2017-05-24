/* 유틸리티 클래스 : String 7 - replace() 메서드와 Mutable 객체 */ 
package step08;

public class Test02_7 {

  public static void main(String[] args) {

    StringBuffer s1 = new StringBuffer("Hello");  
    StringBuffer s2 = new StringBuffer("Hello"); 

    s1.replace(2, 4, "xx");  // 시작인덱스, 4-1인덱스, 바꿀문자열
    
    System.out.println(s1); // Hello
  }

}
