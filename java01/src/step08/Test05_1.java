/* 유틸리티 클래스 : java.util.Data 클래스
 * => 1970년 1월 1일 0시 0분 0초부터 현재까지 경과된 시간을 밀리초(1/1000초)로 저장하는 객체 
 */
package step08;

public class Test05_1 {

  public static void main(String[] args) {
    // 현재 날짜 및 시간
    java.util.Date today = new java.util.Date();
    System.out.println(today.toString());
    System.out.println(today); // println()에서 자동으로 객체의 toString()출력해줌
    
  }
}
