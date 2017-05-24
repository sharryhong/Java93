/* Binary File I/O (바이너리 파일 입출력) - FileInputStream
 */
package step16;

import java.io.File;
import java.io.FileInputStream;

public class Test02_2_in {

  public static void main(String[] args) throws Exception { 
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test02_2.data");
    
    // 바이트 배열을 저장할 메모리 준비 
    byte[] bytes = new byte[1024]; // 보통 이렇게 1kbyte단위로 준비한다. 
    // 읽은 갯수 저장
    int len = 0;
    
    len = in.read(bytes); // 바이트 배열의 값 저장할 수 있는 메모리 주소를 준다.
                          // 리턴값 : 파일에서 실제로 읽은 바이트 갯수 
    for (int i = 0; i < len; i++) {
      System.out.printf("%x ", bytes[i]);
    }
    
    in.close();
  }
}
