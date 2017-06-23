/* 스프링 사용법 : 객체 생성하기 */
package step27.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("step27/ex1/application-context-01.xml");
    
    // getBean(bean의 id)
    Car obj1 = (Car)ctx.getBean("c1");
    System.out.println(obj1);  // Car [model=기본자동차, cc=900]
    
    // getBean(id or name(별명))
    Car obj2 = (Car)ctx.getBean("c2");
    Car obj3 = (Car)ctx.getBean("c3");
    Car obj4 = (Car)ctx.getBean("c4");
    Car obj5 = (Car)ctx.getBean("c5");
    
    if (obj2 == obj5) {
      System.out.println("c2, c5 모두 같은 객체이다.");  // 출력
    }
    
    System.out.println(ctx.getBean("c6"));  // Car [model=기본자동차, cc=900]
    System.out.println(ctx.getBean("c7"));  // Car [model=기본자동차, cc=900]
    System.out.println(ctx.getBean("c8"));  // Car [model=기본자동차, cc=900]
    
    String[] aliases = ctx.getAliases("c7");
    for (String alias : aliases) {
      System.out.println(alias); // c8, c9
    }
    
    System.out.println(ctx.getBean("c10 c11 c12"));  // Car [model=기본자동차, cc=900]
  }
}
 