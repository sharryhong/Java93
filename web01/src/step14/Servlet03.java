/* 파일 업로드 : apache file-upload 라이브러리를 사용하여 파일업로드 처리
 */ 
package step14;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step14/Servlet03")
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 멀티파트로 받은 데이터는 아래와 같이 인코딩을 설정해봐야 소용없다. 
//    req.setCharacterEncoding("UTF-8"); // post방식은 이거 빠트리면 한글 깨진다.

    // 멀티파트로 받은 데이터 처리하기 (req.getParameter로 받을 수 없다)
    // 1) 각 파트에 데이터를 가공할 객체 준비 
    DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    
    // 2) 멀티파트로 들어온 데이터를 분석하는 객체 준비
    ServletFileUpload multipartDataParser = new ServletFileUpload(itemFactory);
    
    // 3) 멀티파트 데이터 파서기를 이용하여 요청데이터를 처리하기 (예외처리필요)
    // 리턴 : itemFactory객체가 처리한 멀티파트데이터를 리스트로
    // 각각의 파트데이터는 FileItem객체에 담겨있다. 
    try {
      List<FileItem> parts = multipartDataParser.parseRequest(req);
      // 무조건 반복문을 돌려서 찾아야한다. 
      // 이를 편하게 하기 위해 list에 저장된 객체를 맵으로 옮긴다. 
      HashMap<String,FileItem> partMap = new HashMap<>();
      for (FileItem part : parts) {
        partMap.put(part.getFieldName(), part); // 반복문 돌면서 각 파트를 저장한다. 
      }
      // 파라미터의 값 꺼내기. 
      // FileItem에서 UTF-8로 인코딩된 값 꺼낼때는 각각 인코딩 처리해야한다.
      FileItem part = partMap.get("name");
      String name = part.getString("UTF-8");
      // file의 경우 원래의 이름을 꺼내려면 getName()을 호출해야한다. 
      String file1 = partMap.get("file1").getName();
      String file2 = partMap.get("file2").getName();
      
      resp.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = resp.getWriter(); // 출력도구를 response객체로부터 꺼내서
      out.printf("name=%s\n", name);
      out.printf("file1=%s\n", file1);
      out.printf("file2=%s\n", file2);
      
    } catch (Exception e) {
      throw new ServletException(e); // doPost가 ServletException을 던지므로. 예외를 ServletException에 담아서 보낸다.
    }
    
  }
}
