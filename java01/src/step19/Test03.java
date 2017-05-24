/* 멀티 태스킹 : 스레드 만들고 실행하기 2
 * 개념잡기
 */
package step19;

public class Test03 {

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
  
  public static void main(String[] args) {
    // main에서 만든 쓰레드 : 자식스레드들 
    MyThread t1 = new MyThread("t1");
    MyThread t2 = new MyThread("t2");
    MyThread t3 = new MyThread("t3");
    
    t1.start();
    t2.start();
    t3.start();
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("[main] %d\n", i);
    }
  }
  
}
