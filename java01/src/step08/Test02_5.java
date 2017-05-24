/* 유틸리티 클래스 : String 5 - 상수 문자열과 문자열 인스턴스 */ 
package step08;

public class Test02_5 {

  public static void main(String[] args) {

    String s1 = "Hello"; // new String("Hello")와 같지만, 단 Constant Pool 영역에 생성된다. 
    String s2 = "Hello"; // 한번 생성되면기존의 상수 문자열 인스턴스의 주소를 리턴한다. 
    String s3 = new String("Hello");
    String s4 = new String("Hello");
        
    if (s1 == s2) { // 같은 주소! 하지만 하나는 상수문자열이고 하나는 아니면 비교안되므로
                    // 무조건 equals()로 비교하도록 하자. 
      System.out.println("s1 == s2");
    } 
    if (s1 == s3) { // s1는 Constant Pool 영역에 생성, s3는 Heap영역에 생성
      System.out.println("s1 == s3");
    } 
    if (s3 == s4) { // s3, s4는 Heap영역에 다른 주소로 생성
      System.out.println("s3 == s4");
    } 

  }

}
