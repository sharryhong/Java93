/* 컬렉션(Collection) 클래스 : java.util.HashSet
 * => 저장하려는 객체에 대해 hashCode()를 호출하여, 그 리턴 값을 가지고 저장할 위치(인덱스)를 계산 */
package step08;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_4 {
  

  public static void main(String[] args) {
    
    HashSet set = new HashSet();
    
    set.add(new String("홍길동"));
    set.add(new String("임꺽정"));
    set.add(new String("유관순"));
    set.add(new String("윤봉길"));
    set.add(new String("안중근"));
    set.add(new String("김구"));
    set.add(new String("김구"));
    /* new String("김구") 로 하면.. 인스턴스 주소가 다르다고 배웠다. 그럼에도 불구하고 중복되지 않는다!
     * Why?
     * => Set은 객체(의 주소)를 저장할 때, 그 객체에 대해 hashCode()메서드를 호출한 후, 그 리턴 값으로 위치를 계산한다.
     * 그런데 String class는 같은 값을 갖는 경우, 같은 hash value를 리턴하도록 hashCode()를 오버라이딩하였다.   
     */ 
    System.out.println(new String("김구").hashCode());
    System.out.println(new String("김구").hashCode());
    System.out.println(new String("김구").hashCode()); // 모두 같은 값 
    
    Iterator iterator = set.iterator(); 
    while (iterator.hasNext()) { 
      System.out.println(iterator.next());
    }
    
  }
}
