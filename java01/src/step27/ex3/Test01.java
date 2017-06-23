/* 스프링 사용법 : 팩토리 메서드 호출하기 1. 팩토리 메서드 사용 전 */
package step27.ex3;

import java.util.ArrayList;

public class Test01 {
  public static void main(String[] args) {
    // 1) 팩토리 메서드 사용전. 일반적인 객체 생성
    // 티코 자동차 만들기
    Engine e1 = new Engine(16, 4);
    
    Tire[] tireList = {
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13)
    };
    
    Car c1 = new Car();
    c1.setModel("티코");
    c1.setCc(800);
    c1.setEngine(e1);
    c1.setTires(tireList);
    
    // 소나타 자동차 만들기
    Engine e2 = new Engine(16, 8);
    Tire[] tireList2= {
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13)
    };
    
    Car c2 = new Car();
    c2.setModel("소나타");
    c2.setCc(1998);
    c2.setEngine(e2);
    c2.setTires(tireList2);
  }
}
