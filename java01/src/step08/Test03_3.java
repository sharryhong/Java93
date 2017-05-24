/* 유틸리티 클래스 : Object - equals()
 * => 원본과 재정의 */ 
package step08;

public class Test03_3 {
  
  static class Student1 {
    String name;
    int age;
    
    // equals() 재정의 하기 전. 주소가 같은지 비교한다. 
  }

  static class Student2 {
    String name;
    int age;
    
    // equals() 재정의 : 오버라이딩
    // 내용이 같은지 비교하고 싶다. 
    public boolean equals(Object obj) { // Object obj라는 것은, 어느 (서브) 클래스라도 가능하다는 뜻이다.(다형적변수개념)
      // 일단 obj 넘어오는 주소가 Student2 주소여야한다. 
      // 수퍼클래스의 메서드를 재정의한다는 것은 수퍼클래스의 메서드 리턴타입 등은 똑같아야한다. 
      // 만약 Object obj를 Student2 obj라고 수정한다는 것은 재정의가 아니라 새로 만드는게 된다. 
      if (!(obj instanceof Student2)) return false; // step09/ex4/Test04.java참고
      // 파라미터로 넘어온 값이 Student2 인스턴스의 주소가 맞다면, 
      // 검사하기 쉽게 Student2 타입으로 형변환한다. 
      Student2 other = (Student2)obj; // step09/ex4/Test05, 06.java참고
      // 형변환하기 전에 확실히 obj가 Student2인지 확인해야한다. 
      if (!(this.name.equals(other.name))) return false;
      if (this.age != other.age) return false;
      return true;
    }
  }
  
  public static void main(String[] args) {
    Student1 s1 = new Student1();
    s1.name = "홍길동";
    s1.age = 20;
    
    Student1 s2 = new Student1();
    s2.name = "홍길동";
    s2.age = 20;
    
    System.out.println(s1 == s2); // false. 당연히 주소 다르다. 
    System.out.println(s1.equals(s2)); // false. Object의 equals()는 주소를 비교한다. 결국 == 연산과 같다.
    
    Student2 s3 = new Student2();
    s3.name = "홍길동";
    s3.age = 20;
    
    Student2 s4 = new Student2();
    s4.name = "홍길동";
    s4.age = 20;

    System.out.println(s3 == s4); // false
    System.out.println(s3.equals(s4)); // true. 재정의한 equals() 사용
  }

}
