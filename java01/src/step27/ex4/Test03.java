/* 스프링 사용법 : 커스텀 프로퍼티 만들고 사용하기 3 */
package step27.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex4/application-context-03.xml");
    
    System.out.println(ctx.getBean("c1"));

  }
}