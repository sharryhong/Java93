/* Class 도구 사용법 : 메서드 호출하기 */
package step26;

import java.lang.reflect.Method;

public class Test07 {
  public static void main(String[] args) throws Exception {
    String str = new String("Hello");
    Class<?> clazz = String.class; // 클래스 도구 얻기
    
    Method m = clazz.getMethod("replace", char.class, char.class); // String의 replace메서드 중에 파라미터로 char 두개 받는 메서드를 찾아서 
    Object returnValue = m.invoke(str, 'l', 'x'); // invoke : 메서드 호출. (replace메서드)
    System.out.println(returnValue); // 결과 : Hexxo
    
    // 2) 
    clazz = Math.class;
    m = clazz.getMethod("abs", int.class); // Math의 abs(절대값) 메서드 호출. 파라미터로 int값 받는
    returnValue = m.invoke(null, -100); // 인스턴스 주소 필요없어서 null준다.
    System.out.println(returnValue); // 결과 : 100
  }
}