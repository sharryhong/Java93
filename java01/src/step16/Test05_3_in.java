/* Data Processing Stream 클래스 - 직렬화와 transient 변경자 
 */
package step16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test05_3_in {

  public static void main(String[] args) throws Exception { 

    FileInputStream in0 = new FileInputStream("temp/test05_3.data");
    ObjectInputStream in = new ObjectInputStream(in0);
     
    Student3 s = (Student3)in.readObject();
    
    in.close();
    in0.close();
    
    System.out.println(s); // 계산수행 전 sum=0, aver=0.0
    s.compute(); // 직렬화된 데이터를 읽어들인후에 transient로 지정된 변수의 값을 계산
    System.out.println(s); // 계산수행 후 sum=270, aver=90.0
  }
}
