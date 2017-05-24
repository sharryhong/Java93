/* 상속 : 생성자 호출 2 */
package step09.ex4;

public class Test01 {

  public static void main(String[] args) {
    new C(); // C()생성자부터 호출. 호출되자마자 그 안에서 수퍼클래스의 생성자 호출되는것이며
             // 수퍼클래스가 먼저 실행되는것이다. 
  }

}
