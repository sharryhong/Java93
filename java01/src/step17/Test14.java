/* 예외처리 : 자원을 자동 해제시키는 try ~ catch 문장 (try-with-resources Statement) 
 * => 일반적으로 finally 블록에서 자원을 해제시킨다. 
 */

package step17;

import java.io.FileInputStream;

public class Test14 {
  
  public static void main(String[] args) {
    
    FileInputStream in = null;
    
    try {
      in = new FileInputStream("step17.Test14.data");
      
      int b = 0;
      while ((b = in.read()) != -1) {
        System.out.printf("%x, ", b);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      
    } finally {
   // 파일의 자원을 해제시키다가(close() 호출하다가) 예외가 발생할 수 있다.
      try {  in.close(); } catch (Exception e) { /*무시*/ }
    }

  }
}

