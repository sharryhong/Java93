/* 변수 선언 : 블록과 변수의 범위 2 - 블록 단위로 변수 관리 */
package step02;

public class Test19 {
  
  public static void main(String[] args) {
    int a = 10;
    {
//      int a = 20; // 블록 바깥쪽에 존재하는 변수를 중복해서 선언할 수 없다. Error!!
      int b = 20;
      System.out.println(b); // 20
      System.out.println(a); // 10
    }
    
    // 블록 벗어나면 블록안에서 선언했던 모든 변수가 제거됨. 
  }
}
