/* Binary File I/O : 바이트 스트림 클래스 - DataOutputStream
 * => 상속이 아닌 "위임"이라는 방법을 사용해서 기능 확장하기 
 */
package step16;

import java.io.File;
import java.io.FileOutputStream;

public class Test02_6_out {

  private static int str2;

  public static void main(String[] args) throws Exception { 
    FileOutputStream out0 = new FileOutputStream("test02_6.data");
    DataOutputStream out = new DataOutputStream(out0);
    
    byte b = 0x11;
    short s = 0x2233;
    int i = 0x44556677;
    String str = "ABC가각간"; 
    
    out.writeByte(b);
    out.writeShort(s);
    out.writeInt(i);
    out.writeUTF(str);

    out.close();
    System.out.println("파일 출력 완료!");
  }
}
