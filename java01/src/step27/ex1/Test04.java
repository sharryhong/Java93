/* 스프링 사용법 : 객체 생성 정책 */
package step27.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex1/application-context-03.xml");
    
    Object obj1 = ctx.getBean("c1");
    Object obj2 = ctx.getBean("c1");
    if (obj1 == obj2) System.out.println("obj1 == obj2"); // 출력된다 . 객체를 하나만 만들어서 공유하기 때문이다 .
    
    Object obj3 = ctx.getBean("c2");
    Object obj4 = ctx.getBean("c2");
    if (obj3 == obj4) System.out.println("obj3 == obj4"); // c2도 싱글톤이므로 출력됨
    
    Object obj5 = ctx.getBean("c3");
    Object obj6 = ctx.getBean("c3");
    if (obj5 == obj6) System.out.println("obj5 == obj6"); // 출력안된다. getBean()호출할때마다 객체를 생성하므로
  }
}
 