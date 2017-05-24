/* 멀티 태스킹
 * => CPU 한 개로 여러 프로그램을 동시에? 병행으로 실행하는 방법 
 */
package step19;

public class Test01 {

  public static void main(String[] args) {
    // 현재 main() 메서드를 실행하는 스레드를 알아내기
    Thread t = Thread.currentThread();
    System.out.println(t.getName()); // main
    
    // "main"스레드가 소속되어 있는 스레드 그룹
    ThreadGroup g = t.getThreadGroup();
    System.out.println(g.getName()); // main 
    
    // "main" 그룹의 상위 스레드 그룹 알아내기 
    ThreadGroup g2 = g.getParent();
    System.out.println(g2.getName()); // system
    
    // "system" 그룹의 상위 스레드 그룹 알아내기
    ThreadGroup g3 = g2.getParent();
//    System.out.println(g3.getName()); // null.. 더이상 없다.
    // 즉, 최상위 스레드 : system
    System.out.println("----------------------------");
    
    // "system"그룹의 하위 스레드 그룹 알아내기
    printThreadGroup(g2, "");
    
    // "system"그룹에 소속되어 있는 스레드들 
  }
  
  static void printThreadGroup(ThreadGroup tg, String prefix) {
    // 현재 스레드 그룹의 이름 먼저 출력
    System.out.printf("%s['%s']--\n", prefix, tg.getName());
    
    // 하위 스레드 그룹의 정보를 얻어 출력
    ThreadGroup[] groupArray = new ThreadGroup[10];
    int count = tg.enumerate(groupArray, false); // false하면 하위로 내려가지 않고 1단계만 알아내기
    for (int i = 0; i < count; i++) {
      // 재귀호출
      printThreadGroup(groupArray[i], prefix + "  ");
    }
    
    Thread[] threadArray = new Thread[10];
    count = tg.enumerate(threadArray, false);
    for (int i = 0; i < count; i++) {
      System.out.printf("%s(%s)\n", prefix + "  ", threadArray[i].getName());
    }
  }
  
}
