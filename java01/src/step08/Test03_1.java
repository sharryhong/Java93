/* 유틸리티 클래스 : Object */ 
package step08;

//super클래스를 지정하지않으면 컴파일할 때 자동으로 extends Object가 붙으며, Object가 super클래스가 된다.
public class Test03_1 {   

  // 마찬가지로 수퍼클래스를 지정하지 않으면 Object가 수퍼클래스로 선언된다. 
  static class Student {
    String name;
  }
  
  public static void main(String[] args) {
    // Student class가 정말 Object의 서브 클래스인지 확인해보자. 
    // 어떻게?
    // 서브 클래스라면 수퍼 클래스의 기능을 이용할 수 있어야 할 것이다. 
    Student s = new Student();
    System.out.println(s.toString()); // step08.Test03_1$Student@15db9742 // 16진수로 ID를 표현한 것 
    System.out.println(s.equals(s));
    System.out.println(s.hashCode());
    System.out.println(s.getClass());
  }

}
