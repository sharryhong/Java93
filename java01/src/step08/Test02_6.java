/* 유틸리티 클래스 : String 6 - replace() 메서드와 Immutable 객체 */ 
package step08;

public class Test02_6 {

  public static void main(String[] args) {

    String s1 = "Hello";  
    String s2 = "Hello"; 
        
    // String 인스턴스는 immutatble객체이다. 
    // 따라서 원본은 그대로 두고 원본을 복사해서 새 문자열 인스턴스를 만든 다음에 작업을 수행한다. 
    String s3 = s1.replace('l', 'x');
    
    System.out.println(s1); // Hello
    System.out.println(s2); // Hello
    System.out.println(s3); // Hexxo
  }

}
