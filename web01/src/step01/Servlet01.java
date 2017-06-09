/* 웹 애플리케이션 컴포넌트 - 서블릿 만들기 1 - Servlet 인터페이스 구현
 * => 웹 애플리케이션을 구성하고 있는 구성요소 
 */
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 1)  url패턴 지정하기
//@WebServlet(urlPatterns="/step01/Servlet01")

// 2) urlPatterns는 배열이기 때문에 정확하게 배열의 형태로 값 지정하기
//@WebServlet(urlPatterns={"/step01/Servlet01"}) // 값이 하나라서 {}를 생략했던 것임

// 3) 여러개의 url을 지정해보자.
//@WebServlet(urlPatterns={"/step01/Servlet01", "/step01/Servlet01_a", "/step01/Servlet01_b"})

// 4) urlPatterns 대신 value 속성에 지정해도 된다. 두개의 속성은 같은 역할
//@WebServlet(value="/step01/Servlet01")

//4) value 속성으로 url을 지정할 경우, value이름을 생략할 수 있다. 
@WebServlet("/step01/Servlet01") // 실무에선 이렇게 많이 사용한다. 

// 두개 이상의 속성 값을 지정하는 경우 value 생략 불가
//@WebServlet(value="/step01/Servlet01", loadOnStartup=1)

public class Servlet01 implements Servlet{
  public Servlet01() {
    System.out.println("Servlet01.HelloServlet()");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet01.init()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet01.getServletConfig()");
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet01.service()");
    
  }

  @Override
  public String getServletInfo() {
    System.out.println("Servlet01.getServletInfo()");
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("Servlet01.destroy()");
    
  }
}
