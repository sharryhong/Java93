/* 예외처리 : throws 선언 2
 * => java.lang.RuntimeException 계열의 예외를 던질 때는, 컴파일러가 강제로 요구하지 않는다. 
 *    즉, 예외를 처리하는 try ~ catch ~를 사용하지 않아도 되고,
 *    메서드 선언부에 throws를 적지않아도 된다.
 * => Why?
 *    스텔스 모드로 예외를 전달하기 위해 특별히 정한 규직이다. 
 */
 
package step17;

public class Test09 {
  
  public static void main(String[] args) {
      if (args.length < 1)
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1) 
        throw new IllegalArgumentException("나이가 유효하지 않습니다.");

      System.out.println(age);
  }
}

