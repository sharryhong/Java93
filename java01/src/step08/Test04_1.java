/* 유틸리티 클래스 : Wrapper 
 * => 자바의 원시 데이터 타입을 다루는 클래스 */
package step08;

public class Test04_1 {

  public static void main(String[] args) {
    int i = 10;
    
    Integer obj = new Integer(10);
    
    // 인스턴스에서 int값을 뽑아내는 기능도 있다.
    int x = obj.intValue();
    
    // 인스턴스에서 정수 값을 문자열로 뽑아내는 기능도 있다.
    String str = obj.toString();
    
    // int 값을 다양한 타입의 값으로 뽑아내는 기능도 있다. 
    byte b = obj.byteValue();
    short s = obj.shortValue();
    long l = obj.longValue();
    float f = obj.floatValue();
    double d = obj.doubleValue();
    
    // 두 수의 크기를 비교하는 기능도 있다.
    // 아규먼트의 값보다 작으면 음수, 크면 양수, 같으면 0
    System.out.println(obj.compareTo(new Integer(5))); // 1
    System.out.println(obj.compareTo(new Integer(10))); // 0
    System.out.println(obj.compareTo(new Integer(20))); // -1
    
  }

}
