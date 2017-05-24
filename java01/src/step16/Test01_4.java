/* File 다루기 - File 클래스 사용법 4  */
package step16;

import java.io.File;

public class Test01_4 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    
    File[] files = f.listFiles();  // workspace폴더에 있는 파일 및 하위폴더에 대한 정보를 담은 File 객체목록 리턴
    
    for (File file : files) {
      System.out.printf("%s %12d %s\n",
          (file.isDirectory() ? "d":"-"),
          file.length(),
          file.getName());
    }
  }

}
