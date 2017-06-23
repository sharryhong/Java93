/* 스프링 사용법 : setter(셋터) 호출하기 */
package step27.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex2/application-context-04.xml");
    
    // 객체의 scope가 singleton인경우 getBean()은 항상 존재하는 객체 리턴. 
    // 위의 코드를 실행하면 이미 객체가 생성되어 있다. 
    System.out.println(ctx.getBean("c1")); // 이미 만들어져있고, 컨테이너에서 꺼내서 쓰는 것이다. 
    System.out.println(ctx.getBean("c2"));
  }
}
