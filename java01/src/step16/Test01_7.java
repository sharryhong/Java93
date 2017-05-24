/* File 다루기 - File 클래스 사용법 7 
 * => 특정 확장자를 가진 파일만 출력하기 2) 제대로 해보자! 
 *    목록을 만들 때 제약조건을 걸어보자. 프로그래밍이 편해진다. */
package step16;

import java.io.File;
import java.io.FileFilter;

public class Test01_7 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    displayDirectory(f, 0);
  }

  public static void displayDirectory(File dir, int level) {
    File[] files = dir.listFiles(new MyFileFilter()); // 이 규칙에 따라서 만든 인스턴스의 주소

    for (File file : files) {
      if (file.isDirectory()) {
        displayDirectory(file, level + 1);
      } else {
        System.out.printf("%s\n", file.getPath());
      }
    }
  }
  
  // fileFilter 인터페이스 규칙에 따라 클래스를 만든다. 
  // 규칙을 하나라도 빠트리면 안된다. 
  // 이클립스 자동기능으로 만들자. (MyFileFilter에 마우스 올리면 나옴)
  // 이 클래스의 accept()메서드는 File.listFiles()메서드가 호출할 것이다. 
  // 1) OS를 통해 해당폴더의 파일, 디렉토리 목록 가져온다.
  // 2) 그 중 한개의 디렉토리 또는 파일을 꺼내, 리턴되는 목록에 추가할 지 물어본다. 
  // 3) accept()를 호출하여 물어본다. 
  static class MyFileFilter implements FileFilter {

    public boolean accept(File file) {
      if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))) { // 디렉토리거나 파일이름이 .class라면
        return true; // 리턴할 항목에 포함
      }
      return false;
    }
    
  }
}
