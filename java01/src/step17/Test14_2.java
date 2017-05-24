/* 예외처리 : 자원을 자동 해제시키는 try ~ catch 문장 (try-with-resources Statement) 
 * => JDK7부터 사용가능
 */

package step17;

import java.io.FileInputStream;

public class Test14_2 {
  
  public static void main(String[] args) {

    // 자원을 자동 해제시키는 try ~ catch ~ 사용 후
    try (FileInputStream in = new FileInputStream("step17.Test14.data")) {
      int b = 0;
      while ((b = in.read()) != -1) {
        System.out.printf("%x, ", b);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      
    } finally {
      // 
    }

  }
}

