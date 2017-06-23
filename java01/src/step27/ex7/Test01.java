/* 스프링 사용법 : @Autowired 애노테이션 사용하기 3
 * @Autowired를 setter메서드에 붙이지 않고 필드 선언에 붙이는 방법 
 */
package step27.ex7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex7/application-context-01.xml");
    
    System.out.println("------------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기 
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }

  }
}