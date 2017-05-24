/* 유틸리티 클래스 : 같은 이름 다른 패키지 */
package step08;

//import java.sql.Date;
//import java.util.Date; // Data이름이 같으므로 이렇게 쓸 수 없다. 와일드카드 쓰자.
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Test05_6 {

  public static void main(String[] args) {
    long currTime = System.currentTimeMillis();
    // 어느 패키지의 Date()인지 알 수 없을 때는 명확하게 패키지명을 써야한다. 
    java.sql.Date today = new java.sql.Date(currTime);
    System.out.println(today);
  }
}
