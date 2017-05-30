package step21.ex5;

public class CarTester {
  // (Car car) : Sedan, Truck, Bulldozer등 모든 것 접근 가능한 Car
  // 추상클래스인 Car가 직접오진 않겠지만, 서브클래스 중 가능한 클래스가 올 것이다. 
  public static void test(Car car) { // 인스턴스 변수를 사용하지 않으므로 static을 붙이자. 
                                     // 인스턴스? 구분되는 정보
    System.out.println("자동차 테스트 시작!");
    
    car.run(); // car변수에 저장된 인스턴스를 가지고 run을 실행한다. 
    // 그런데 run은 추상클래스인데? => 헷갈릴 수 있다. 
    // 이 때 run()메서드는 추상클래스 Car의 추상메서드인 run()을 호출하는 것이 아니다. 
    // 파라미터에 넘어온 객체의 실제 클래스에 대해서 run()을 호출하는 것이다.  
    
    System.out.println("자동차 테스트 끝!");
  }
}
