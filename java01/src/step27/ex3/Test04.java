/* 스프링 사용법 : 팩토리 메서드 호출하기 4*/
package step27.ex3;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex3/application-context-04.xml");
    
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
    System.out.println(ctx.getBean("c3"));
  }
}