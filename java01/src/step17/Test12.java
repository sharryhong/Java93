/* 예외처리 : 일반모드와 스텔스모드 (공식용어가 아니라 쌤이 이해를 위해 만든 용어 ^^)
 * => 일반모드 : Exception 계열 예외
 *    일반모드의 예외가 발생하는 경우 
 *    1) try ~ catch ~
 *    2) throws 
 *    예외처리 문법인 둘 중 하나를 반드시 작성해야한다. 
 * => 스텔스모드 : Error와 RuntimeException 계열 예외
 *    스텔스모드의 예외가 발생하는 경우 예외처리 문법은 선택사항이다.
 */

// 스텔스 모드 - RuntimeException 사용
package step17;

public class Test12 {
  
  static void m1(int v) {
    m2(v);
  }
  
  static void m2(int v) {
    m3(v);
  }
  
  static void m3(int v) {
    m4(v);
  }
  
  
  // m4()에서 발생시킨 예외를 main() 메서드처럼 스택의 상위메서드에서 처리하도록 만들고 싶다면,
  // 스텔스모드로 예외를 발생시켜라. 
  // 중간에 개입한 메서드들은 예외처리를 할 필요가 없어 코드가 간결해진다. 
  // 주의! main()에서는 반드시 try ~ catch로 예외를 처리해야한다. 
  // 하지않으면 JVM에게 처리를 넘겨서 예외생기면 프로그램 멈춘다. 
  static void m4(int v) {
    if (v < 0)
      throw new RuntimeException("음수는 허용하지 않습니다.");
    System.out.println(v);
  }
  
  public static void main(String[] args) { // main() 메서드 : (start) entry(진입점) 이라고 한다. 
    try {
      if (args.length < 1) {
        System.out.println("[사용법]>java -cp bin step17.Test11 숫자");
      }
      m1(Integer.parseInt(args[0]));
    } catch (NumberFormatException e) {
      System.out.println("프로그램 아규먼트는 숫자여야합니다.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("오키");
  }
}

