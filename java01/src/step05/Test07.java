/* 메서드 : 스택(stack) 메모리 
 * 메서드가 호출되면 그 메서드의 로컬변수가 스텍 메모리에 준비된다. 
 */
package step05;

public class Test07 {
  
  public static void m1(int a) {
    m2(++a);
    System.out.printf("m1(): %d\n", a); // 3) 21
    m2(++a);
    System.out.printf("m1(): %d\n", a); 
  }
  
  public static void m2(int a) {
    m3(++a);
    System.out.printf("m2(): %d\n", a); // 2) 22
  }
  
  public static void m3(int a) {
    ++a;
    System.out.printf("m3(): %d\n", a); // 1) 23
  }

  public static void main(String[] args) {
    int a = 20;
    m1(a); // a값인 20을 넘긴다. 
    System.out.printf("main(): %d\n", a);
  }
}

