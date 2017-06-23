/* 접근제어자 어느 경우까지 뽑아지는지 알아내기 위한 코드 */
package step26;

public class MyClass extends MySuper {
  // 필드
  public int publicVar;
  String defaultVar;
  protected boolean protectedVar;
  private float privateVar;
  
  // 생성자
  public MyClass() {}
  public MyClass(int p1) {}
  public MyClass(String p1, int p2) {}
  
  // 메서드
  public void publicM() {}
  void defaultM() {}
  protected void protectedM() {}
  private void privateM() {}
  
  public void m1() {}
  public void m2(int p1) {}
  public void m3(String p1, int p2) {}
}
