/* 증가/감소 연산자 - 전위 연산자와 후위 연산자의 차이점 */

package step03;

public class Test02_2 {

  public static void main(String[] args) {
    // 1) 전위(pre-fix) 연산자
    // 
    int x = 0;
    int i = 10;
    x = ++i;  
    System.out.printf("i = %d, x = %d\n", i, x); // 11, 11 
    
   
    // 2) 후위(post-fix) 연산자
    i = 10;
    x = i++;  
    System.out.printf("i = %d, x = %d\n", i, x); // 11, 10
  }

}
