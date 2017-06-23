/* 클래스 정보를 다루는 도구 얻기 */
package step26;

public class Test01 {
  public static void main(String[] args) throws Exception {
    // 방법 1) 인스턴스를 통해서 얻기 
    String obj = new String("Hello");
    Class<?> c1 = obj.getClass(); // <?> : c1 레퍼런스는 어떤 종류의 class든 다 가리킬 수 있다.
    
    // 방법 2) Class.forName() 메서드를 통해서 얻기 
    Class<?> c2 = Class.forName("java.lang.String"); // 예외발생. 없을 수도 있기 때문
    
    // 방법 3) 모든 클래스에 내장된 "class" static 변수를 통해 얻ㄱ ㅣ
    Class<?> c3 = String.class; // String클래스의 class필드 (static변수)
  }
}
