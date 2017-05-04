/* 리터럴 - 부동 소수점과 유효자릿수
 */
package stap01;

public class Test07 {
  
  public static float xxx = 12.375f;

  public static void main(String[] args) {
    // 1) 4바이트 메모리 = single precision(단정도 : 한 개의 정밀도)
    System.out.println(987.654F);
    System.out.println(999.9999F);
    System.out.println(999.99999F); // 유효자릿수(7자리)를 넘어가면 값이 짤린다. (부동소수점의 특징)
                                    // 주의! 컴파일 오류가 발생하지 않는다. 
    
    // 2) 8바이트 메모리 : double precision(배정도 : 단정도보다 두 배 정밀하다) 
    System.out.println(99999.9999999999); // 실무에서는 15자리를 유효자리로 본다.
    System.out.println(99999.99999999999);
    System.out.println(99999.999999999999); // 유효자릿수(16자리)를 넘어가면 값이 짤린다.
  }
}
