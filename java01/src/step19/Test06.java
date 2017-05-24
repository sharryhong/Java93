/* 멀티 태스킹 : 스레드의 라이프 사이클
 */
package step19;

public class Test06 {
  
  static class Worker {
    public void play() {
      System.out.println("오호라! 놀자!");
    }
  }

  static class MyThread extends Thread {
    Worker worker;
    
    public MyThread(Worker worker) {
      this.worker = worker;
    }
    public void run() {
      while (true) {
        worker.play();
        try { // Thread.sleep은 예외를 발생시킨다.
          Thread.sleep(1000); // 1초 동안 잠들고 다시 깨어나서 실행.. 
        } catch (Exception e) {} 
      }
    }
  }
  
  public static void main(String[] args) { 
    Worker worker = new Worker();
    MyThread t1 = new MyThread(worker);
    
    t1.start();
    
    // "main"스레드는 t1스레드를 실행시켜놓고, main()메서드 호출을 끝낸다.
    // "main"스레드는 자식스레드가 종료될때까지 JVM을 종료하지 않는다. 
    System.out.println("main() 끝!");
  }
  
}
