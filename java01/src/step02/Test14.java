/* 사용자 정의 데이터 타입 : 배열 값 초기화시키기 */
package step02;

public class Test14 {
  
  // Test13.java에서처럼 main에 있으면 main에서만 쓸 수 있으므로 위치를 이렇게 바꾸자.
  // 나중에 중첩 클래스도 배운다. 
  static class Student {
    String name;
    byte[] scores;
    short total;
    float aver;
  }
  
  // 리턴값이 Student의 주소
  public static Student createStudent(String name, byte kor, byte eng, byte math) {
    Student s = new Student(); // s엔 주소 담김
    s.name = name;
//    s.scores = new byte[3]; // byte type의 배열 3개 만들어서 주소를 scores 담는다. 
    s.scores = new byte[]{kor, eng, math};
    s.total = (short)(kor + eng + math);
    s.aver = s.total / 3f;
    return s; // 이렇게 세팅된 인스턴스의 주소를 리턴한다. 
  }

  public static void main(String[] args) {
     
    Student[] arr1 = new Student[3];

    arr1[0] = createStudent("홍길동", (byte)100, (byte)100, (byte)100);
    arr1[1] = createStudent("임꺽정", (byte)90, (byte)90, (byte)90);
    arr1[2] = createStudent("유관순", (byte)80, (byte)80, (byte)80);
    
    for (int i = 0; i < arr1.length; i++) {
      System.out.printf("%s, %d, %d, %d, %d, %f\n", arr1[i].name, arr1[i].scores[0], arr1[i].scores[1], arr1[i].scores[2], arr1[i].total, arr1[i].aver);      
    }

  }

}
