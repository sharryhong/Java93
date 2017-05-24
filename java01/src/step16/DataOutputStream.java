/* Binary File I/O : 바이트 스트림 클래스 - MyDataOutputStream
 * => FileOutputStream을 상속받아 다양한 타입의 값을 출력하는 기능을 추가한다. 
 */
package step16;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream {
  OutputStream out; // 
  
  public DataOutputStream(OutputStream out) {
    this.out = out;
  }

  public void writeByte(int b) throws IOException {
    out.write(b);
  }
  
  public void writeShort(int b) throws IOException {
    out.write(b >> 8);
    out.write(b);
  }
  
  public void writeInt(int b) throws IOException {
    out.write(b >> 24);
    out.write(b >> 16);
    out.write(b >> 8);
    out.write(b);
  }
  
  public void writeUTF(String str) throws IOException {
    byte[] bytes = str.getBytes("UTF-8");
    int len = bytes.length;
    // 보통 문자열 크기를 2byte크기로 잡는다(6만5천넘지않는다고 가정)
    out.write(len >> 8);
    out.write(len);
    out.write(bytes);
  }
  
  public void close() throws IOException {
    out.close();
  }
}
