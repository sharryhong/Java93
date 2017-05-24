/* 변수 선언 : 배열 변수와 레퍼런스 */
package step02;

public class Test08 {

  public static void main(String[] args) {

    byte[] arr1 = new byte[3];
    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;
    System.out.printf("%d, %d, %d\n", arr1[0], arr1[1], arr1[2]);
    

    arr1 = new byte[]{40, 50, 60, 70, 80};
    System.out.printf("%d, %d, %d, %d, %d\n", arr1[0], arr1[1], arr1[2], arr1[3], arr1[4]);
    
  }

}
