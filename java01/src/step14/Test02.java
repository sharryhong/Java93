/* 제네릭(Generic) 문법 사용 후 
 * => 값을 꺼낼 때마다 본래 타입으로 형 변환할 필요없다. 
 * 특정 타입의 값만 다루도록 제한할 수 있다. */
package step14;

import java.util.Date;

public class Test02 {

  public static void main(String[] args) {
    // 1) 제네릭 클래스 사용시 타입지정하지 않으면 기본이 Object
    Bucket2 b = new Bucket2();
//    Bucket2<Object> b = new Bucket2<Object>(); // 상동
    
    b.setValue(new String("Hello"));
    String str = (String)b.getValue();
    
    b.setValue(new Date());
    Date date = (Date)b.getValue();
    
    b.setValue(new Integer(10));
    Integer i = (Integer)b.getValue();
  }

}
