package bitcamp.java93.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java93.control.Controller;

@WebServlet(urlPatterns="*.do")
public class DispatcherServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      String controllerPath = req.getServletPath().replace(".do", ""); // path에서 .do제거 
      res.setContentType("text/html;charset=UTF-8"); // 인클루드 하기 전에 캐릭터셋 설정
      
      ApplicationContext beanContainer = (ApplicationContext)this.getServletContext().getAttribute("beanContainer");
      Controller pageController = (Controller)beanContainer.getBean(controllerPath);
      
      if (pageController == null) {
        throw new ServletException("요청한 URL을 처리할 수 없습니다.");
      }
      // 요청한 URL을 처리할 페이지 컨트롤러가 있다면, 컨트롤러의 service호출 (req, res를 주면서)
      String viewPath = pageController.service(req, res); // 예외발생시 catch로 간다. 
      
      if (viewPath.startsWith("redirect:")) {
        res.sendRedirect(viewPath.replace("redirect:", "")); // 접두어를 뺀 path로 리다이랙트한다.  
        return;
      }
      // 접두어 안붙었다면
      RequestDispatcher rd = req.getRequestDispatcher(viewPath);
      rd.include(req, res); // viewPath를 인크루드 시킨다. 
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.forward(req, res);
      return;
    }
  }
}









