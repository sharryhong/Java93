/* Class 도구 사용법 : 메서드의 리턴 타입 알아내기 */
package step26;

import java.lang.reflect.Method;

public class Test05 {
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Math.class; // 클래스 도구 얻기
    
    Method m = clazz.getMethod("sin", double.class);
    System.out.println(m); // 결과 : public static double java.lang.Math.sin(double)
    
    // 메서드의 리턴 타입이 뭔지 알아내기
    Class<?> returnType = m.getReturnType();
    System.out.println(returnType.getName()); // 결과 : double
  }
}