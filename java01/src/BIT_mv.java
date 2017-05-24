/* 명령창
* > ... BIT_mv 소스파일명 목적파일명
* 소스파일명을 목적파일명으로 파일명 변경
*/
import java.io.File;

public class BIT_mv {

  public static void main(String[] args) {
    String file1 = args[0];
    String file2 = args[1];
    
    File f1 = new File(file1);
    File f2 = new File(file2);
    
    if (f1.exists()) {
      f1.renameTo(f2);
    }

  }

}
