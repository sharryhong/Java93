/* 스프링 사용법 : 팩토리 메서드 호출하기 3. Spring IoC 컨테이너를 이용하여 팩토리메서드 사용하기 */
package step27.ex3;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex3/application-context-03.xml");
    
    System.out.println(ctx.getBean("c1"));
  }
}
