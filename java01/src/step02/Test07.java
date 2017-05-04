/* 변수 선언 : 배열 변수와 초기화 */
package step02;

public class Test07 {

  public static void main(String[] args) {
    // 1)
    byte[] arr1 = new byte[3];
    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;
    System.out.printf("%d, %d, %d\n", arr1[0], arr1[1], arr1[2]);
    
    // 2)
    byte[] arr2 = new byte[]{40, 50, 60};
    System.out.printf("%d, %d, %d\n", arr2[0], arr2[1], arr2[2]);
    
    // 3) 가장 많이쓰는 방법
    // 주의하자. Java에서는 {} 가 배열이다. 
    byte[] arr3 = {70, 80, 90};
    System.out.printf("%d, %d, %d\n", arr3[0], arr3[1], arr3[2]);
    
    // 변수를 선언한 후에 값을 초기화시키는 명령 사용할 수 없다. 
    byte[] arr4;
    arr4 = new byte[]{100, 101, 102}; // ok 
    System.out.printf("%d, %d, %d\n", arr4[0], arr4[1], arr4[2]);
    
    byte[] arr5;
//    arr5 = {100, 101, 102}; // 컴파일 오류!

  }

}
