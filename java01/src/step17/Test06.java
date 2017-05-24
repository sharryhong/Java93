/* 예외처리 : catch 작성 순서
 * => 예외를 던지면 그 예외를 받을 catch문을 찾는데, catch문의 순서대로 찾는다. 
 *    그래서 작성할 때 주의해야 한다.
 *    여러개의 catch문이 있을 때 최하위 클래스를 파라미터로 갖는 catch문부터 작성하라.
 *    Why?
 *    다형성의 다형적 변수 규칙상, 레퍼런스 변수는 하위타입의 객체까지 저장할 수 있다. 
 *    그래서 상위타입의 변수가 먼저있으면 하위타입의 변수를 선언한 catch문은 실행되지않는다.
 *    이런 이유때문에 자바컴파일러는 아예 허락하지 않는다. 컴파일 에러
 */
 
package step17;

public class Test06 {

  public static void main(String[] args) {
    try {
      if (args.length < 1)
        throw new Throwable("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1) {
        throw new Exception("나이가 유효하지 않습니다.");
      } 
      System.out.println(age);
      
    } catch(NumberFormatException ex) { 
      System.out.println("애플리케이션의 아규먼트가 숫자가 아닙니다.");
      
    } catch(Exception ex) { 
      System.out.println("나이값이 유효하지 않습니다.");
      
    } catch (Throwable ex) { // 만약 이것이 젤 먼저 있다면 무조건 이게 실행될 것이다. 어차피 컴파일에러 발생한다.
        System.out.println(ex.getMessage()); 
      }
    }
}

