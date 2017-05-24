/* 문장 : 반복문 for */
package step04;

public class Test03_8 {
  public static void main(String[] args) {
    for (int i = 2; i <= 9; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
    System.out.println("---------------------");
//    i = 20; // Error! for문 안에 선언된 변수는 블록을 벗어나면 사용할 수 없다. 
    int i = 2;
    for (; i <=9; i++) { // 이렇게 할 수도 있지만 하지말자.
      System.out.print(i + ",");
    }
    
  }

}
