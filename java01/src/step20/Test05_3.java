/* JDBC 프로그래밍: Statement와 PreparedStatement 비교 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test05_3 {

  public static void main(String[] args) throws Exception {
    // 테스트용
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
//    String email = "hong102@test.com";
    // !!!
    String email = "hong102@test.com' or email like('hong1%') or email='ㅋㅋ";
    
    try {
//      String driverClassName = System.getProperty("jdbc.driver");
      Class.forName(jdbcDriver);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    try (
      Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
      Statement stmt = con.createStatement();
        ) {
 
      int count = stmt.executeUpdate("delete from memb where email='" + email + "'");
      System.out.println(count);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}





