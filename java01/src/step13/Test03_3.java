/* nested class
* (non-static) nested class = inner class 
* inner 클래스에서 바깥 클래스의 변수 사용하기  
*/
package step13;

public class Test03_3 {
  int v1 = 100;
  
  class A {
    
    int v1 = 200;
    
    public void m1() { // 인스턴스 블록 내에 있다고 생각하면된다. 단, 아래처럼 변수명이 동일할때만 주의
      System.out.printf("A.v1=%d\n", v1); // A의 v1
      System.out.printf("A.v1=%d\n", this.v1); // A의 v1
      System.out.printf("A.v1=%d\n", A.this.v1); // A의 v1
      
      System.out.printf("Test03_3.v1=%d\n", Test03_3.this.v1); // Test03_3의 v1
      
    }
  }
  
  public static void main(String[] args) {
    Test03_3 obj = new Test03_3();
    A obj2 = obj.new A();
    obj2.m1();
  }
}
