/* 스프링 사용법 : @Component를 붙일 때 이름을 지정하지 않으면?
 */
package step27.ex13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex13/application-context-01.xml");
    
    System.out.println("------------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기 
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s => %s\n", name, ctx.getBean(name));
    }
    
    System.out.println("------------------------------------------");
    // 별명
    names = ctx.getAliases("step27.ex13.Car2#0");
    for (String name : names) {
      System.out.printf("%s => %s\n", name, ctx.getBean(name));
    }

  }
}