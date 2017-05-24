/* Data Processing Stream 클래스 - ObjectInputStream 도입 후 
 * => 직렬화를 통해 출력된 데이터의 경우 역직렬화를 통해 객체로 복원시킬 수 있다. 
 */
package step16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test05_2_in {

  public static void main(String[] args) throws Exception { 

    FileInputStream in0 = new FileInputStream("temp/test05_1.data");
    ObjectInputStream in = new ObjectInputStream(in0);
     
    // 타입캐스팅 하는 이유 : 리턴값이 어떤 클래스의 인스턴스인지 알려줘야한다. 
    Student2 s = (Student2)in.readObject();
    
    in.close();
    in0.close();
    
    System.out.println(s);
  }
}
