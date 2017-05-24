/* 컬렉션(Collection) 클래스 : java.util.HashSet
 * => 저장하려는 객체에 대해 hashCode()를 호출하여, 그 리턴 값을 가지고 저장할 위치(인덱스)를 계산 */
package step08;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_6 {
  
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
    
    // 오버라이딩
    public int hashCode() {
      return 1; // 무조건 값을 1을 주면 => 제대로 안되니 제대로 해보자 => Test07_7
    }
    
    /* hashCode()뿐만 아니라 equals()도 오버라이딩 해야한다.
     * hashCode만 같다고해서 같다고 판단하지 않는다. equals도   
     */

    public boolean equals(Object obj) {
      return true;
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
    
    
    System.out.println(new Book("fff", "비트출판사", 600).hashCode());
    System.out.println(new Book("fff", "비트출판사", 600).hashCode());
    System.out.println(new Book("fff", "비트출판사", 600).hashCode()); 
  }
}
