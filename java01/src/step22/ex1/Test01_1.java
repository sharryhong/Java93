/* JDBC 프로그래밍: DAO(Data Access Object) 적용 
 */
package step22.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    // 테스트용
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    MemberDao memberDao = new MemberDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    memberDao.selectList();
    System.out.println("---------------------------");
    
    /*
    memberDao.delete(119);
    memberDao.selectList();
    System.out.println("---------------------------");
    
    memberDao.insert("홍길동104", "004-1111", "hong104@test.com", "1111");
    memberDao.selectList();
    System.out.println("---------------------------");
    
    memberDao.update(119, "홍길동변경", "004-2222", "hong104@test.com", "1122");
    memberDao.selectList();
    System.out.println("---------------------------");*/
    
  }

}





