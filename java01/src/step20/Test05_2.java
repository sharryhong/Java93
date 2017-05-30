/* JDBC 프로그래밍: PreparedStatement 객체 사용 후 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test05_2 {

  public static void main(String[] args) throws Exception {
    // 테스트용
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    String name = "홍길동104";
    String tel = "222-1111";
    String email = "hong104@test.com";
    String password = "1111";
    
    try {
//      String driverClassName = System.getProperty("jdbc.driver");
      Class.forName(jdbcDriver);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    try (
      Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword); 
      //
      PreparedStatement stmt = con.prepareStatement("insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");
        ) {
      //
      stmt.setString(1, name);
      stmt.setString(2, tel);
      stmt.setString(3, email);
      stmt.setString(4, password);
      // 
      int count = stmt.executeUpdate();
      System.out.println(count);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}





