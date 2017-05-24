/* 멀티 태스킹 : 스레드의 라이프 사이클
 */
package step19;

public class Test07 {
  
  static class Food {
    synchronized public void eat() throws Exception {
      System.out.println("먹지말고 기다려!");
      this.wait();
      System.out.println("바우와우!!");
    }
    
    synchronized public void allow() throws Exception {
      this.notify(); // 전체를 다룰 때는 notifyAll()
    }
  }
  
  static class Dog extends Thread {
    Food food;
    public Dog(Food food) {
      this.food = food;
    }
    public void run() {
      try {
        food.eat();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  static class Counter extends Thread {
    Food food;
    int count = 10;
    
    public Counter(Food food) {
      this.food = food;
    }
    
    public void run() {
      while (true) {
        count--;
        System.out.printf("먹기 %d초 전..\n", count);
        if (count == 0) {
          try { food.allow(); } catch (Exception e) { e.printStackTrace();}
          return;
        }
        try { 
          Thread.sleep(1000); // 1초 동안 잠들고 다시 깨어나서 실행.. 
        } catch (Exception e) {} 
      }
    }
  }
  
  public static void main(String[] args) { 
    Food food = new Food();
    Dog dog = new Dog(food);
    dog.start();
    
    Counter counter = new Counter(food);
    counter.start();
    
  }
}
