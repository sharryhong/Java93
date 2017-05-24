/* 예외처리 : throw 명령
 * => 예외가 발생했을 때 현재 위치에서 즉시 실행을 멈추고, 
 *    코드를 실행하는 쪽에 예외 정보를 전달하는 명령어
 * => 문법
 *    throw [Throwable 객체];
 */
// 현재 코드 실행 : 
// 명령창에서 >java -cp bin step17.Test04 20 
package step17;

public class Test04 {

  public static void main(String[] args) {
    try {
      if (args.length < 1)
        throw new Throwable("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1) {
        throw new Throwable("나이가 유효하지 않습니다."); // 1) 예외를 던지는 코드. 
                                                        // => 2) 예외를 받는 코드를 작성해야한다. : try {} catch {}
      } 
      System.out.println(age);
    } catch (Throwable ex) {
        System.out.println(ex.getMessage()); // 예외의 메시지 출력 
      }
    }
}

