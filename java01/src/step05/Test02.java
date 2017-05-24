/* 메서드 : 메서드 정의 void m1() {} */
package step05;

public class Test02 {
  
  // 1) 값을 리턴하지 않고, 파라미터를 받지 않는 경우
  // => 메서드 선언 앞에 void를 붙여야한다. 
  public static void m1() {
    System.out.println("m1() 호출");
  }
  
  // 2) 값을 리턴하지 않고, 아규먼트는 받는 경우
  public static void m2(int a, String str, boolean b) {
    System.out.printf("%d, %s, %b\n", a, str, b);
  }
  
  // 3) 값을 리턴하고, 아규먼트를 받지 않는다. 
  // => 메서드 선언앞에 리턴 타입을 지정해야한다.
  public static String m3() {
//    return 10; // 메서드 선언 타입이 String이므로 안된다.
    return "Hello";
    // return문 실행하는 순간 메서드 호출 끝남. 따라서 return문 다음에 명령문 작성하면 오류
  }
  
  // 4) 값을 리턴하고, 아규먼트도 받는다. 
  // => 보통 값을 받아서 처리한 후, 그 결과를 리턴하고자 할 때 사용한다. 
  public static int m4(int a) {
    return a * a;
  }

  public static void main(String[] args) {
    m1();
    m2(10, "홍길동", false);
    String value = m3();
    System.out.println(value);
    
    int result = m4(16);
    System.out.println(result);
  }

}
