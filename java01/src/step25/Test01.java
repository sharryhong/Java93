/* 애노테이션 추출하기
 * => RUNTIME 레벨의 애노테이션만 추출할 수 있다. 
 */
package step25;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // .class파일에 들어있는 애노테이션 추출하기 
    // 1) 클래스 정보를 다루는 도구를 가져와야 한다.
    /* 방법 1: 문자열을 변수화 시켜서 다른 클래스로 교체할 수 있다. 교체해야한다면 이 방법 사용
    Class clazz = Class.forName("step25.Class01");
    */
    
    /* 방법 2: Class의 스테틱 변수인 class 
     * 이 방법은 다른 클래스로 교체할 수 없다. 단순 테스트.. 교체할 필요없으면 이 방법 사용*/
    Class clazz = Class01.class; // 상수 값 이용
    
    // 2) Class 객체를 통해 애노테이션 추출
    Annotation01 anno01 = (Annotation01)clazz.getAnnotation(Annotation01.class);
    if (anno01 == null) {
      System.out.println("Annotation01 애노테이션을 추출하지 못했다!"); // 실행됨
      // Annotation01은 CLASS레벨이기 때문에 .class파일에 존재하지만 JVM을 통해 꺼낼 수 없다.
    } else {
      System.out.println("Annotation01 애노테이션을 추출했다!");
    }
    
    Annotation03 anno03 = (Annotation03)clazz.getAnnotation(Annotation03.class);
    if (anno03 == null) {
      System.out.println("Annotation03 애노테이션을 추출하지 못했다!");
    } else {
      System.out.println("Annotation03 애노테이션을 추출했다!"); // 실행됨
      // Annotation01은 RUNTIME레벨이기 때문에 .class파일에 존재하며, 실행중에 JVM을 통해 꺼낼 수 있다.
    }
  }

}
