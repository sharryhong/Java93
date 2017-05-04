// 자바 프로그래밍 - 표준 출력 장치로 출력하기 (System 클래스)
public class Test07 {
  public static void main(String[] args) {
    System.out.print("Hello,");
    System.out.print("world!\n");
    System.out.println("Hello,");
    System.out.print("world!"); // 줄바꿈이 없어서 명령창에서 프롬프트가 옆으로 나온다.(앗..윈도우즈 cmd는 줄바꿈되서 나오네)
  }
}

/*
System 클래스
- JVM의 기능이 들어 있다.

out 객체
- 표준 출력 장치에 대한 기능이 들어 있다.

print()
- 출력 기능을 수행하는 메서드(함수)

println()
- print() + 줄바꿈 기호 출력
*/
