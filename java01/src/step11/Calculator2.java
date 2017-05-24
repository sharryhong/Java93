package step11;

public class Calculator2 {
  // private 키워드 
  // 외부에서 직접 접근할 수 없게 제한하기
  // 오직 이 클래스 멤버만이 접근할 수 있다.
  private int result;
  
  public void plus(int value) {
    result += value;
  }
  
  public void minus(int value) {
    result -= value;
  }
  
  public int getResult() {
    return result;
  }
}
