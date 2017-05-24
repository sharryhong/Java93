/* 변수 선언 : 배열 변수 */
package step02;

public class Test06 {

  public static void main(String[] args) {
    
    // 1)
    byte[] arr1; // 표기법1. 주로 Java언어 
//    byte arr1[]; // 표기법2. 주로 C언어 
    
//    arr1 = 10; // 컴파일 오류
//    arr1[0] = 10; // 컴파일 오류. arr1변수의 값을 초기화하지 않아서
    
    arr1 = null; // arr1에 0 값을 저장. 즉, 주소가 없음을 의미
//    arr1[0] = 10; // NullPointerException. 실무에서 가장 많이 발생하는 오류
//    System.out.println(arr1);
    
    // 2) 메모리에 주소저장. 메모리 준비.
    arr1 = new byte[3];
    
    // 3)
    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;
    
    System.out.printf("%d, %d, %d\n", arr1[0], arr1[1], arr1[2]);
    
//    arr1[3] = 40; // ArrayIndexOutOfBoundsException. 실무에서 두번째로 많이 발생하는 오류 

  }

}
