/* 유틸리티 클래스 : java.util.Data 클래스 2
 * => 년, 월, 일, 시, 분, 초 값 꺼내기  
 */
package step08;

public class Test05_2 {

  public static void main(String[] args) {
    // 인스턴스를 만들면 현재 시간을 보관하고 있는 객체가 생성된다. 
    java.util.Date today = new java.util.Date();
    
    // Deprecated Method : 앞으로 사라질 메서드들 
    System.out.println(today.getYear() + 1900);  
    System.out.println(today.getMonth() + 1); // 0부터 시작
    System.out.println(today.getDate());
    System.out.println(today.getDay()); // 일(0)월~토
    System.out.println(today.getHours());
    System.out.println(today.getMinutes());
    System.out.println(today.getSeconds());
    System.out.println(today.getTime()); // 1970년 1월 1일 0시 0분 0초부터 경과된 시간을 밀리초로 나타냄. 타입은 long
    
    
  }
}
