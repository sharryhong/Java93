/* Data Processing Stream 클래스 - ObjectOutputStream 도입 후 
 * => 객체 출력하기
 */
package step16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test05_2_out {

  public static void main(String[] args) throws Exception {
    
    Student2 s = new Student2("홍길동", 100, 90, 80, false);
    
    FileOutputStream out0 = new FileOutputStream("temp/test05_1.data");
    ObjectOutputStream out = new ObjectOutputStream(out0); 
    
    // 객체 출력 
    // => 인스턴스의 값들을 바이트 배열로 만들어 출력한다. 
    // "Serializable = marshaling (직렬화)" 라고 한다.  
    //    인스턴스를 바이트 배열화
    // "Deserializable = unmarshaling" (객체로 복원)
    //    바이트 배열 -> 인스턴스 
    // 주의! 
    // 직렬화가 가능한 클래스는 java.io.Serializable규격을 따르는 클래스이다. 
    // 일반 클래스는 인스턴스를 바로 출력할 수 없다. 보안때문
    out.writeObject(s);
    
    out.close();
    out0.close();
  }
}
