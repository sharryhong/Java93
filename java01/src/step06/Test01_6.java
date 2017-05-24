/* class 문법의 용도 6 */ 

package step06;

public class Test01_6 {
  
  public static void main(String[] args) {
    //
    Student3 s1 = new Student3("홍길동", 100, 100, 100);
    s1.compute();
    
    Student3 s2 = new Student3("임꺽정", 90, 90, 90);
    s2.compute();
    
    Student3 s3 = new Student3("유관순", 80, 80, 80);
    s3.compute();
    
    s1.print();
    s2.print();
    s3.print();
  }

}
