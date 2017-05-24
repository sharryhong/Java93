/* nested class
* (non-static) nested class = inner class 
* inner 클래스에서 바깥 클래스의 변수 사용하기  
*/
package step13;

public class Test03_2 {
  int v1;
  int v2;
  
  class A {
    int v1;
    public void m1() {
      this.v1 = 100;
      System.out.printf("A.v1=%d\n", this.v1); // 100
      
      // inner class에서 바깥 클래스의 인스턴스변수를 사용해보자.
      // inner class도 인스턴스 멤버이므로, 그냥 바깥 클래스의 인스턴스 멤버를 마음대로 사용할 수 있다. 
      // this.v2라고 하면 A객체의 멤버로 간주하므로 Error
      System.out.printf("Test03_2.v2=%d\n", v2);
      
      // A에도 v1변수가 있고, 바깥클래스에도 v1변수가 있을때 어떻게 바깥클래스의 v1변수를 사용할까?
      // 완전한 이름을 모두 적는다. Test03_2.this.xx
      System.out.printf("Test03_2.v2=%d\n", Test03_2.this.v2);
    }
  }
  
  public void test() {
    A p = new A();
    p.m1();
    System.out.printf("v1=%d, v2=%d\n", this.v1, this.v2); // 10, 20
  }
  
  public static void main(String[] args) {
    Test03_2 obj = new Test03_2();
    obj.v1 = 10;
    obj.v2 = 20;
    obj.test();
  }
}
