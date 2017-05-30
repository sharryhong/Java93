package step21.ex2;

public class Truck extends Loader {
  
  public Truck(String model, String maker, int cc) {
    super(model, maker, cc);
  }
  
  public void run() {
    System.out.println("부왕~~~ 힘차게 달린다.");
  }
  
  public void load(Object obj) {
    if (obj != null) {
      super.load(obj);
    } else {
      System.out.println("비었습니다.");
    }
  }
  
  public void dump() {
    if (storage != null) {
      System.out.printf("%s를 내렸습니다.", this.storage);
      this.storage = null;
    } else {
      System.out.println("내릴 게 없습니다.");
    }
  }
}
