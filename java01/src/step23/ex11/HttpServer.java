/* 웹 애플리케이션 실행하기 
 * 1) ex7 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) ex8 클라이언트가 요청한 자원을 처리한다.
 * 3) ex9 HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) ex10 Command 패턴 적용
 * 5) ex11 서블릿 객체 생성 자동화
 */
package step23.ex11;

import java.io.FileReader;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class HttpServer {
  int port;
  
  //클라이언트 요청을 처리할 객체를 담는다. 
  HashMap<String, Command> servletMap = new HashMap<>();
   
  public HttpServer(int port) throws Exception {
    this.port = port;
     
    Properties props = new Properties();
    // 이클립스에서 프로그램을 실행하면, 항상 현재 폴더는 프로젝트 폴더이다.
    props.load(new FileReader("src/step23/ex11/web.properties"));
    // 반복문을 돌리며 꺼내보자
    // 키값을 문자열로 꺼내보자
    Set<String> urlSet = props.stringPropertyNames();
    for (String url : urlSet) {
      // 굳이 변수를 밖으로 꺼내지 않아도 JVM이 똘똘하게 처리한다.
      String classFullName = props.getProperty(url); // 값 꺼내기.
      // 클래스를 로딩한 후 그 클래스를 다루는 도구를 리턴한다.
      // 문자열을 다루는 클래스는 String이듯, 클래스를 다루는 클래스는 Class
      Class clazz = Class.forName(classFullName); // 클래스 로딩
      // clazz로 만드는 클래스 타입은 모두 Command 인터페이스 규칙으로 만든 것 
      // .newInstance()리턴타입은 Object이다. 실제 들어오는 것들은 Command.. 따라서 타입캐스팅해야한다. 
      servletMap.put(url, (Command)clazz.newInstance()); // 인스턴스 생성
    }
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }

}
