package step04.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  // 개별관리를 위해 인스턴스 변수로 만듬 
  String url;
  String username;
  String password;
  
  // 반납한 커넥션을 보관해두는 컬렉션
  ArrayList<Connection> conList = new ArrayList<>();
  
  public DBConnectionPool(String driver, String url, String username, String password) throws Exception {
    Class.forName(driver);
    this.url = url;
    this.username = username;
    this.password = password;
  }
  
  // DB 커넥션 객체를 임대
  public Connection getConnection() throws Exception {
    if (conList.size() > 0) {   // 컬렉션에 보관된 게 있으면 
      return conList.remove(0); // 제일 앞에 있는 것 꺼내서 리턴
    }
    // 컬렉션에 없으면 새로 만들어서 리턴
    return DriverManager.getConnection(this.url, this.username, this.password);
  }
  
  // DB 커넥션 객체를 반납
  public void returnConnection(Connection con) {
    conList.add(con);
  }
}
