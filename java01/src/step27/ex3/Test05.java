/* 스프링 사용법 : 팩토리 메서드 호출하기 5 - 스프링에서 제공하는 규칙에 따라 factory method만들기 */
package step27.ex3;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex3/application-context-05.xml");
    
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
    System.out.println(ctx.getBean("c3"));
  }
}
