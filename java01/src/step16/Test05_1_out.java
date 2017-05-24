/* Data Processing Stream 클래스 - ObjectOutputStream 도입 전 
 * => 객체 출력하기
 */
package step16;

import java.io.FileOutputStream;

public class Test05_1_out {

  public static void main(String[] args) throws Exception {
    
    Student s = new Student("홍길동", 100, 90, 80, false);
    
    FileOutputStream out0 = new FileOutputStream("temp/test05_1.data");
    java.io.DataOutputStream out = new java.io.DataOutputStream(out0); // 다양한 타입 출력위해
    // java.io 패키지 적지 않으면 우리가 만든 클래스 사용하므로
    
    // 객체 출력 
    out.writeUTF(s.name);
    out.writeInt(s.kor);
    out.writeInt(s.eng);
    out.writeInt(s.math);
    out.writeInt(s.sum);
    out.writeFloat(s.aver);
    out.writeBoolean(s.working);
    
    out.close();
    out0.close();
  }
}
