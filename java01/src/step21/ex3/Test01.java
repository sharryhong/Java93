/* 추상 클래스와 추상 메서드
*/
package step21.ex3;

public class Test01 {

  public static void main(String[] args) {
    Truck car1 = new Truck("타이탄", "비트", 10000);
    car1.load("자갈");
    car1.run();
    car1.dump();
    
//    Car car2 = new Car(); // Error!
//    Loader car3 = new Loader();// Error!
  }

}
