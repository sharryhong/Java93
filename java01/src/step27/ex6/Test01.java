/* 스프링 사용법 : @Autowired 애노테이션 사용하기
 *  2. xml설정파일에서 직접 의존객체를 주입하는 대신, 
 *  @Autowired를 이용하여 의존 객체 주입을 자동화 시키기 */
package step27.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex6/application-context-01.xml");
    
    System.out.println("------------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기 
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }

  }
}