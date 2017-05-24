// 자바 프로그래밍 - 패키지 무소속 클래스
// 자바 프로그래밍 - 다른 클래스의 메서드 호출하기
public class Test12 {
  public static void main(String[] args) {
    // bin/Test11.clss 파일에 들어있는 m1() 메서드 호출!
    Test11.m1();

    // bin/other/Test11.clss 파일에 들어있는 m1() 메서드 호출!
    other.Test11.m1(); // 패키지명.클래스명.메서드명
  }

}
