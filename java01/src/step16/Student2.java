package step16;

import java.io.Serializable;

// 이 클래스의 인스턴스 값을 직렬화하여 출력하는 것을 허락하자.
public class Student2 implements Serializable {
  
  // 객체의 인스턴스 값을 직렬화하여 저장할때 저장되는 데이터의 버전번호
  // 활용?
  // => 읽는 쪽에서 버전번호를 활용해서 데이터호환여부를 손쉽게 검사할 수 있다. 
  // 예를들어 수정되면 버전번호를 바꾼다.
  private static final long serialVersionUID = 1L;
  
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  boolean working;
  
  public Student2() {}
  
  public Student2(String name, int kor, int eng, int math, boolean working) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
    this.aver = this.sum / 3f;
    this.working = working;
  }

  public String toString() {
    return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
        + aver + ", working=" + working + "]";
  }
  
  
}
