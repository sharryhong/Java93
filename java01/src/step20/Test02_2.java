/* JDBC 프로그래밍: Statement 객체 - INSERT 실행
 * => Statement.executeUpdate()
 *    - INSERT, UPDATE, DELETE 문 등 DML, DDL을 실행한다. 
 */
package step20;

import java.sql.DriverManager;

public class Test02_2 {

  public static void main(String[] args) throws Exception {

    com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();

    DriverManager.registerDriver(mysqlDriver);

    java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", 
        "webapp", 
        "1111"); 

    java.sql.Statement stmt = con.createStatement();

    int count = stmt.executeUpdate("insert into memb(name,tel,email,pwd) " 
        + " values('홍길동', '1212-1111', 'hong100@text.com', password('1111'))");
    
    System.out.println(count);

    stmt.close();

    con.close();

  }

}





