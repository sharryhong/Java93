/* 캡슐화 : 중첩클래스( nested class )에 붙일 수 있는 modifier의 종류
 * => 클래스 안에 선언된 클래스를 중첩클래스라고 부른다. 또는 내부클래스(inner class)라고도 부른다.
 * 이너클래스도 클래스의 멤버이므로, 똑같이 modifier를 사용할 수 있다.  
 */
package step11;

public class Test08 { // 가장 바깥 클래스를 "패키지 맴버 클래스"라 부른다. => public, default만 가능
  
//inner class 들은 모두 가능 
  private class Inner1 {}  
  class Inner2 {}
  protected class Inner3 {}
  public class Inner4 {} 

  public static void main(String[] args) {
    // 메서드 안에 선언된 inner class는 로컬변수와 똑같이 private, protected, public modifier들을 사용할 수 없다. 
    class Local1 {} // ok
//    private Local2 {} // Error!
//    protected Local3 {} // Error!
//    public Local4 {} // Error!
  }

}
