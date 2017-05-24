/* Binary File I/O : 바이트 스트림 클래스 - 바이트 배열의 일부만 출력하기
 */
package step16;

import java.io.File;
import java.io.FileOutputStream;

public class Test02_3_out {

  public static void main(String[] args) throws Exception { 
    FileOutputStream out = new FileOutputStream("test02_3.data");
    
    byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77};
    out.write(bytes, 2, 3); // offset(상대주소) 2번방부터 3개 출력하라.  
    
    out.close();
    System.out.println("파일 출력 완료!");
  }
}
