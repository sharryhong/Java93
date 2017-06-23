/* Class 도구 사용법 : 클래스의 메서드 알아내기 */
package step26;

import java.lang.reflect.Method;

public class Test03 {
  public static void main(String[] args) throws Exception {
    test2(); // static 환경(context)에서는 인스턴스필드나 인스턴스메서드를 사용할 수 없다. 
  }

  private static void test1() throws Exception {
    Class<?> clazz = MyClass.class; // 클래스 도구 얻기
 // 상속받은 메서드 포함, 모든 public메서드만 추출
    Method[] methodList = clazz.getMethods(); // 메서드 목록 리턴
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
  
  private static void test2() throws Exception {
    Class<?> clazz = MyClass.class; // 클래스 도구 얻기
    // 상속받은 메서드 제외. 모든 메서드 추출 
    Method[] methodList = clazz.getDeclaredMethods(); // 메서드 목록 리턴
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
}