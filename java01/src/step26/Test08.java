/* Class 도구 사용법 : 인스턴스 생성하기 */
package step26;

import java.lang.reflect.Method;
import java.util.Date;

public class Test08 {
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("java.util.Date");
    // 인스턴스 생성 방법 1)
    Date obj = (Date)clazz.newInstance(); // 클래스 이름만 알아낸다면 newInstance()로 인스턴스 생성
    System.out.println(obj);
  }
}