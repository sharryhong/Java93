/* 스프링 사용법 : Spring IoC 컨테이너 준비 2 - 스프링 라이브러리 준비 */
package step27.ex1;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) throws Exception {
    // 1) Spring 설정 파일 준비
    // => application-context-01.xml
    
    // 2) 설정 파일 경로를 절대 경로로 지정할 때
    File file = new File("src/step27/ex1/application-context-01.xml");
   // System.out.println(file.getCanonicalPath()); // 절대 경로 : C:\workspace\java01\step27\ex1\application-context-01.xml
    ApplicationContext ctx = new FileSystemXmlApplicationContext("file:" + file.getCanonicalPath());
  }
}
 