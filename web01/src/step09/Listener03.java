/* 리스너 3 - ServletRequestAttributeListener 인터페이스 
 * => 
 */
package step09;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener03 implements ServletRequestAttributeListener {

  @Override
  public void attributeAdded(ServletRequestAttributeEvent sce) {
    // ServletRequest 객체에 값을 저장할 때 호출
    // 즉, req.setAttribute(..)를 호출할 때 
    System.out.printf("===> Listener03.attributeAdded(): %s=%s\n", sce.getName(), sce.getValue());
  }

  @Override
  public void attributeRemoved(ServletRequestAttributeEvent srae) {
    // ServletRequest 객체에서 값을 제거할 때 호출
    System.out.println("===> Listener03.attributeRemoved()");
  }

  @Override
  public void attributeReplaced(ServletRequestAttributeEvent srae) {
    // ServletRequest 객체에 저장된 값을 변경할 때 호출
    System.out.println("===> Listener03.attributeReplaced()");
  }

}
