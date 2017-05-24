/* 컬렉션(Collection) 클래스 : java.util.HashSet
 * => 저장하려는 객체에 대해 hashCode()를 호출하여, 그 리턴 값을 가지고 저장할 위치(인덱스)를 계산 */
package step08;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_3 {
  

  public static void main(String[] args) {
    
    HashSet dateSet = new HashSet();
    
    dateSet.add(Date.valueOf("2017-3-1"));
    dateSet.add(Date.valueOf("2017-5-3"));
    dateSet.add(Date.valueOf("2017-5-5"));
    dateSet.add(Date.valueOf("2017-5-9"));
    Date d1 = Date.valueOf("2017-6-6");
    dateSet.add(d1);
    dateSet.add(d1); // 데이터 중복 안됨 
    
    // Set 컬렉션에서 값을 꺼내는 방법
    
    // 방법 1) 배열을 리턴받기
    Object[] valueList = dateSet.toArray();
    for (int i = 0; i < valueList.length; i++) {
      System.out.println(valueList[i]);
    }
    
    System.out.println("------------------------------");
    // 방법 2) 값을 꺼내주는 도구를 이용하여 처리한다.
    Iterator iterator = dateSet.iterator(); // 데이터를 꺼내주는 도구인 iterator()
    while (iterator.hasNext()) { // 꺼낼거 있냐
      System.out.println(iterator.next()); // 꺼내줘
    }
    
  }
}
