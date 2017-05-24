/* 컬렉션 클래스 사용 전 - 사용자의 정의 컬렉션 클래스 사용 - ArrayList
 * 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현 */
package step08;

import java.sql.Date;
import java.util.*;

public class Test06_4 {
  

  public static void main(String[] args) {
    
    Test06_2_ArrayList dateList = new Test06_2_ArrayList();
//    Calendar cal = Calendar.getInstance();
    java.util.Date today = new java.util.Date();
    
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
    for (int i = 0; i < dateList.size(); i++) {
//      System.out.println(dateList.get(i));
//      System.out.printf("%d월 %d일\n", ((java.util.Date) dateList.get(i)).getMonth()+1,((java.util.Date) dateList.get(i)).getDate());
//      System.out.println(dateList.get(i) instanceof Date); // true

// 변수 Date date = dateList.get(i); // get의 리턴타입은 Object, 위에서 Date.valueOf("2017-5-3")은 Date로 잘 들어갔다. 형변환하면 되겠다.
      // 제네릭 사용 전 : 값을 꺼낼 때마다 본래타입으로 형변환해야한다. 
      Date date = (Date)dateList.get(i); // 형변환
      System.out.printf("%d월 %d일\n", date.getMonth() + 1, date.getDate());
    }

  }
  
}
