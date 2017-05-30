/* JDBC 프로그래밍: 특정 DBMS에 종속되는 것 막기
 * => 기존 코드에서는 java.sql.Driver구현체의 인스턴스를 만들기 위해 직접 클래스명을 언급하였다. 
 * >> 구현체 : 이 규칙에 따라 만든 클래스 
 * 예) com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver(); 
 * => 문제 : 코드가 특정 DBMS에 종속됨
 *    즉, 다른 DBMS에 접속하려면 코드를 변경한 후 컴파일해야함 
 * => 해결??
 *    java.sql. 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04_1 {

  public static void main(String[] args) {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
//      com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
//      DriverManager.registerDriver(mysqlDriver);
      
      //
      String driverClassName = System.getProperty("jdbc.driver");
      // 
      Class.forName(driverClassName);
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/webappdb", 
          "webapp", 
          "1111"); 
      
      stmt = con.createStatement();
      rs = stmt.executeQuery("select mno, name, tel, email from memb");
      while (rs.next()) { 
        System.out.printf("%d, %s, %s, %s\n", 
            rs.getInt("mno"), 
            rs.getString("name"), 
            rs.getString("tel"), 
            rs.getString("email"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally { 
      // close()하다 예외뜬다. finally블록안의 try블록에서 예외발생시 바로 catch로 가므로, 다른 것들 close()안될 수 있다. 
      // 따라서 어쩔 수 없이 따로따로 한다. 
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}





