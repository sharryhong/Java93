/* nested class
 * => 종류
 * 4) anonymous(익명) class
 * => 클래스를 정의할 때 이름이 없기 때문에, 클래스를 정의한 후 나중에 따로 인스턴스를 생성할 수 없다. 
 * 클래스를 정의하자마자 바로 인스턴스를 생성해야한다. 
 * 보통 클래스를 딱 한번만 사용할 경우에 적합한 문법이다. 
 * => 문법
 * 가) 참조변수 선언 = new 수퍼클래스이름(수퍼클래스의 생성자호출 파라미터) {...} 
 * 가) 참조변수 선언 = new 인터페이스이름(수퍼클래스의 생성자호출 파라미터) {...} 
s */
package step13;

import java.lang.reflect.Method;

public class Test05_1 {
  public static void main(String[] args) throws Exception{
    // 1) Object를 상속받은 익명 클래스 만들기 
    Object obj = new Object() { // 클래스 이름이 없으니까 extends도 빼고.. 수퍼클래스 이름 적기
      int value;
      // 클래스 이름이 없기 때문에 생성자를 만들 수 없다. 
      // 이 경우, 인스턴스 변수를 초기화시키는 적절한 방법은 인스턴스 블록을 사용
      {
        System.out.println("인스턴스 블록..");
        value = 100;
      }
      public void m1() {
        System.out.println("m1()..");
        System.out.println(value);
      }
    };
    
    // 문제 : 수퍼클래스에 없는 메서드를 익명클래스에 추가(m1())했을 때 어떻게 호출할 것인가?
//    obj.m1(); // Error!
                // 컴파일러는 오직 obj변수의 타입(클래스)만 보고 메서드를 찾는다. 
    // ==> 호출할 방법이 없나?? 있다!
    // Class정보를 전문적으로 분석해주는 도구를 이용하여 메서드를 찾는다. 
    Class clazz = obj.getClass(); // class는 키워드이므로 변수명을 class와 비슷한 clazz를 많이쓴다. 
    Method m = clazz.getMethod("m1"); // m1이라는 메서드를 찾아줘
    m.invoke(obj); 
    // => 나중에 제대로 배움 
  }
  
}
