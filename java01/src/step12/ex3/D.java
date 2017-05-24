/*  final : 변수에 final을 붙이는 경우 */
package step12.ex3;

public class D {

  /* 1) 상수 값을 정의하고 싶을 때
   * 보통 클래스 변수를 상수 변수로 만든다. 
   * 상수변수는 보통 외부에 완전 공개
   * 상수변수임을 직관적으로 알 수 있도록 변수명을 대문자로 작성
   * 단어사이에는 밑줄(_)을 긋는다
  */
  
  public static final int LEVEL_GUEST = 0;
  public static final int LEVEL_MEMBER = 0;
  
  /* 2) 파라미터 변수를 상수로 선언
   * 파라미터 변수는 외부에서 전달한 값을 보관하는 변수
   * 메서드안에서 파라미터 변수를 임의로 변경하지 못하도록 막는것이 좋다.*/
  public void m1(final int a, final String b, final Object obj, final boolean c) {
    // final으로 선언된 파라미터는 오직 조회용으로만 사용
    a = 20; // Error!
    b = "hello"; // Error!
    obj = new java.util.Date(); // Error!
    c = true; // Error!
  }

}
