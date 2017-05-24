/* 컬렉션 클래스 사용 후 */
package step08;

import java.sql.Date;
import java.util.*;

public class Test06_5 {
  
  public static void main(String[] args) {
    
    Test06_5_ArrayList2<Date> dateList = new Test06_5_ArrayList2<>();
    // 이 ArrayList에는 Date만 들어가게 한 것
    
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
    for (int i = 0; i < dateList.size(); i++) {
      Date date = dateList.get(i); // 형변환할 필요가 없다.
      System.out.printf("%d월 %d일\n", date.getMonth() + 1, date.getDate());
    }

  }
  
}
