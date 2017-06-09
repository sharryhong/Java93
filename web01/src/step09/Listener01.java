/* 리스너 1 - ServletContextListener 인터페이스 
 * => 웹 애플리케이션이 시작되거나 종료되는 상태에 대해 작업 수행
 * 
 * 리스너를 만들었으면 리스너를 배치해야한다. 두가지 방법
 * 1) web.xml에 등록하기
 * 2) 애노테이션으로 등록하기 
 */
package step09;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener01 implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("===> Listener01.contextInitialized()");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("===> Listener01.contextDestroyed()");
  }
}
