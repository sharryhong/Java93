/* 예외처리 : 사용자 정의 예외 던지기
 * => 예외클래스의 선택의 기준은 이름이다. 즉, 예외 상황을 잘 표현할 수 있는 이름을 가진 클래스를 선택하게 된다.
 * => 그런데 마땅한 예외클래스가 없을 경우, 개발자가 직접 예외클래스를 만들어 던질 수 있다. 
 *    뭔가 특별한 기능을 추가한다기 보다는 예외 상황을 잘 드러내는 이름을 가진 클래스를 만든다는 의미
 *    애플리케이션 예외여야하기 때문에 java.lang.Exception을 상속받아서 만든다. 
 */
 
package step17;

public class Test07 {
  // 사용자 정의 예외 클래스 (원래는 외부파일로 만드는게 좋다.)
  static class InvalidValueScopeException extends IllegalArgumentException {
    // 기본생성자는 수퍼클래스의 기본생성자 호출
    public InvalidValueScopeException() {}
    
    public InvalidValueScopeException(String message) { 
      super(message); // 수퍼클래스의 생성자 중 문자열 받는 생성자 호출
    }

    public InvalidValueScopeException(String message, Throwable cause) {
      super(message, cause);
      // TODO Auto-generated constructor stub
    }

    public InvalidValueScopeException(Throwable cause) {
      super(cause);
      // TODO Auto-generated constructor stub
    }
    
    // 직접적지 않아도 이클립스에서 자동생성해준다. (수퍼클래스의 생성자 코딩)
    // context ment > source > generate constructor from SuperClass 
  }

  public static void main(String[] args) {
    try {
      if (args.length < 1)
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1) {
//        throw new Exception("나이가 유효하지 않습니다."); // 1) 이걸 좀 더 명확하게 예외처리하기 위해 만들어보자.
        throw new InvalidValueScopeException("나이가 유효하지 않습니다.");
      } 
      System.out.println(age);
      
    } catch(Throwable ex) { 
      ex.printStackTrace(); // 어떤 예외가 발생했는지 추적해서 출력해줌
    } 
  }
}

