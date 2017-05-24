/* charactor stream 클래스 : FileWriter vs FileOutputStream 
 */
package step16;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Test06_1_out {

  public static void main(String[] args) throws Exception {
    
    // 바이너리 스트림 클래스는 무조건 끝 1바이트만 출력한다. 
    FileOutputStream out = new FileOutputStream("temp/test06_1_byte.data");
    out.write('A'); // 0x0041
    out.write('B'); // 0x0042
    out.write('C'); // 0x0043
    out.write('a'); // 0x0061
    out.write('b'); // 0x0062
    out.write('c'); // 0x0063
    out.write('가'); // 0xac00
    out.write('각'); // 0xac01
    out.write('간'); // 0xac04
    
    // => 41 42 43 61 62 63 00 01 04 로 저장된다.     
    out.close();
    
    // 캐릭터 스트림 클래스는 유니코드를 os기본 문자집합의 코드값으로 변환하여 출력 
    FileWriter out2 = new FileWriter("temp/test06_1_char.data");
    out2.write('A'); // 0x0041 -> 41
    out2.write('B'); // 0x0042 -> 42
    out2.write('C'); // 0x0043 -> 43
    out2.write('a'); // 0x0061 -> 61
    out2.write('b'); // 0x0062 -> 62
    out2.write('c'); // 0x0063 -> 63
    out2.write('가'); // 0xac00 -> 한글의 경우 3byte. eab080
    out2.write('각'); // 0xac01 -> eab081
    out2.write('간'); // 0xac04 eab084
    
    // => 41 42 43 61 62 63 EA B0 80 EA B0 81 EA B0 84 (이클립스 기본실행환경이 utf8. JVM 실행할 때 기본 캐릭터셋을 utf8)
    // => 41 42 43 61 62 63 B0 A1 B0 A2 B0 A3 (윈도우즈 명령창에서 실행시. Windows OS의 기본 케릭터셋 MS-949)
    // 명령창에서 >java -cp bin -Dfile.encoding=utf8 step16.Test06_1_out하면 utf8로 나온다. 
    out2.close();
  }
}
