/* 기타 연산자 : 비트이동 연산자 >>, >>>, << (<<<는 없다)*/

package step03;

public class Test03_6 {

  public static void main(String[] args) {
    int a = 0b0000_1011;
    
    // >> 연산자 : 빈자리를 부호비트와 같은 값으로 채운다.
    // 2의 지승과 나누는 값과 같다. 
    // 일반 연산보다 빠르다. 그래도 그냥 일반 연산쓴다. 
    System.out.println(a); // 11 
    System.out.println(a >> 1); //  => 0000_0101(1짤림) = 5  // a / 2^1 = 11 / 2 = 5
    System.out.println(a >> 2); //  => 0000_0010(..) = 2     // a / 2^2 = 11 / 4 = 2 
    System.out.println(a >> 3); //  => 0000_0001(..) = 1     // a / 2^3 = 11 / 8 = 1
    
    // >>> 연산자 : 빈자리를 무조건 0으로 채운다. 
    System.out.println(-10 >> 2);  // 음수
    System.out.println(-10 >>> 2); // 양수
    
    // << 연산자 : 오른쪽 빈 자리를 무조건 0으로 채운다. 
    // 2의 지승과 곱하는 값과 같다. 
    System.out.println(a << 1); //  => 0001_0110 = 22  // a * 2^1 = 11 * 2 = 22
    System.out.println(a << 2); //  => 0010_1100 = 44     // a * 2^2 = 11 * 4 = 44 
    System.out.println(a << 3); //  => 0101_1000 = 88     // a * 2^3 = 11 * 8 = 88

  }

}
