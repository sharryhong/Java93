/* 사용자 정의 데이터 타입 : 사용자(개발자) 정의 데이터 타입 만들기 */
package step02;

public class Test12 {

  public static void main(String[] args) {
    
    // 1)
    // 변수 준비한게 아니라, Student는 name, .. 등을 담는다고 "정의"를 한 것이다. 설계도 만든 것 
    // 나중에 new를 사용해서 메모리를 만들 때, 
    // 즉, Student.name.. 이렇게 안된다! 오해하지말자~
    class Student {
      String name;
      byte[] scores;
      short total;
      float aver;
    }
    
    // 2) 
    // Student 메모리 주소를 저장할 변수 s1
    Student s1; 
    
    // 3) 
    // 설계도에 따라 메모리(인스턴스. instance)를 준비한다. 
    // new Student()가 리턴하는 것 : 준비된 메모리 주소
    // 정확하게 표현하자면 인스턴스라고 해야하지만, 개발자들은 퉁쳐서 객체라고도한다.
    // s1 : 레퍼런스 
    s1 = new Student(); 

    // 4) 
    s1.name = "홍길동";
    s1.scores = new byte[3];
    s1.scores[0] = 100;
    s1.scores[1] = 100;
    s1.scores[2] = 100;
    s1.total = (short)(s1.scores[0] + s1.scores[1] + s1.scores[2]);
    s1.aver = s1.total / 3f;
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", s1.name, s1.scores[0], s1.scores[1], s1.scores[2], s1.total, s1.aver);
    
    Student s2 = s1;  // 주소 복제 
    s2.name = "임꺽정";
    System.out.printf("%s, %d, %d, %d, %d, %f\n", s1.name, s1.scores[0], s1.scores[1], s1.scores[2], s1.total, s1.aver);

  }

}
