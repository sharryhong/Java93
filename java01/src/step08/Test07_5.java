/* 컬렉션(Collection) 클래스 : java.util.HashSet
 * => 저장하려는 객체에 대해 hashCode()를 호출하여, 그 리턴 값을 가지고 저장할 위치(인덱스)를 계산 */
package step08;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_5 {
  
  static class Book {
    String title;
    String press;
    int page;
    
    public Book(String title, String press, int page) {
      this.title = title;
      this.press = press;
      this.page = page;
    }
    
    // 오버라이딩. 하지않으면 Object의 toString()사용으로 step08.Test07_5$Book@7852e922 이런 형식으로 class명..@hashcode로 나온다.
    public String toString() {
      return String.format("%s, %s, %d", title, press, page);
    }
  }

  public static void main(String[] args) {
    
    HashSet set = new HashSet();
    
    set.add(new Book("aaa", "비트출판사", 100));
    set.add(new Book("bbb", "비트출판사", 200));
    set.add(new Book("ccc", "비트출판사", 300));
    set.add(new Book("ddd", "비트출판사", 400));
    set.add(new Book("eee", "비트출판사", 500));
    set.add(new Book("fff", "비트출판사", 600));
    set.add(new Book("fff", "비트출판사", 600));
    
    Iterator iterator = set.iterator(); 
    while (iterator.hasNext()) { 
      System.out.println(iterator.next());
    }
    
    /* fff, 비트출판사, 600 이 중복 저장되었다. 
     * Why?
     * => hashCode()의 리턴값이 다르기 때문  
     */ 
    
    System.out.println(new Book("fff", "비트출판사", 600).hashCode());
    System.out.println(new Book("fff", "비트출판사", 600).hashCode());
    System.out.println(new Book("fff", "비트출판사", 600).hashCode()); // 앗.. 모두 값이 다르다. 
    // String클래스에서 Object로 부터 상속받은 hashCode()를 오버라이딩했기 때문에 .. 
    // 그럼, Book클래스의 경우에도 hashCode()를 재정의하면 중복피할 수 있나? => Yes! => Test07_6
  }
}
