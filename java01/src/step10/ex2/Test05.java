/* 다형성 - 다형적 변수와 형변환 
 * => 인스턴스 주소를 원래의 타입으로 변환할 수 있다. */
package step10.ex2;

public class Test05 {

  public static void main(String[] args) {

    Member m = new FreeStudent();
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";
//    m.schoolName = "비트대학교"; // Error! 
    // 자바컴파일러는 문법검사만 한다. 
    // Member m 이라는 것은 Member Type.. 여기엔 schoolName이 없으므로 에러이다. 
    // JVM은 실행
    
    FreeStudent s = (FreeStudent)m; // 이렇게 형변환하면 이제 쓸 수 있다. 
    // s와 m에 들어있는 주소는 같지만, 컴파일러 문법검사에서는 
    // Member m 이라고 했을 땐 Member Type만 체크하므로 위처럼 에러가난다. 
    // 따라서 이렇게 형변환 하는 것이다. 
    s.schoolName = "비트대학교";
    s.grade = 4;
    s.accont = "111-1111";
    s.bank = "비트은행";
    s.working = true;
    
    System.out.println(s.name); // 같은 주소이므로 이렇게 되는 것이다. 
    System.out.println(s.id);
    System.out.println(s.password);
    System.out.println(s.schoolName);
    System.out.println(s.grade);
    System.out.println(s.accont);
    System.out.println(s.bank);
    System.out.println(s.working);
  }

}
