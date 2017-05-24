/* File I/O : 바이트 스트림 클래스 - FileInputStream
 * => FileInputStream을 상속받아 다양한 타입의 데이터를 읽을 수 있는 기능 추가
 */
package step16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyDataInputStream extends FileInputStream {

  public MyDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }
  
  public byte readByte() throws IOException {
    return (byte)this.read();
  }
  
  public short readShort() throws IOException {
    short s;
    s = (short)(this.read() << 8);
    s |= (short)this.read();
    return s;
  }
  
  public int readInt() throws IOException {
    int i;
    i = this.read() << 24;
    i |= this.read() << 16;
    i |= this.read() << 8;
    i |= this.read();
    return i;
  }
  
  public String readUTF() throws IOException {
    int len;
    len = this.read() << 8;
    len |= this.read();
    byte[] buf = new byte[len]; // buffer의 약자
    this.read(buf);
    return new String(buf, "UTF-8");
  }

}
