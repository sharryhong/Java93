/* 예외처리 : 예외 처리를 하지 않는 경우 */
package step17;

public class Test01 {
  public static float divide(float a, float b) {
    return a / b;
  }

  public static void main(String[] args) {
    System.out.println(divide(10f, 2f)); // 5.0
    System.out.println(divide(0, 2));    // 0.0
    System.out.println(divide(10, 0));   // Infinity 
  }

}
