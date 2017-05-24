/* Binary File I/O (바이너리 파일 입출력) - FileOutputStream
 * => 바이트 스트림(byte stream, binary stream) : 중간에 변경없이 바이트 단위 그대로 읽고 쓰는 클래스들
 * => 상속 계층 구조
 *  InputStream : 데이터를 퍼올리는 역할
 *    1) Data Sink Stream 클래스 (데이터를 직접 읽고/쓰는 클래스) 
 *      -> FileInputStream : 파일과 관련
 *      -> ByteArrayStream
 *      -> PipedInputStream
 *    2) Data Processing Stream 클래스 (중간에서 데이터를 가공하는 클래스)
 *      -> BufferdInputStream
 *      -> DataInputStream
 *      -> ObjectInputStream
 *      
 *  OutputStream
 *    1) Data Sink Stream 클래스 (데이터를 직접 읽고/쓰는 클래스)
 *      -> FileOutputStream : 파일과 관련
 *      -> ByteArrayOutputStream
 *      -> PipedOutputStream
 *    2) Data Processing Stream 클래스 (중간에서 데이터를 가공하는 클래스)
 *      -> BufferdOutputStream
 *      -> DataOutputStream
 *      -> ObjectOutputStream
 *      -> PrintStream : 우리가 자주쓰는 print관련
 */
package step16;

import java.io.File;
import java.io.FileOutputStream;

public class Test02_1_out {

  public static void main(String[] args) throws Exception { 
    // 1) FileOutputStream 객체 생성
    FileOutputStream out = new FileOutputStream("test02_1.data");
    
    // write(int) => 무조건 끝 1바이트만 출력. 
    // 1바이트 출력인데 왜 int? 자바에서 기본으로 값을 int로 다룬다. 역사적 배경으로 C언어에서 이렇게 다룬다.  
    out.write(0x66778899); // 99 (16진수 4바이트이지만 끝 1바이트만 출력)
    out.write(0x77445544); // 44
    out.write(0x77445578);  // 78
    
    // 항상 write()를 호출한 다음에 파일을 닫아야한다.
    // 즉, 출력스트림을 모두 사용했으면 파일을 닫기 
    // => 파일을 다루기 위해 준비했던 메모리를 해제시킨다. 
    //    OS 파일시스템과의 연결도 끊는다. 
    out.close();
  }
}
