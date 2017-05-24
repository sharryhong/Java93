/* 예외처리 : 자원을 자동 해제시키는 try ~ catch 문장 사용법 
 */

package step17;

import java.io.FileInputStream;

public class Test14_4 {
  
  static class A {
    public void close() throws Exception {
      System.out.println("A.close()");
    }
  }
  
  static class B implements AutoCloseable { // java.lang.AutoCloseable
    public void close() throws Exception {
      System.out.println("B.close()");
    }
  }
  
  public static void main(String[] args) {
    int age = 20;
    try (B obj1 = new B();) { // close() 메서드를 갖고 있는 클래스. 선언부에 AutoCloseable를 따른다고 되어있어야한다. 
      if (age < 19) {
        throw new Exception("미성년입니다.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

