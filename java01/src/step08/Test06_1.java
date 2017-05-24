/* 컬렉션 클래스 사용 전 - 배열로.. 아래처럼 복잡해!
 * 컬렉션 클래스 : 여러개의 주소를 보관할 때 사용하는 클래스 */
package step08;

import java.sql.Date;

public class Test06_1 {

  public static void main(String[] args) {
    // 객체 주소를 담을 Object 레퍼런스 변수를 3개 만든다.
    // Object 인스턴스를 3개만들라는거 아니다. 
    // new명령어 하나당 인스턴스 하나만 생성된다. 
    // 단, 개발자들 사이에서는 그냥 Object 3개 만들어 라고 하는것이다.
    Object[] dateList = new Object[3];
    
    dateList[0] = Date.valueOf("2017-3-1"); // 문자열을 날짜값으로 바꿔서 java.sql.Date객체를 만들어서 객체 주소를 리턴 
    dateList[1] = Date.valueOf("2017-5-3");
    dateList[2] = Date.valueOf("2017-5-5");
    
    // 배열의 문제 : 인스턴스를 배열크기만큼만 저장할 수 있다. 
    // 더 추가로 저장하고 싶다면 새 배열을 만들어야한다. 
    dateList = growArray(dateList, 2);
    
    dateList[3] = Date.valueOf("2017-5-9");
    dateList[4] = Date.valueOf("2017-6-6");
    
    for (Object obj : dateList) {
      System.out.println(obj);
    }
  }
  
  public static Object[] growArray(Object[] arr, int size) {
    Object[] newArr = new Object[arr.length + size];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    return newArr;
  }
}
