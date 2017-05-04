// 자바 프로그래밍 - 다른 클래스의 메서드 호출하기
public class Test10 {
  public static void main(String[] args) {
    // bin/Test09.clss 파일에 들어있는 m1() 메서드 호출!
    Test09.m1();

    // bin/other/Test09.clss 파일에 들어있는 m1() 메서드 호출!
    Test09.m1(); // ??? 구분이 안가!!!
  }

  public static void m1() {
    System.out.println("src/Test09.m1()...");
  }
}
