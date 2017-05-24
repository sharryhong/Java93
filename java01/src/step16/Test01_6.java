/* File 다루기 - File 클래스 사용법 6 
 * => 특정 확장자를 가진 파일만 출력하기 1) 무식하게해보자. */
package step16;

import java.io.File;

public class Test01_6 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    displayDirectory(f);
  }

  public static void displayDirectory(File dir) {
    File[] files = dir.listFiles(); 
    
    // 이 방식의 문제점 
    // 목록에서 특정 확장자를 가진 파일을 걸러내어 처리한다. 
    // 목록의 개수만큼 반복문을 돌려야한다. 
    for (File file : files) {
      if (file.isFile() && file.getName().endsWith(".class")) { // 파일이름이 .class라면
        System.out.printf("%s\n", file.getPath());
      } 
      
      if (file.isDirectory()) // 또 디렉토이 있으면 실행
        displayDirectory(file);
    }
  }
}
