/* Binary File I/O (바이너리 파일 입출력) - FileInputStream
 */
package step16;

import java.io.File;
import java.io.FileInputStream;

public class Test02_1_in {

  public static void main(String[] args) throws Exception { 
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test02_1.data");
    
    // read():int
    // => 무조건 1 바이트만 읽는다.
    // 리턴타입이 int이기 때문에 int타입 변수로 값을 받아야한다. 
    int b = in.read();
    System.out.printf("%x", b);
    
    b = in.read();
    System.out.printf("%x", b);
    
    b = in.read();
    System.out.printf("%x", b);
    
    in.close();
  }
}
