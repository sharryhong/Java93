/* File I/O : 바이트 스트림 클래스 - FileInputStream
 * => FileInputStream을 상속받아 다양한 타입의 데이터를 읽을 수 있는 기능 추가
 */
package step16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStream {
  InputStream in;

  public DataInputStream(InputStream in) {
    this.in = in;
  }
  
  public byte readByte() throws IOException {
    return (byte)in.read();
  }
  
  public short readShort() throws IOException {
    short s;
    s = (short)(in.read() << 8);
    s |= (short)in.read();
    return s;
  }
  
  public int readInt() throws IOException {
    int i;
    i = in.read() << 24;
    i |= in.read() << 16;
    i |= in.read() << 8;
    i |= in.read();
    return i;
  }
  
  public String readUTF() throws IOException {
    int len;
    len = in.read() << 8;
    len |= in.read();
    byte[] buf = new byte[len]; // buffer의 약자
    in.read(buf);
    return new String(buf, "UTF-8");
  }
  
  public void close() throws IOException {
    in.close();
  }

}
