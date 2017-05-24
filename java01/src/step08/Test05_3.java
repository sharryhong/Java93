/* 유틸리티 클래스 : java.util.Date 클래스와 import 명령 
 * => 클래스를 사용하려면 반드시 패키지명을 적어야한다. 
 * 단, java.lang패키지의 클래스는 적지않아도된다. 
 * => import 명령을 사용하여 그 클래스가 어떤 패키지에 있는지 명시하면 그 다음부터는 패키지명을 쓰지 않아도된다.
 */
package step08;

// import는 반드시 package명령 다음에 와야한다.
import java.util.Date; 

public class Test05_3 {

  public static void main(String[] args) {
    // 이렇게 패키지명 생략가능
    Date today = new Date();
    
    System.out.println(today.getYear() + 1900);  
    System.out.println(today.getMonth() + 1);
    System.out.println(today.getDate());
    System.out.println(today.getDay()); 
    System.out.println(today.getHours());
    System.out.println(today.getMinutes());
    System.out.println(today.getSeconds());
    System.out.println(today.getTime());
    
    
  }
}
