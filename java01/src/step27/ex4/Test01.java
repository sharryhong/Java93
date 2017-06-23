/* 스프링 사용법 : 커스텀 프로퍼티 만들고 사용하기 */
package step27.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex4/application-context-01.xml");
    
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기 
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name)); // names 엔 t1하나 들어있다. 
    }

  }
}