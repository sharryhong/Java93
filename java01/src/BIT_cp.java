/* 명령창
* > ... BIT_cp 소스파일명 목적파일명
* 소스파일을 목적파일로 파일 복사
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BIT_cp {

  public static void main(String[] args) throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;
    
    String file1 = args[0];
    String file2 = args[1];
    
    try {
      in = new FileInputStream(file1);
      out = new FileOutputStream(file2);
      
      byte[] buf = new byte[8192];
      int count = 0;
      
      while ((count = in.read(buf)) != -1) {
        out.write(buf, 0, count);
      }
      
    } catch (Exception e) {

    } finally {
      in.close();
      out.close();
    }

  }

}
