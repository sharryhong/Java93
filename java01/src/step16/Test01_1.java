/* File 다루기 - File 클래스 사용법 : 메서드들 알아보자.*/
package step16;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Test01_1 {

  // 실무같으면 try ~ catch로 예외처리해야하지만, 공부하는 중에는 이렇게 처리한다.
  public static void main(String[] args) throws Exception { 
    File f = new File("./build.gradle"); // 만약 ./ 라고하면 현재 폴더 정보를 가져온다. 
    
    // 이클립스에서 자바프로그램을 실행할 때 현재 위치는 프로젝트 폴더이다.
    System.out.println(f.getAbsolutePath());

    // getAbsolutePath() : 최종 계산된 경로를 리턴하는 것이 아니라, 경로 값을 그대로 리턴한다. 
    // 만약 File f = new File("../.."); // 상위, 상위라고 할 경우 C:\workspace\java01\..\..\ 로 표시된다. 
    
    // getCanonicalPath() : .. 이나 . 명령을 처리하여 최종 경로 리턴
    // 문제는 .. 을 잘못사용하여 존재하지 않는 디렉토리 경로가 나왔을 때, 예외를 던진다. 
    // 그래서 이 메서드를 호출할 때는 예외를 받을 수 있도록 예외처리 문장을 작성해야한다. 
    System.out.println(f.getCanonicalPath());
    System.out.println(f.getFreeSpace()); // getFreeSpace() : file의 경로가 가리키는 디스크의 여유 공간을 바이트 단위로 리턴한다.
    System.out.println(f.getTotalSpace()); // 디스크의 총 크기를 바이트 단위로 리턴
    System.out.println(f.getUsableSpace()); // 사용 가능한 공간
    System.out.println(f.getName()); // ..이나 .을 계산하기 전. 디렉토리명 or 파일명. 만약 new File("../build.gradle");이라면 build.gradle
    System.out.println(f.getPath()); // File클래스에서 지정한 경로. 만약 new File("../build.gradle");이라면  ..\build.gradle
    System.out.println(f.exists()); // 해당 경로의 디렉토리가, 파일의 존재 여부를 리턴. 있으면 true
    System.out.println(f.isDirectory()); // File객체가 가리키는 경로가 디렉토리이면 true 리턴
    System.out.println(f.isFile()); // File객체가 가리키는 경로가 파일이면 true 리턴
    System.out.println(f.length()); // file이면 file의 크기를 바이트 단위로 리턴한다.
    
    System.out.println(f.lastModified()); // 파일의 마지막 변경일을 밀리초로 리턴
    
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(f.lastModified());
    System.out.printf("%d-%d-%d %s %d:%d:%d\n",
        cal.get(Calendar.YEAR),
        cal.get(Calendar.MONTH)+1,
        cal.get(Calendar.DAY_OF_MONTH),
        cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM",
        cal.get(Calendar.HOUR),
        cal.get(Calendar.MINUTE),
        cal.get(Calendar.SECOND)); 
    // Calendar.YEAR는 상수값으로 저장된 1. 원래는 get(1)이 Year였다.
  }

}
