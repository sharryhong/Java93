package step21.ex6;

// 규칙 정의
// => 호출자: CarTester
// => 구현체(규칙을 따르는 것): CarTester가 테스트하는 대상 (Sedan, Truck, Bulldozer, Tesla)
public interface Vehicle {
  public abstract void run();
}
