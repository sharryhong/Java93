/* Binary File I/O : 바이트 스트림 클래스 - DataOutputStream
 * => 자바에서 제공해주는 클래스 사용 
 */
package step16;

import java.io.FileOutputStream;

public class Test02_7_out {

  private static int str2;

  public static void main(String[] args) throws Exception { 
    FileOutputStream out0 = new FileOutputStream("test02_7.data");
    java.io.DataOutputStream out = new java.io.DataOutputStream(out0);
    
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
