/* JDBC 프로그래밍: DAO + Connection Pooling 
 * => Pooling 기법? 
 */
package step22.ex3;

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

    // DB커넥션을 관리할 객체를 만든다.
    DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    
    // DAO에 DB커넥션 풀을 전달한다. 
    MemberDao memberDao = new MemberDao(conPool);
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





