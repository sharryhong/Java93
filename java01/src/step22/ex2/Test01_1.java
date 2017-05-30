/* JDBC 프로그래밍: DAO에서 출력 기능 제거, 데이터 처리만 하도록 변경한다. 
 */
package step22.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    MemberDao memberDao = new MemberDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    List<Member> list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("---------------------------");
    
//    System.out.println(memberDao.delete(119)); // 몇 개 delete?
//    System.out.println("---------------------------");
//    
//    Member member = new Member();
//    member.setName("홍길동104");
//    member.setTel("000-1111");
//    member.setEmail("hong104@test.com");
//    member.setPassword("1111");
//    System.out.println(memberDao.insert(member)); // 몇 개 insert?
//    System.out.println("---------------------------");
//    
      Member member = new Member();
      member.setNo(120); // 변경하려는 데이터의 mno
      member.setName("홍길동 변경");
      member.setTel("000-2222");
      member.setEmail("hong104@test.com");
      member.setPassword("1111");
      memberDao.update(member);
      memberDao.selectList();
      System.out.println("---------------------------");
    
  }

}





