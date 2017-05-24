/* 유틸리티 클래스 :  */
package step08;

import java.util.Calendar;

public class Test05_7 {

  public static void main(String[] args) {
    
    Calendar cal = Calendar.getInstance();

   // 날짜 정보 추출
    System.out.println(cal.get(1)); // 년도
    System.out.println(cal.get(2) + 1); // 월
    System.out.println(cal.get(5)); // 일
    System.out.println(cal.get(7)); // 요일 (1 ~ 7)
    System.out.println(cal.get(10)); // 시 (0 ~ 11)
    System.out.println(cal.get(11)); // 시 (0 ~ 23)
    System.out.println(cal.get(12)); // 분
    System.out.println(cal.get(13)); // 초
  }
}
