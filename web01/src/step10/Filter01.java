/* 웹 애플리케이션 구성요소 중 Filter
 * => 요청이 들어왔을 때 서블릿에 전달하기 전에 작업 수행
 * => 서블릿이 요청을 처리한 후에 작업 수행 */
package step10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/step10/*")
public class Filter01 implements Filter { // 이 인터페이스 하나이다. 

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // 필터 객체가 생성될 때 호출된다.
    // 웹 애플리케이션이 시작된 후 딱 한번만 호출된다. 
    // 필터가 작업을 하는데 필요한 자원을 준비시키는 코드를 여기에 둔다.
    System.out.println("##### Filter01.init()");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 필터가 적용될 때마다 호출된다. 
    System.out.println("Filter01.doFilter() 시작---------------");
    
    // 이 메서드에서 다음 필터를 실행해야한다. 그래야 서블릿까지 실행될 수 있다. 
    // chain 객체에 대해 doFilter()를 호출하면 
    // => 다음필터가 있다면 그 필터를 실행하고,
    // => 다음필터가 없다면 최종목적지인 서블릿으로 보낸다. 
    chain.doFilter(request, response);
    
    // 서블릿까지 실행을 완료한 후 리턴된다. 
    System.out.println("---------------Filter01.doFilter() 끝");
  }

  @Override
  public void destroy() {
    // 필터 객체가 소멸될 때 호출된다.
    // 웹 애플리케이션이 종료되기 전에 딱 한번만 호출된다. 
    // init()에서 준비한 자원을 해제시키는 코드를 여기에 둔다. 
    System.out.println("##### Filter01.destroy()");
  } 
  
}
