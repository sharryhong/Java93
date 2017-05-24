/* 유틸리티 클래스 : java.util.Date 클래스와 import 명령 2
 * => import를 사용하여 클래스 정보를 명시할 때, 
 * 와일드 카드(*)를 사용할 수 있다. 
 * 단, *를 사용한 import명령문이 여러개 있을 경우 개발자는 클래스가 어떤 패키지에 있는 클래스인지
 * 직관적으로 알 수 없다. 코드의 가독성이 떨어진다. 
 */
package step08;

// 명시적이지 않다.
// 참고 : 이클립스는 import를 자동으로 해준다. 
import java.util.*; 
import java.net.*; 
import java.awt.*; 

public class Test05_4 {

  public static void main(String[] args) {
    // 이렇게 패키지명 생략가능하지만.. Date가 어디에 속해있는지 명시적이지 않다. 
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
