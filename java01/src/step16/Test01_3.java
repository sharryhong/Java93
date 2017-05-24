/* File 다루기 - File 클래스 사용법 3  */
package step16;

import java.io.File;

public class Test01_3 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    
    String[] files = f.list();  // workspace폴더에 있는 폴더, 파일명 목록 리턴
    
    for (String name : files) {
      System.out.println(name);
    }
  }

}
