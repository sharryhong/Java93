/* 멀티 태스킹 : 스레드 만들고 실행하기
 * => 두가지 방법
 * 1) Thread를 상속 받아서 만들기
 * 2) Runnable 규칙에 따라 만들기
 */
package step19;

public class Test02 {

  static class MyThread extends Thread {
    // 1) "main"스레드와 병행하여 실행할 코드는 반드시 run()메서드를 오버라이딩하여 그 메서드에 둔다.
    public void run() {
      System.out.println("MyThread...");
    }
  }
  
  static class MyJob implements Runnable {
    // 2) "main"스레드와 병행하여 실행할 코드는 Runnable 규칙에 따라 만든 클래스에서 run()메서드 안에 둔다. 
    public void run() {
      System.out.println("MyJob...");
    }
  }
  public static void main(String[] args) {
    // 1) 실행하기 
    MyThread t = new MyThread();
    t.start(); // 자동으로 run() 호출하여 독립적으로 실행
    
    // 2) 실행하기 
    MyJob job = new MyJob();
    Thread t2 = new Thread(job);
    t2.start();
  }
  
}
