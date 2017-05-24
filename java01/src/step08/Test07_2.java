/* 컬렉션(Collection) 클래스 : java.lang.LinkedList
 * => 내부에서 목록을 다룰 때 bucket역할을 주행하는 Node 객체에 값을 담는다.
 * 그 Node 객체를 앞, 뒤로 연결한다.  
 * Node를 추가, 삽입, 제거, 조회하는 방법은 linked list 알고리즘을 따른다. */
package step08;

import java.sql.Date;
import java.util.LinkedList;

public class Test07_2 {
  

  public static void main(String[] args) {
    
    LinkedList dateList = new LinkedList();
    
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
