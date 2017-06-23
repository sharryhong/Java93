/* 파일 업로드 : apache file-upload 라이브러리를 사용하여 파일업로드 처리
 */ 
package step14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step14/Servlet04")
@SuppressWarnings("serial")
public class Servlet04 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    
    ServletFileUpload multipartDataParser = new ServletFileUpload(itemFactory);
    
    try {
      List<FileItem> parts = multipartDataParser.parseRequest(req);
      HashMap<String,FileItem> partMap = new HashMap<>();
      for (FileItem part : parts) {
        partMap.put(part.getFieldName(), part);
      }
      String name = partMap.get("name").getString("UTF-8");
      //
      FileItem part = partMap.get("file1");
      String file1 = part.getName(); // 오리지널 파일명(클라이언트가 사용한 이름) 꺼내기. 한글파일명안됨
      ServletContext sc = this.getServletContext();
      // 현재 웹애플리케이션의 폴더위치를 기준으로 경로 계산
      // ServletContext의 getRealPath() 호출
      File uploadPath = new File(sc.getRealPath("/step14/upload/" + file1));
      // 클라이언트가 보낸 파일은 임시 폴더에 보관되어 있다. 
      // 보관된 데이터를 우리가 지정하는 폴더로 옮겨라.
      part.write(uploadPath);
      
      part = partMap.get("file2");
      String file2 = part.getName();
      uploadPath = new File(sc.getRealPath("/step14/upload/" + file2)); // 저장할 장소준비
      part.write(uploadPath); 
      
      resp.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = resp.getWriter();
      out.printf("name=%s\n", name);
      out.printf("file1=%s\n", file1);
      out.printf("file2=%s\n", file2);
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
}
