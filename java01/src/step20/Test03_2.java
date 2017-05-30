/* JDBC 프로그래밍: try ~ catch ~ 를 이용하여 자원 해제 시키기 2 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test03_2 {

  public static void main(String[] args) {

    try {
      com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
      DriverManager.registerDriver(mysqlDriver);
    } catch (Exception e) {
      e.printStackTrace();
      return; // 드라이버 로딩하다가 예외가 발생하면 아래 실행할 필요없으므로 return해서 끝낸다. 
    }
    
    try ( // close()가 없는건 여기 둘 수 없다. 
        // 이 괄호 안에 선언하는 변수는 오로지 java.lang.AutoCloseable 구현체 만이 가능하다.
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





