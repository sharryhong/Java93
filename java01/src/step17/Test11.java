/* 예외처리 : 일반모드와 스텔스모드 (공식용어가 아니라 쌤이 이해를 위해 만든 용어 ^^)
 * => 일반모드 : Exception 계열 예외
 *    일반모드의 예외가 발생하는 경우 
 *    1) try ~ catch ~
 *    2) throws 
 *    예외처리 문법인 둘 중 하나를 반드시 작성해야한다. 
 * => 스텔스모드 : Error와 RuntimeException 계열 예외
 *    스텔스모드의 예외가 발생하는 경우 예외처리 문법은 선택사항이다.
 */
 
package step17;

public class Test11 {
  
  static void m1(int v) throws Exception {
    m2(v);
  }
  
  static void m2(int v) throws Exception {
    m3(v);
  }
  
  static void m3(int v) throws Exception { // m3가 직접 발생시키는게 아니라 m4가 발생시키지만 그래도 throws ~나 try catch를 해야한다. 
    m4(v);
  }
  
//  static void m4(int v) {
//    // 1) 예외처리를 여기에서 직접 처리
//    // 그런데 윈도우환경에서는 dialog box를 띄워야한다. 따라서 이렇게 하면안된다. 
//    try {
//      if (v < 0)
//        throw new Exception("음수는 허용하지 않습니다.");
//      System.out.println(v);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
  
  // 2) 예외처리를 호출한 쪽에 전달만 하기 => 통상적으로 이렇게 하도록 한다.  
  static void m4(int v) throws Exception {
    if (v < 0)
      throw new Exception("음수는 허용하지 않습니다.");
    System.out.println(v);
  }
  
  public static void main(String[] args) {
    
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

