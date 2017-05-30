/* 인터페이스 1
 * 
 */
package step21.ex8;

public interface A {
  //
  public abstract void m1();
  
  // 
  abstract void m2();
  
  // 
  void m3();
  
//  void m4() {} // Error!
  
  // 필드
  public static final int v1 = 200;
  
  //
  static final int v2 = 200;
  
  //
  final int v3 = 200;
  
  // 
  int v4 = 200;
}
