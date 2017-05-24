/* 예외처리 : 자원을 자동 해제시키는 try ~ catch 문장 사용법 
 */

package step17;

import java.io.FileInputStream;

public class Test14_3 {
  
  static class A {
    public void close() throws Exception {
      System.out.println("A.close()");
    }
  }
  
  public static void main(String[] args) {

    try (A obj1 = new A()) {
      
    } catch (Exception e) {
      
    }
  }
}

