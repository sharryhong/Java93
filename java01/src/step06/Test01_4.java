/* class 문법의 용도 4 */ 

package step06;

public class Test01_4 {
  
  public static void main(String[] args) {
    // 같은 패키지에 소속된 클래스 바로 사용
    // 다른 패키지에 선언된 클래스 사용시에는 반드시 패키지명 적어야함 ex)java.util.ArrayList.. 
    Student s1 = new Student(); 
    Student.init(s1, "홍길동", 100, 100, 100);
    Student.compute(s1);
    
    Student s2 = new Student();
    Student.init(s2, "임꺽정", 90, 90, 90);
    Student.compute(s2);
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    
    Student.print(s1);
    Student.print(s2);
    Student.print(s3);
  }

}
