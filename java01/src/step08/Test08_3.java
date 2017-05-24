/* 유틸리티 응용 - properties 클래스 응용 2 */
package step08;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test08_3 {

  public static void main(String[] args) throws Exception {
    // 1) 프로그램 아규먼트 출력
    for (String value : args) {
      System.out.println(value);
    }
    System.out.println("--------------------------");
    
    // 2) JVM의 프로퍼티 출력
    Properties props = System.getProperties();
    System.out.printf("name=%s\n", props.get("name"));
    System.out.printf("age=%s\n", props.get("age"));
    System.out.printf("tel.home=%s\n", props.get("tel.home")); // 점도 이름의 일부이다.
    System.out.printf("tel.office=%s\n", props.get("tel.office"));
  }
  
}

