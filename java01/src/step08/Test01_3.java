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

public class Test01_3 {

  public static void main(String[] args) {
    String user = args[0];
    
    String[] computer = {"가위", "바위", "보"};
    int com = (int)(Math.random() * 3);
//    System.out.println(com);
    String randomCom = computer[com];
//    System.out.println(randomCom);
    
    if (user == "가위") {
      if (randomCom == "가위") System.out.println("비겼다.");
      else if (randomCom == "바위") System.out.println("졌다.");
      else System.out.println("이겼다");
    }

  }

}
