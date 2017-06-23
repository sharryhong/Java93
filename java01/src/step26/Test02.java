/* Class 도구 사용법 : 클래스 이름 알아내기 */
package step26;

public class Test02 {
  public static void main(String[] args) throws Exception {
    Class<?> c1 = String.class;
    
    System.out.println(c1.getName());           // 결과 : java.lang.String
    System.out.println(c1.getSimpleName());     // 결과 : String
    System.out.println(c1.getCanonicalName());  // 결과 : java.lang.String
  }
}
