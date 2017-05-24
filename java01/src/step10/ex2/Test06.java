/* 다형성 - 형변환의 희대의 사기꾼! */
package step10.ex2;

public class Test06 {

  public static void main(String[] args) {

    Member m = new Member(); // 1)
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";

    FreeStudent s = (FreeStudent)m;  // 2) 사기! 컴파일러는 넘어갈 수 있지만 JVM은 속일 수 없다. 
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
