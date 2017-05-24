/* properties 파일 사용법 */
package step08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test08_1 {

  public static void main(String[] args) throws Exception {
    Properties props = new Properties();
    // test.properties 파일을 읽어서 그 내용을 보관
    props.load(new FileReader("test.properties"));
    // string사용하여 값 꺼내기
    System.out.println(props.getProperty("key1"));
    System.out.println(props.getProperty("key2"));
    System.out.println(props.getProperty("key3"));
    System.out.println(props.getProperty("key4"));
    
    // Hashtable의 서브클래스이기 때문에 get()/put()사용가능
    System.out.println(props.get("key1"));
    System.out.println(props.get("key2"));
    System.out.println(props.get("key3"));
    System.out.println(props.get("key4"));
  }
  
}

