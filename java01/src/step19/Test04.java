/* 멀티 태스킹 : 스레드의 우선순위
 */
package step19;

public class Test04 {

  static class MyThread extends Thread {
    public MyThread(String name) {
      this.setName(name);
    }
    public void run() {
      for (int i = 0; i < 1000; i++) {
        System.out.printf("[%s] %d\n", this.getName(), i); // this.getName() : 스레드
      }
    }
  }
  
//getPriority(우선순위)를 확인해보자. 
  public static void main(String[] args) { 
    // main에서 만든 쓰레드 : 자식스레드들 
    MyThread t1 = new MyThread("t1");
    MyThread t2 = new MyThread("t2");
    MyThread t3 = new MyThread("t3");
    Thread main = Thread.currentThread(); // "main" 스레드
    System.out.printf("t1 = %d\n", t1.getPriority());
    System.out.printf("t2 = %d\n", t2.getPriority());
    System.out.printf("t3 = %d\n", t3.getPriority());
    System.out.printf("main = %d\n", main.getPriority());
  }
  
}
