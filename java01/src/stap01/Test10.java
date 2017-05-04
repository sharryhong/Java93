/* 리터럴 - 문자 리터럴
 */
package stap01;

public class Test10 {

  public static void main(String[] args) {
    char c1 = 44032; // '가'의 유니코드 값. 10진수
    System.out.println(c1); 
    // 
    System.out.println(44032); // 얘는 숫자로 인식 
    
    char c2 = 0xAC00; // '가'의 유니코드 값. 16진수 
    System.out.println(c2);
    
    char c3 = '헐'; // '헐'의 유니코드 값. 당연히 이걸 가장 많이 사용
    // 작은따옴표를 이용하면 문자의 유니코드 값을 알아낼 수 있다. 
    System.out.println(c3);
    
    char c4 = '\uAC00'; // '가'의 유니코드 값을 리턴한다. 
    System.out.println(c4);

  }
}
