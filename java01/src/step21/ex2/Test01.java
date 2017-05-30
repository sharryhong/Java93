/* 상속 적용하기
 * => 상속 기법의 종류 
 * 1) specialization (스페셜라이제이션) : 우리가 알고 있는 상속
 * 2) generalization (제네럴라이제이션) : 일반적(공통적)인 것을 뽑아내는 것 => 초보때는 이 방법이 더 효과적이다. 
*/
package step21.ex2;

public class Test01 {

  public static void main(String[] args) {
    Truck car1 = new Truck("타이탄", "비트", 10000);
    car1.load("자갈");
    car1.run();
    car1.dump();
  }

}
