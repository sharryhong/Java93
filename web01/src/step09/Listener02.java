/* 리스너 2 - ServletRequestListener 인터페이스 
 * => 요청이 들어오거나 응답을 완료하는 상태일 때 작업 수행
 */
package step09;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener02 implements ServletRequestListener {

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    // ServletRequest 객체가 생성될 때 호출
    // 즉 클라이언트로부터 요청이 들어올 때 호출
    System.out.println("===> Listener02.requestInitialized()");
  }
  
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // ServletRequest 객체가 소멸되기 직전에 호출
    // 즉 클라이언트에게 응답했을 때 호출
    System.out.println("===> Listener02.requestDestroyed()");
  }

}
