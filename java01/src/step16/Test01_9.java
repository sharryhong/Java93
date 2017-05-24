/* File 다루기 - File 클래스 사용법 => 클로저로 만들기 */
package step16;

import java.io.File;
import java.io.FileFilter;

public class Test01_9 {

  public static void main(String[] args) throws Exception { 

    File f = new File("../");
    displayDirectory(f, 0);
  }

  public static void displayDirectory(File dir, int level) {
    // lamda 문법
    // 반드시 메서드가 한 개인 인터페이스나 클래스만 가능하다. 
    // 메서드 한개짜리 익명클래스를 만드는 단축문법
    File[] files = dir.listFiles((File file) -> {
      if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))) {
        return true;
      }
      return false;
    }); 

    for (File file : files) {
      if (file.isDirectory()) {
        displayDirectory(file, level + 1);
      } else {
        System.out.printf("%s\n", file.getPath());
      }
    }
  }
}
