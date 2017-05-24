/* 컬렉션(Collection) 클래스 : 사용자의 정의 컬렉션 클래스 사용 - LinkedList
 * => linked list 알고리즘을 이용하여 데이터목록을 다루는 LinkedList 구현 */
package step08;

import java.sql.Date;

public class Test06_3 {
  

  public static void main(String[] args) {
    
    Test06_3_LinkedList dateList = new Test06_3_LinkedList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
    // 맨 끝에 넣고 싶으면 add()하면된다. 
    dateList.add(4, Date.valueOf("2017-2-22"));
    Object removedObj = dateList.remove(3); 
    Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
    
    System.out.println(dateList.size());
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
  }
}
