package step21.ex5;

public abstract class Loader extends Car {

  Object storage;

  public Loader() {
    super();
  }

  public Loader(String model, String maker, int cc) {
    super(model, maker, cc);
  }

  // Sedan에서는 그대로 쓰고, Truck에서는 재정의하므로, 추상메서드로 하지 않는다. 
  public void load(Object obj) {
    this.storage = obj;
    System.out.printf("%s를 실었습니다.", obj);
  }

}