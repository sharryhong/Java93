package bitcamp.java93.control;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;
import bitcamp.java93.util.MultipartFormDataProcessor;

@Component("/teacher/add")
public class TeacherAddControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    Map<String,FileItem> partMap = MultipartFormDataProcessor.parse(req);
    
    Teacher t = new Teacher();
    t.setName(partMap.get("name").getString("UTF-8"));
    t.setTel(partMap.get("tel").getString("UTF-8"));
    t.setEmail(partMap.get("email").getString("UTF-8"));
    t.setPassword(partMap.get("password").getString("UTF-8"));
    t.setHomepage(partMap.get("homepage").getString("UTF-8"));
    t.setFacebook(partMap.get("facebook").getString("UTF-8"));
    t.setTwitter(partMap.get("twitter").getString("UTF-8"));
    
    // 사진 데이터 처리
    ArrayList<String> photoList = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
      FileItem fileItem = partMap.get("photo" + i);
      if (fileItem.getSize() > 0) { // 파일이 업로드 된 경우
        File file = new File(req.getServletContext().getRealPath(
            "/teacher/photo/" + fileItem.getName()));
        fileItem.write(file);
        photoList.add(fileItem.getName());
      }
    }
    
    // 사진 파일의 이름이 저장된 photoList를 Teacher 담는다.
    t.setPhotoList(photoList);
    
    teacherService.add(t);
    
    return "redirect:list.do";  
  }
}









