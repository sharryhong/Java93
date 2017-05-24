/* 리터럴 - 이스케이프(escape) 문자
 * 일반 문자가 아닌 특별한 명령어를 의미하는 문자
 */
package stap01;

public class Test12 {

  public static void main(String[] args) {
    System.out.println("ABC\b가각간");  // \b : backspace (유니코드: 0x0008)  AB가각간
      // 명령창에서는 되지만 eclipse 콘솔창에서는 제대로 안보인다.
    System.out.println("ABC\t가각간"); // \t : tab (0x0009)
    System.out.println("ABC\n가각간"); // \n : linefeed(newline) (0x000a). 줄바꾸고 커서를 처음으로 보낸다. 
    System.out.println("ABC\f가각간"); // \f : formfeed (0x000c). 현재 커서의 위치에서 줄을 바꾼다.  
      // 명령창에서는 되지만 eclipse 콘솔창에서는 제대로 안보인다.
    System.out.println("--------------------------------");
    System.out.println("ABC\r가각간"); // \r : carrage return (0x000d)
      // 명령창에서는 되지만 eclipse 콘솔창에서는 제대로 안보인다.
    System.out.println("ABC\"가각간"); // 잘됨
    System.out.println("ABC\'가각간"); // 잘됨
    System.out.println("ABC'가각간"); // 잘됨
    
    // 작은따옴표 문자의 유니코드 값을 알고 싶다. 
    // char c1 = ''';
    char c1 = '\'';
    System.out.println(c1);
    // 역슬래시를 그냥 적으면, 다음에 이스케이프 문자가 와야한다. 
    // System.out.println("아아아\아아아"); 안되~ 
    // 이렇게 해야한다.  
    System.out.println("아아아\\아아아");
    // 특히 파일경로 표현할 때 주의
    System.out.println("c:\\workspace\\java01\\src\\step01\\Test12.java");
  }
}
