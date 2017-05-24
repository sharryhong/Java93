/* 컬렉션(Collection) 클래스 : java.util.HashMap
 * =>  */
package step08;

import java.util.HashMap;
import java.util.Iterator;

public class Test07_9 {
  
  // 사용자 정의 클래스
  static class MyKey {
    String value;
    
    public MyKey(String value) {
      
    }
  }
  
  static class Book {
    String title;
    String press;
    int page;
    
    public Book(String title, String press, int page) {
      this.title = title;
      this.press = press;
      this.page = page;
    }
    
    public String toString() {
      return String.format("%s, %s, %d", title, press, page);
    }
  }

  public static void main(String[] args) {
    
    HashMap map = new HashMap();
    map.put(new MyKey("key1"), new Book("aaa", "비트출판사", 100));
    map.put(new MyKey("key2"), new Book("bbb", "비트출판사", 200));
    map.put(new MyKey("key3"), new Book("ccc", "비트출판사", 300));
    map.put(new MyKey("key4"), new Book("ddd", "비트출판사", 400));
    
    System.out.println(map.get(new MyKey("key1"))); // null 
    System.out.println(map.get(new MyKey("key3"))); // null
    
    // 인스턴스 변수 값이 중요한게 아니라, hashCode()의 리턴값과 equals()의 리턴 값이 중요하다.
    
    MyKey s1 = new MyKey("Hello");
    MyKey s2 = new MyKey("Hello");
    if (s1 == s2)
      System.out.println("s1 == s2");
    else 
      System.out.println("s1 != s2");
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode()); // 다르다. 
    System.out.println(s1.equals(s2)); // false
  }
}
