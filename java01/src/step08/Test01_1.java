/* 프로그램 아규먼트 
 * >java -cp bin step08/Test01_1 aaa bbb ccc 라고 줄 경우 
 */ 
package step08;

public class Test01_1 {

  public static void main(String[] args) {
    // 프로그램 아규먼트가 없으면 빈배열
    for (String str : args) {
      System.out.println(str);      
    }
  }

}
