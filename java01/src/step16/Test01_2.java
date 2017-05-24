/* File 다루기 - File 클래스 사용법 2 : 파일 생성 */
package step16;

import java.io.File;

public class Test01_2 {

  public static void main(String[] args) throws Exception { 
    // 파일경로가 '/'로 시작하면 절대경로, 아니면 상대경로
    // 상대경로일 때 기준 : 이클립스에서 실행하면 프로젝트 폴더가 기준
    File f = new File("hello.txt");
    
    // 1) 파일 생성
    f.createNewFile(); // java01폴더에 생성된다. 
    
    // 2) 파일 삭제
//    f.delete(); // 해당파일 삭제
  }

}
