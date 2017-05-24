/* 예외처리 : finally 블록
 * => 정상적으로 실행되든, 예외가 발생해서 catch블록이 실행되든 finally블록 실행
 */

package step17;

public class Test13 {
  
  public static void main(String[] args) {
    try {
      if (args.length < 1) {
        System.out.println("[사용법]>java -cp bin step17.Test11 숫자");
        return; // 더이상 실행하지 않고 main()메서드를 나간다. => 그래도 finally {} 는 실행된다.
      }
      System.out.println(Integer.parseInt(args[0]));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      // 이 블록은 try 또는 catch 블록을 떠나기 전에 반드시 실행된다. 
      // 그래서 보통 자원을 해제하는 코드를 둔다. 
      // 예) 파일 객체를 닫기, 소켓 객체를 닫기, DB연결을 닫기 등
      System.out.println("오호라~");
    }
    System.out.println("ㅋㄷ");
  }
}

