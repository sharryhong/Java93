/* Class 도구 사용법 : nested class (Inner Class) 로딩 */
package step26;

public class Test09 {
  static class My {}
  
  public static void main(String[] args) throws Exception {
    Class<?> c1 = My.class; // 방법 1) 혹은 step26.Test09.My.class
    Class<?> c2 = Class.forName("step26.Test09$My"); // 방법 2) 문자열로 지정할 때는 $
    System.out.println(c1); // 결과 : class step26.Test09$My
    System.out.println(c2); // 결과 : class step26.Test09$My
  }
}