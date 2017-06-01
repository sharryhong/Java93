/* 웹 애플리케이션 실행하기 
 * 1) ex7 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) ex8 클라이언트가 요청한 자원을 처리한다.
 * 3) ex9 HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) ex10 Command 패턴 적용
 * 5) ex11 서블릿 객체 생성 자동화
 * 6) ex12 애노테이션을 적용하여 servlet객체 생성 자동화
 */
package step23.ex12;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpServer {
  int port;
  
  HashMap<String, Command> servletMap = new HashMap<>();
  
  // bin 디렉토리 경로
  String currBinDirPath;
  
  // 클래스 도구를 저장할 목록
  ArrayList<Class> classes = new ArrayList<>();
   
  public HttpServer(int port) throws Exception {
    this.port = port;
    
    // 클래스 파일이 있는 bin 디렉토리 경로를 계산하여 저장해둔다. 
    // C:\workspace\java01\bin\
    // 정규표현식때문에 \\\\ 네개를 해야한다.
    currBinDirPath = new File("./bin").getCanonicalPath().replaceAll("\\\\", "/") + "/";

    // 지정된 경로의 지정된 패키지 소속 클래스를 찾아 로딩한다. 
    findClassFile(new File("./bin/"), "step23.ex12");
    
    for (Class clazz : classes) {
      // WebServlet.class // .class는 스테틱 변수이다. 이 클래스의 도구가 들어있다. 
      WebServlet anno = (WebServlet)clazz.getAnnotation(WebServlet.class);
      if (anno == null) continue; // 애노테이션이 WebServlet이 아니라면
      // anno의 url정보로  
      servletMap.put(anno.url(), (Command)clazz.newInstance());
    }
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  // 전에 배웠던 디렉토리, 폴더 출력하는 메서드.
  private void findClassFile(File path, String packageName) throws Exception {
    // FileFilter는 인터페이스이다. 여기에 생성자없다. Object의 기본생성자 호출
    // 람다 : 메소드가 딱 하나이므로 여기서 가능 
    // accept().. true인 것만 files에 넣는다.
    File[] files = path.listFiles((File pathname) -> {
        if (pathname.isDirectory())
          return true;
        // indexOf('$')가 있으면 이너클래스이다. < 0 라는 것은 이너클래스가 아니다. 
        if (pathname.getName().endsWith(".class") && pathname.getName().indexOf('$') < 0)
          return true;
        return false;
      });
    
    for (File file : files) {
      if (file.isDirectory())
        findClassFile(file, packageName); // 재귀호출
      else {
        // class명을 얻자!
        String classFullName = file.getCanonicalPath()
                               .replaceAll("\\\\", "/") // windows에서는 문제가되므로 경로를 \로 바꾼다.
                               .replaceAll(this.currBinDirPath, "")
                               .replaceAll("/",  ".")
                               .replaceAll(".class", ""); 
        if (classFullName.startsWith(packageName)) {
          classes.add(Class.forName(classFullName)); // 로딩된 클래스를 다루는 도구를 보관한다.
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }

}
