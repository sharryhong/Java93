/* 유틸리티 응용 - properties 클래스 응용 */
package step08;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test08_2 {

  public static void main(String[] args) throws Exception {
    // JVM의 프로퍼티 값을 가져온다. JVM에 있는 시스템 정보를 출력해보자. 
    Properties props = System.getProperties();
    
    Set<Object> keySet = props.keySet(); // set의 수퍼인터페이스가 collection이므로 
    for (Object key : keySet) { // collection type이 올 수 있는데 쓸 수 있다. 
      System.out.printf("%s=%s\n", key, props.get(key));
      
    }
  }
  
}

