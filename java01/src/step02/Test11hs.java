/* 변수 선언 : 배열 응용 - 학생 성적 데이터 보관 */
package step02;

public class Test11hs {

  public static void main(String[] args) {

    String[] names = {"홍길동", "임꺽정", "유관순"};
    byte[][] scores = {{100, 100, 100}, {90, 90, 90}, {80, 80, 80}};
    short[] totals = {300, 270, 240};
    float[] aver = {100f, 90f, 80.0f};
    
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + ", ");        
      for (int j = 0; j < scores[i].length; j++) {
        System.out.printf("%d, ", scores[i][j]);
      }
      System.out.printf("%d ,%f", totals[i], aver[i]);
      System.out.println();
    }
  }

}
