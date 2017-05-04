/* 변수 선언 : 문자 변수 
 */
package step02;

public class Test04 {

  public static void main(String[] args) {
    char c;       // 2byte 크기의 메모리. 정수 값을 저장
                  // short : (-32768 ~ 32767)
                  // char : (0 ~ 65535) 유니코드 저장. 유니코드는 음수가 없다. 
    short s; // 같은 2byte지만 char와 다르다. 비교
//    s = 40000; // 오류
    c = 0;
    c = 65535;
//    c = -1; // 오류
    // 일반적으로 문자의 유니코드 값을 저장할 때 작은따옴표를 사용한다. 
    c = '홍'; // 오해하지말자. '홍'문자를 저장하는 것이 아니다. 문자의 유니코드 값을 저장하는 것이다. 
    System.out.println(c);
    
    int i1 = '\b';
    int i2 = '\t';
    int i3 = '\n';
    int i4 = '\f';
    int i5 = '\r';
    int i6 = '\'';
    int i7 = '\"';
    int i8 = '\\';
    System.out.printf("%x, %x, %x, %x, %x, %x, %x, %x", i1, i2, i3, i4, i5, i6, i7, i8);
    // printf %x 16진수로 표현하라
  }

}
