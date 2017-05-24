/* 리터럴 - 논리 값 리터럴
 */
package stap01;

public class Test09 {
  
  public static void main(String[] args) {

    System.out.println(true);
    System.out.println(false);
    
    if (true) {
      System.out.println("참이다1.");
    }
    
    if (false) {
      System.out.println("참이다2.");
    }
    
    /* 자바에서는 논리값으로 true, false만 가능. 
    if (1) { // C에서는 가능. JS에서도 암시적 형변환되어 가능.
      System.out.println("참이다3.");
    }*/

  }
}
