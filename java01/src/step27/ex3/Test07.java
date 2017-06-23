/* 스프링 사용법 : java.sql.Date.valueof("2017-06-21") 설정파일에서 static 호출하기 */
package step27.ex3;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
  public static void main(String[] args) {
    
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex3/application-context-07.xml");
    
    //제조일이 등록된 Tire객체를 꺼내 출력한다.
    System.out.println(ctx.getBean("t1"));  

  }
}