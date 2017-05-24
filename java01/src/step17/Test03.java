/* 예외처리 : 예외 발생시 그 정보를 전달하고 전달받는 방법
 * => 예외 정보를 호출자에게 전달하는 방법
 *    throw [Throwable 객체]; // 예외정보를 담은 객체 (java.lang.Throwable 타입의 객체, 이 것의 하위(서브) 타입 객체들이 올 수 있다.)
 * => 예외 정보를 받는 방법
 *    try {
 *      예외를 던지는 코드
 *    } catch (예외를 받을 변수 선언) {
 *      예외를 처리하는 코드 
 *    }
 *    
 * => java.lang.Throwable 클래스 계층 구조
 * 
 *    Throwable
 *      |--> Error
 *      |--> Exception
 *               |--> RuntimeException
 *                          |--> NullPointException
 *               |--> IOException
 *                          |--> FileNotFoundException 
 *                          |--> EOfException
 *               |--> SQLException
 * => 예외 종류
 *    1) 시스템 예외(Error 타입 예외)
 *       - JVM이 발생시키는 예외
 *       - 개발자가 처리하는 예외가 아니다.
 *       - 치명적인 예외여서 개발자가 예외를 처리하더라도, 가능한 JVM을 종료해야한다. 
 *       - 개발자는 JVM이 종료되기 전에 작업 중인 파일을 저장한다거나, 예외에 대한 로그를 파일에 쓴다거나, 
 *         사용자에게 예외상황을 출력하는 등의 마무리 작업을 하고 JVM을 종료한다.
 *       - 무조건 JVM을 종료 후 다시 시작해야한다. 
 *       - 예) 메모리 부족
 *    2) 애플리케이션 예외(Exception 타입 예외)
 *       - 애플리케이션에서 발생하는 예외
 *       - 개발자가 처리해야하는 예외
 *       - 예외를 처리한 후 계속 애플리케이션을 계속 실행할 수 있다. 
 *       
 * 예외처리 문법의 이점
 * 1) 예외가 발생하더라도 적당한 처리 후 시스템을 멈추지 않고 계속 실행시킬 수 있다. 
 * 2) 메서드 리턴 여부, 타입에 상관없이 호출자에게 예외정보를 전달할 수 있다.
 * 3) try블록에는 예외상황이 아닐때의 코드, catch블록에는 예외처리하는 코드를 둠으로서, 
 *    정상 작업코드와 예외처리 코드를 분리하는 효과가 있다. => 코드의 가독성 높임 
 */
package step17;

public class Test03 {
  
  // 메서드를 실행하다가 예외를 던질 수 있는 경우
  // 메서드 선언부에 어떤 예외가 던져질 수 있는지 적어야한다. 
  public static float divide(float a, float b) throws Throwable {
    if (b == 0) {
      throw new Throwable("0으로 나누지 마세요!");
    }
    return a / b;
  }

  public static void main(String[] args) {
    try {
      // 예외를 던질 수 있는 코드
      float result = divide(10f, 2f);
      System.out.println(result);
      result = divide(10f, 0);
      System.out.println(result);
    } catch (Throwable ex) {
      // 예외를 처리하는 코드
      System.out.println(ex.getMessage());
    }
    System.out.println("예외처리후에도 시스템 멈추지 않고 나 실행");
  }

}
