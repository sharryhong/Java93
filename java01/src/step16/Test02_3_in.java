/* Binary File I/O : 바이트 스트림 클래스 
 * => 바이트 배열을 읽은 후 저장할 위치를 지정하기 
 */
package step16;

import java.io.File;
import java.io.FileInputStream;

public class Test02_3_in {

  public static void main(String[] args) throws Exception { 
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test02_3.data");
    
    // 바이트 배열을 저장할 메모리 준비 
    byte[] bytes = new byte[1024]; // 보통 이렇게 1kbyte단위로 준비한다. 
    // 읽은 갯수 저장
    int len = 0;
    
    // read(배열주소, offset, length)
    // => 배열주소 : 데이터를 저장할 배열
    // => offset : 저장할 위치(index. 0부터 시작)
    // => length : 희망하는 읽을 바이트 수 .. Why? "희망"이라고 했는가?
    //             크기가 클 경우 다 읽지 않을 수 있다. 따라서 항상 읽은 바이트를 체크해야한다. 
    // => 리턴 값 : 실제 읽은 바이트 수
    len = in.read(bytes, 5, 2); // 5번째 방에 2개만 읽는다. 
    
    for (int i = 0; i < 10; i++) {
      System.out.printf("%x ", bytes[i]);
    }
    
    in.close();
  }
}
