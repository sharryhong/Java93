/* 리터럴 - 부동 소수점의 의미
 */
package stap01;

public class Test08 {
  
  public static float xxx = 12.375f;

  public static void main(String[] args) {

    System.out.println(987.654F);
    
    /* 부동소수점 표기법
     * 소수점이 부양하여 움직임을 표현하기 위해 "부동소수점"이라 부른다. 
     */
    // 아래는 모두 987.654
    System.out.println(98.7654E1f); // 
    System.out.println(9.87654E2f);
    System.out.println(0.987654E3f);
    System.out.println(9876.54E-1f);
    System.out.println(98765.4E-2f);
  }
}
