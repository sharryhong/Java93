/* 컬렉션 클래스 사용 : java.lang.ArrayList - 제네릭 적용 
 */
package step08;

import java.sql.Date;
import java.util.ArrayList;

public class Test07_11 {

  public static void main(String[] args) {
    ArrayList<Date> dateList = new ArrayList<>();
    // 제네릭의 장점중 하나는 목록에 넣을 수 있는 객체의 타입을 제한할 수 있다는 것
//    dateList.add(new String("Hello")); // Error!
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    
    // java.util.ArrayList는 Collection의 서브 타입이기 때문에 
    // for( : ) 명령을 사용할 수 있다. 
    for (Date date : dateList) {
      System.out.printf("%d월 %d일\n", date.getMonth() + 1, date.getDate());
    }
    
  }
  
}

