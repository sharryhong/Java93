/* 문장 : 반복문 for 2 
 * => 범위 지정은 안된다. */
package step04;

public class Test03_9 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
 // for (변수 선언 : 배열)
    for (int value : arr) { // JavaScript의 for of문과 비슷하다. 
      System.out.print(value + ", ");
    }
    System.out.println();
    System.out.println("--------------------------");
    
    // for (변수 선언 : Collection타입의 객체)
    java.util.ArrayList arr2 = new java.util.ArrayList();
    arr2.add(10);
    arr2.add(20);
    arr2.add(30);
    
    for (Object value : arr2) {
      System.out.print(value + ", ");
    }
  }

}
