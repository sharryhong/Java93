/* 멀티 태스킹 : Critical Section(Critical Region)
 */
package step19;

public class Test05_1 {
  
  static class Account {
    long balance; // 잔액
    
    public Account(long balance) { 
      this.balance = balance;
    }
    
    // balance는 heap에 저장되었고, 각 스레드가 공동으로 사용한다. 
    // 문제! 여러 스레드들이 같은 인스턴스에 대해 withdraw메서드를 호출했을 때 서로 중복하여 값을 변경할 수 있다. 
    // 이렇게 문제가 발생 : Critical Section(Critical Region)
    public long withdraw(long money) { // 돈 인출
      long temp = this.balance; 
      
      double x = 3.141592; //------ 연산을 지연시키려고 부동소수점 값 준것임
      int delayCount = (int)(Math.random() * 10);
      // 일부러 인출할 때 delay시키기
      for (int i = 0; i < delayCount; i++) {
        x /= 345.2345; // 부동소수점을 나누는 것이 시간이 오래걸림
      }
      //--------여기까지 시간지연
      
      temp -= money;
        
      if (temp >= 0) { // 인출할 돈이 있다면
        this.balance = temp;
        return money; // 인출 함
      }
      return 0; // 인출 못함
    }
  }

  static class ATM extends Thread { // 이 스레드는 10000번 반복하면서 독립적 실행
    Account account; // 계좌번호
    
    public ATM(String name, Account account) {
      super(name); // 수퍼클래스의 생성자호출
      this.account = account;
    }
    
    public void run() {
      long sum = 0; // 얼마 찾나
      for (int i = 0; i < 10000; i++) {
        long money = this.account.withdraw(100); // 100원 찾기
        if (money == 0) 
          break; // 찾을 돈이 없으면 반복문 나가기
        sum += money; // 찾을 돈 있으면 
      }
      System.out.printf("%s = %d\n", this.getName(), sum); // 이름, 찾은돈 
    }
  }
  
  public static void main(String[] args) { 
    Account account = new Account(1_000_000); // 계좌만들기 
    ATM t1 = new ATM("강남", account); // ATM(스레드) 만들기 
    ATM t2 = new ATM("강북", account);
    ATM t3 = new ATM("강원", account);
    ATM t4 = new ATM("제주도", account);
    
    t1.start(); // 출금 시작. 100만원 넣고 100원씩 출금
    t2.start();
    t3.start();
    t4.start();
  }
  
}
