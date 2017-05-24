/* class 문법의 용도 5 */ 

package step06;

public class Test01_5 {
  
  public static void main(String[] args) {
    //
    Student2 s1 = new Student2();
    s1 = new Student2(); 
    s1.init("홍길동", 100, 100, 100);
    s1.compute();
    
    Student2 s2 = new Student2();
    s2.init("임꺽정", 90, 90, 90);
    s2.compute();
    
    Student2 s3 = new Student2();
    s3.init("유관순", 80, 80, 80);
    s3.compute();
    
    s1.print();
    s2.print();
    s3.print();
  }

}
