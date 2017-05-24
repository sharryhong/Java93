/* 컬렉션 클래스 사용 전 - 사용자의 정의 컬렉션 클래스 사용 - ArrayList
 * 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현 */
package step08;

import java.sql.Date;

public class Test06_2 {
  

  public static void main(String[] args) {
    
    Test06_2_ArrayList dateList = new Test06_2_ArrayList(); // 기본 10개 배열만들기 
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    // 이건 0번째 넣고싶다. 
    dateList.add(0, Date.valueOf("2017-2-22"));
    // 지운 값의 주소를 리턴
    Object removedObj = dateList.remove(3); 
    
    Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
    
//    System.out.println(dateList.length); // private 이므로 접근불가
    System.out.println(dateList.size()); // 접근할 수 있는 메서드 사용
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
    
    System.out.println("=>" + removedObj);
    System.out.println("=>" + oldObj);
  }
  
}
