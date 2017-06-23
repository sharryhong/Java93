/* 스프링 사용법 : @Qualifier 애노테이션 사용하기
 */
package step27.ex10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex10/application-context-01.xml");
    
    System.out.println("------------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기 
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }

  }
}