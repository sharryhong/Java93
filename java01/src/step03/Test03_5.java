/* 기타 연산자 : 비트논리 연산자 응용*/

package step03;

public class Test03_5 {

  public static void main(String[] args) {
    /* 권한 정보를 다룰 때 비트 연산자를 사용할 수 있다. 
     * => 읽기, 쓰기, 실행 권한을 한 개의 값으로 표현할 수 있다. */
    int a = 0b111; // a사람 : 읽기, 쓰기, 실행권한
    int b = 0b100; // b사람 : 읽기권한만 
    int c = 0b001; // c사람 : 실행권한만 
    
    // 어떤 파일의 권한 정보 
    // a, b, c 중에서 이 파일에 대해 누가 쓰기 권한이 있는지 검사해보자. 
    final int READ = 0b100;
    final int WRITE = 0b010;
    final int EXEC = 0b001;
    
    // 쓰기권한 알아보기
    System.out.println((a & WRITE) == WRITE);
    System.out.println((b & WRITE) == WRITE);
    System.out.println((c & WRITE) == WRITE);

  }

}
