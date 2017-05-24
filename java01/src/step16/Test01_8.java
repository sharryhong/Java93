/* File 다루기 - File 클래스 사용법 7 
 * => 특정 확장자를 가진 파일만 출력하기 2) 제대로 해보자! 
 *    목록을 만들 때 제약조건을 걸어보자. 프로그래밍이 편해진다. */
package step16;

import java.io.File;
import java.io.FileFilter;

public class Test01_8 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    displayDirectory(f, 0);
  }

  public static void displayDirectory(File dir, int level) {
    // FileFilter를 익명클래스로 만들 때의 이점?
    // => 어차피 한 개의 객체만 필요하다. 쓸데없이 inner class를 만들필요없다.
    //    그리고 그 코드 가까이에 있기 때문에 익명 클래스가 무엇을 하는지 이해하기 쉽다.
    File[] files = dir.listFiles(new FileFilter() { // 익명 클래스이므로 class선언하지 않아도 된다. 
                                                    // 익명 클래스는 정의하는 즉시 인스턴스 생성
                                                    // 수퍼클래스인 Object의 생성자 호출 

      public boolean accept(File file) {
        if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))) { // 디렉토리거나 파일이름이 .class라면
          return true; // 리턴할 항목에 포함
        }
        return false;
      }
      
    }); // 이 규칙에 따라서 만든 인스턴스의 주소

    for (File file : files) {
      if (file.isDirectory()) {
        displayDirectory(file, level + 1);
      } else {
        System.out.printf("%s\n", file.getPath());
      }
    }
  }
}
