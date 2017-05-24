/* 예외처리 : 조건문을 사용하여 예외처리를 하는 경우
 * => 메서드를 호출할 때 마다 그 리턴값을 검사해야한다. 
 * 메서드를 사용하는 코드안에, 일을 시키는 코드와 예외를 처리하는 코드가 섞여있어 유지보수가 어려워진다. 
 * 또한 리턴값이 
 */
package step17;

public class Test02 {
  public static float divide(float a, float b) {
    if (b == 0) {
      return -121255f;
    }
    return a / b;
  }

  public static void main(String[] args) {
    float result;
    result = divide(10f, 0);
    if (result == -121255f) {
      System.out.println("0으로 나눌 수 없습니다.");
    } else {
      System.out.println(result);
    }
    
    result = divide(121255f, -1); // 리턴값이 -121255f가 되는 바랍에 0으로 나눈 것으로 처리된다. 
    if (result == -121255f) {
      System.out.println("0으로 나눌 수 없습니다.");
    } else {
      System.out.println(result);
    }
  }

}
