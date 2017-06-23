package bitcamp.java93.control;
/* ServletContext 보관소에 저장된 MemberDao 이용하기 
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Component("/teacher/list")
public class TeacherListControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int pageNo = 1;
    int pageSize = 5;
    
    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다.
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try { // pageSize 파리미터 값이 있다면 그 값으로 설정한다.
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
 
    
     //try, catch 제거
      List<Teacher> list = teacherService.list(pageNo, pageSize);
      req.setAttribute("list", list);

      //야 dispacher야 view에 tescher/list.jsp 로 실행시켜줘
      //req.setAttribute("view", "/teacher/list.jsp");
     return "/teacher/list.jsp";

      //인쿨르드 실행 끝나면 Dispatcher로 이동
      //포워딩하는 공통코드 제거
    
    
  }
}
