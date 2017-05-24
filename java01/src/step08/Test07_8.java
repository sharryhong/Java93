/* 컬렉션(Collection) 클래스 : java.util.HashMap
 * =>  */
package step08;

import java.util.HashMap;
import java.util.Iterator;

public class Test07_8 {
  
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
    
    // add()메서드 없다. 
    // put(key, value)
    // => key 객체 : 
    // => vale 객체 : Map컬렉션에 보관될 값
    map.put(new String("key1"), new Book("aaa", "비트출판사", 100));
    map.put("key2", new Book("bbb", "비트출판사", 200));
    map.put("key3", new Book("ccc", "비트출판사", 300));
    map.put("key4", new Book("ddd", "비트출판사", 400));
    map.put("key5", new Book("eee", "비트출판사", 500));
    map.put("key6", new Book("fff", "비트출판사", 600));
    map.put("key7", new Book("fff", "비트출판사", 600));
    
    // 값을 꺼내는 방법
    // => key사용
    System.out.println(map.get(new String("key1"))); 
//    System.out.println(map.get(1)); // "오토박싱", "오토언박싱" 때문에 에러는 나지 않는다. 즉, new Integer(1)로 오토박싱하여 객체가 놓여서 에러가 나지않는것이다. 
    
    /* key로 사용할 수 있는 객체?  
     */
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    if (s1 == s2)
      System.out.println("s1 == s2");
    else 
      System.out.println("s1 != s2");
//    String클래스의 특징 : 이렇게 같도록 오버라이딩 되어있다. 
    // 따라서 이런 클래스는 key로 사용할 수 있다. 
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode()); // 같다. 
    System.out.println(s1.equals(s2)); // true
  }
}
