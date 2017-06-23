/* 애노테이션 배열 속성 값 추출하기
 */
package step25;

public class Test03 {

  public static void main(String[] args) throws Exception {
    Class clazz = Class03.class; 
    
    Annotation05 anno = (Annotation05)clazz.getAnnotation(Annotation05.class);
    
    // 애노테이션의 속성 값을 꺼낼 때는 메서드를 호출한다. 인덱스 지정
    // anno.v1()리턴값이 String배열이다. 그 중 index=1 값
    System.out.printf("v1=%s\n", anno.v1()[1]);  // bbb
    System.out.printf("v2=%s\n", anno.v2()[0]);  // xxx
    System.out.printf("v3=%s\n", anno.v3()[0]);  // mmm
    System.out.printf("v4=%s\n", anno.v4()[1]);  // 200
    System.out.printf("v4=%s\n", anno.v5()[0]);  // 1000
    System.out.printf("v4=%s\n", anno.v6()[0]);  // 111
  }

}
