/* 유틸리티 클래스 : java.sql.Date 클래스
 * => java.util.Data클래스의 서버 클래스
 */
package step08;

import java.sql.Date;

public class Test05_5 {

  public static void main(String[] args) {
//    1) 먼저 현재 시간을 밀리초로 알아낸다.
    long currTime = System.currentTimeMillis();
    Date today = new Date(currTime);
    System.out.println(today); // 2017-05-12
    
  }
}
