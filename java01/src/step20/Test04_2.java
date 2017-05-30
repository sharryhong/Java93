/* JDBC 프로그래밍: 특정 DBMS에 종속되는 것 막기 2 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04_2 {

  public static void main(String[] args) {

    try {
      String driverClassName = System.getProperty("jdbc.driver");
      Class.forName(driverClassName);
    } catch (Exception e) {
      e.printStackTrace();
      return;  
    }
    
    try ( 
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/webappdb", 
            "webapp", 
            "1111"); 
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");
        ) {
      while (rs.next()) { 
        System.out.printf("%d, %s, %s, %s\n", 
            rs.getInt("mno"), 
            rs.getString("name"), 
            rs.getString("tel"), 
            rs.getString("email"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } 
  }

}





