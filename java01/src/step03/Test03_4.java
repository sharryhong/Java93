/* 기타 연산자 : 비트논리 연산자 &(and), |(or), ^(Exclusive or), ~(not)*/

package step03;

public class Test03_4 {

  public static void main(String[] args) {
    int a = 0b1100_1010; // 2진수 값 
    int b = 0b0101_0101; 
    
    int r = a & b; // 0100_0000 // 둘다 1일때만 1
    String str = Integer.toBinaryString(r);
    System.out.println(str);
    
    r = a | b; // 둘 중 하나라도 1이면 1 
    // |(or)는 오로지 정수값에 대해서만 연산이 가능하다. 
    System.out.println(Integer.toBinaryString(r));
    
    r = a ^ b; // 둘의 값이 다를때만 1
    System.out.println(Integer.toBinaryString(r));
    
    r = ~a; // 반전 
    System.out.println(Integer.toBinaryString(r)); // 32비트이므로 앞의 0을 모두 1로 반전시켜줌

  }

}
