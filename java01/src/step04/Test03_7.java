/* 문장 : 반복문 do ~ while */
package step04;

public class Test03_7 {
  public static void main(String[] args) {
    int i = 2;
    
    while (i < 2) { // 조건이 false면 아예 실행안함
      System.out.println(i);
      i++;
    }
    System.out.println("------------------");
    
    i = 2;
    do { // 무조건 한번은 실행됨
      System.out.println(i);
    } while (i < 2);
    
  }

}
