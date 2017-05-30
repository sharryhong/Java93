package step21.ex6;

// 모든 자동차는 Vechicle규칙에 따라 작성
// 앞으로 Car를 상속받는 모든 서브클래스는 Vechicle규칙에 따라 작성
// 즉, Vechicle규칙에 선언된 run()메서드를 구현해야한다. 
public abstract class Car implements Vehicle{

  protected String model;
  protected String maker;
  protected int cc;

  public Car() {
    super();
  }
  
  public Car (String model, String maker, int cc) {
    this.model = model;
    this.maker = maker;
    this.cc = cc;
  }
  
  // 인터페이스에 run()메서드가 선언되어있기 때문에 여기서 선언할 필요없다.
//  public abstract void run();

}