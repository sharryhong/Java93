/* 예외처리 : throws 선언
 * => 예외를 발생시키는 코드를 사용할 때 당장 예외처리를 하고싶지않다면,
 *    메서드 선언부에 그 예외정보를 적시하면된다. 그러면 그 메서드를 호출하는쪽에서 처리한다.
 *    즉, 해당메서드에서 어떤예외가 발생하는지 알리는것이 목적 
 */
 
package step17;

public class Test08 {

  // 이렇게하면 main()메서드는 JVM이 호출하기 때문에, main()에서 예외발생시 JVM이 처리한다. 
  // 그냥 그 예외에 대해 printStackTrace()를 실행한다.
  // 주의!
  // JVM에게 예외처리를 위임하는 순간 main()의 호출은 종료되기때문에 프로그램의 실행도 종료된다!
  // 그러므로 이렇게 짜면 안되겠지~
  public static void main(String[] args) throws Exception, IllegalArgumentException, NumberFormatException {
    // IllegalArgumentException, NumberFormatException 는 java.lang.RuntimeException 계열이기 때문에 생략가능(Test08)
      if (args.length < 1)
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1) 
        throw new Exception("나이가 유효하지 않습니다.");

      System.out.println(age);
  }
}

