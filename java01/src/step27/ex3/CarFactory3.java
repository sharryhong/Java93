package step27.ex3;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory3 implements FactoryBean {
  String tireMaker;
  String name;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTireMaker() {
    return tireMaker;
  }

  public void setTireMaker(String tireMaker) {
    this.tireMaker = tireMaker;
  }

  private Car createTico() {
    Engine e1 = new Engine(16, 4);
    
    Tire[] tireList = {
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13)
    };
    
    Car c1 = new Car();
    c1.setModel("티코");
    c1.setCc(800);
    c1.setEngine(e1);
    c1.setTires(tireList);
    
    return c1; // 티코 리턴
  }
  
  private Car createSonata() {
    Engine e2 = new Engine(16, 8);
    
    Tire[] tireList2= {
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13),
      new Tire(tireMaker, 13)
    };
    
    Car c2 = new Car();
    c2.setModel("소나타");
    c2.setCc(1998);
    c2.setEngine(e2);
    c2.setTires(tireList2);
    
    return c2; // 소나타 리턴
  }

  @Override
  public Object getObject() throws Exception {
    switch (this.name) {
    case "tico": return createTico();
    case "sonata": return createSonata();
    default: return null;
    }
  }

  @Override
  public Class getObjectType() {
    return Car.class; // Car타입이다.
  }

  @Override
  public boolean isSingleton() { // 객체를 하나 만들어서 공유할거냐 (싱글톤)
    return true;
  }
}
