/* JDBC 프로그래밍: PreparedStatement 객체 사용 전 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test05_1 {

  public static void main(String[] args) throws Exception {
    // 테스트용
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    String name = "홍길동101";
    String tel = "00-1111";
    String email = "hong101@test.com";
    String password = "1111";
    
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
      int count = stmt.executeUpdate("insert into memb(name,tel,email,pwd) values('" + 
        name + "', '" +
        tel + "', '" +
        email + "', password('" + 
        password + "')");
      System.out.println(count);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}





