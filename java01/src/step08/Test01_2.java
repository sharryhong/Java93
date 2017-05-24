/* 프로그램 아규먼트 연습 2
 * => 가위, 바위, 보 게임 만들기 
 * 예)
 * > java -cp bin step08.Test01_3 가위
 * 당신이 이겼습니다! ^^!
 * 메롱~ 당신이 졌습니다! ㅜㅜ
 * 비겼습니다. ㅡ.ㅡ;
 * 
 * => Math.random() 의 리턴 값은 0 ~ 1 부동소수점 
 * Math.random() * 3 => 0 ~ 3 사이 부동소수점 값
 * int r = (int)f; // 명시적 형변환 사용
 */ 
package step08;

public class Test01_2 {

  public static void main(String[] args) {
    int input = Integer.parseInt(args[0]);
    
    int robot = (int)(Math.random() * 3) + 1;
    boolean victory = false;
 // 문자열을 비교할 때는 == 로 비교할 수 없다. 그래서 1일때 가위
    if (input == robot) { 
      System.out.println(" 비겼습니다. ㅡ.ㅡ;");
      return;
    } else if ((input == 1 && robot == 3) ||
               (input == 2 && robot == 1) ||
               (input == 3 && robot == 2)) {
      victory = true;
    }
    printResult(input, robot, victory);
  }
    
    public static void printResult(int input, int robot, boolean victory) {
      System.out.printf("나: %s <====> 로봇: %s\n", getLabel(input), getLabel(robot));
      if (victory) {
        System.out.println("이겼습니다! ^^~!");
      } else {
        System.out.println("졌습니다. ㅜㅜ");
      }
    }
    
    public static String getLabel(int value) {
      switch (value) {
      case 1: return "가위";
      case 2: return "바위";
      case 3: return "보";
      default: return "?";
      }
    }

}
