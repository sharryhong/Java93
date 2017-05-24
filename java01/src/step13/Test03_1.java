/* nested class
 * => 종류
 * 2) (non-static) nested class = inner class 
 * => 인스턴스 멤버이기 때문에 다른 인스턴스 멤버만이 사용할 수 있다. 
s */
package step13;

public class Test03_1 {
  // 인스턴스 멤버들
  int a;
  public void m1() {} 
  class A { // (non-static) nested class = inner class
    int a;
  }
  
  // 인스턴스 블록 : 인스턴스 멤버 사용가능
  public void test() {
    a = 20;
    m1();
    A obj = new A();
    obj.a = 200;
  }
  
  public static void main(String[] args) {
//    A obj = new A(); // Error! class A는 인스턴스 멤버이다.     
    
    // main()은 static멤버이므로 인스턴스 멤버를 직접 사용할 수 없다.
    // 항상 인스턴스를 만든 후에 사용해야한다. 
//    test(); // Error!
//    a = 30; // Error!
    Test03_1 obj = new Test03_1();
    obj.test(); // ok
    obj.a = 30; // ok
    obj.m1(); // ok
    
    // (non-static) nested class도 인스턴스 멤버이므로 
//    obj.new A(); // ok
    A obj3 = obj.new A(); // 참조변수(obj3)를 선언할 때는 인스턴스 주소가 없어도 된다. 
                          // 그러나 객체를 생성할 때는 인스턴스 주소를 앞에 두고 생성한다. 
                          // 이렇게 잘 사용하진 않는다. 
    
  }

}
