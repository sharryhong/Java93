/* 명령창
* > java ...  BIT_ls
* 출력형식 :   d    디렉토리명   크기
*              -    파일명       크기
*/
import java.io.File;
import java.io.IOException;

public class BIT_ls {

  public static void main(String[] args) throws IOException {
    
    File f = new File("./");
    File[] files = f.listFiles();
    System.out.println(f.getCanonicalPath());
    
    for (File file : files) {
      System.out.printf("%s %s %dbyte\n", 
          (file.isDirectory() ? "d" : "-"),
          file.getName(),
          file.length());
    }
  }

}
