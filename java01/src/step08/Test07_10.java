/* 컬렉션(Collection) 클래스 : java.util.HashMap
 * =>  */
package step08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test07_10 {
  
  // 사용자 정의 클래스
  static class MyKey {
    String value;
    
    public MyKey(String value) {
      this.value = value;
    }

    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      return result;
    }

    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MyKey other = (MyKey) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false;
      return true;
    }

    public String toString() {
      return value;
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
    
    // Map 컬렉션에서 값 꺼내기
    // 방법 1) 값 목록을 리턴 받아 꺼내기 
    Collection valueList = map.values(); // 값 목록이 들어있는 Collection
    // 값이 들어있는 컬렉션에서 값을 한개씩 꺼내줄 도구를 얻는다. 
    Iterator iterator = valueList.iterator();
    // 도구를 사용하여 값 꺼내기 
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("------------------------");
    
    // 방법 2) key 목록을 리턴 받아 꺼내기
    // key 목록을 리턴 받는다.
    Set keySet = map.keySet();
    // key 목록에서 key 배열을 얻는다. Set에는 값을 한개씩 꺼내는 메서드가 없기 때문에, 이런 번거로운 방식으로 
    Object[] keyArray = keySet.toArray();
    for (int i = 0; i < keyArray.length; i++) {
      System.out.println(map.get(keyArray[i]));
    }
    System.out.println("------------------------");
    
    // Set은 Collection의 서브타입이다. Collection에 있는 값을 꺼낼 때 for(변수 : 배열 or Collection객체)문법을 사용할 수 있다. 
    for (Object value : valueList) {
      System.out.println(value);
    }
    for (Object key : keySet) {
      System.out.println(map.get(key));
    }
    
    // 방법 3) key와 value를 한쌍으로 하는 목록을 리턴받기
    // key/value를 한 묶음으로 만든 목록을 리턴받는다. 
    Set entrySet = map.entrySet(); // 리턴하는 것 : Set객체
    for (Object object : entrySet) {
//      Entry // Map안에 선언된 inner 인터페이스
      Entry entry = (Entry)object;
      System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
    }
  }
}
