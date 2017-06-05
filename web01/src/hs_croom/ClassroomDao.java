/* 역할 : "High Cohesion" (응집력을 높게 유지하라)
 * => 출력하는 역할은 호출자에게 맡기자. 
 * DAO는 return만 하자.
 * => 커넥션 
 */
package hs_croom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDao {
  
  DBConnectionPool conPool;
  
  public ClassroomDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }

  public List<Classroom> selectList(int pageNo, int pageSize) throws Exception { 
    // 
    Connection con = conPool.getConnection(); // 자동해제되면 안되므로 try(...)안에 두면 안된다. 
    try ( 
      PreparedStatement stmt = con.prepareStatement(
        "select crmno, name from croom order by name asc limit ?, ?");) {
      
      stmt.setInt(1, (pageNo - 1) * pageSize); // 시작 인덱스
      stmt.setInt(2, pageSize); // 꺼낼 갯수 
      
      ArrayList<Classroom> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Classroom classroom = null;
        while (rs.next()) { 
          classroom = new Classroom(); // 새로 인스턴스 만들고 주소 저장
          classroom.setNo(rs.getInt("crmno")); // 그 주소의 인스턴스에 값 넣기 
          classroom.setName(rs.getString("name"));
          
          list.add(classroom);  // ArrayList에 주소 저장
        }
        return list; // 모두 정상적으로 했으면 리턴
      }
      
    } finally { // 다 쓴 커넥션 반납위해 필요하다. finally는 try블록을 벗어나기 전에 반드시 실행되므로.. try문에서 return문장 실행전에 실행된다. 
      conPool.returnConnection(con);
    }
  }
  
  // 상세정보 보기 
  public Classroom selectOne(int no) throws Exception { 
    Connection con = conPool.getConnection();
    try (  // try()괄호 안에는 객체를 준비하는 코드만 들어갈 수 있다.
      PreparedStatement stmt = con.prepareStatement(
        "select crmno, name from croom where crmno=?");) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) { // 자동으로 close()하라고 try()안에 넣은것
        if (!rs.next()) {
          return null;
        }
        Classroom classroom = new Classroom(); 
        classroom.setNo(rs.getInt("crmno")); // 그 주소의 인스턴스에 값 넣기 
        classroom.setName(rs.getString("name"));

        return classroom;
      }
      
    } finally { // 다 쓴 커넥션 반납위해 필요하다. finally는 try블록을 벗어나기 전에 반드시 실행되므로.. try문에서 return문장 실행전에 실행된다. 
      conPool.returnConnection(con);
    }
  }
  
//아예 classroom classroom에 담아서 온다.
  public int insert(Classroom classroom) throws Exception { // 1) classroom classroom 인스턴스 주소를 받아서 
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into croom(name) values(?)"); // 3) 인파라미터에 채워놓고
      ) {
        stmt.setString(1, classroom.getName()); // 2) 그 주소의 인스턴스 해당 값을 꺼내서
        return stmt.executeUpdate(); // 4) insert실행  
      } finally {  
        conPool.returnConnection(con);
      }
  }
  
  public int delete(int no) throws Exception { // 1) 삭제할 데이터의 넘버를 받아서 
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from croom where crmno=?");) { // 2) sql문의 인파라미터에 넣고, delete를 실행한 후
        stmt.setInt(1, no); // 3) 그 번호에 해당하는 
        return stmt.executeUpdate(); // 4) delete된 갯수를 리턴한다
      } finally {  
        conPool.returnConnection(con);
      }
  }
  
  public int update(Classroom classroom) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update croom set name=? where crmno=?");
      ) {
        stmt.setString(1, classroom.getName());
        stmt.setInt(2, classroom.getNo());
        return stmt.executeUpdate();
      } finally {  
        conPool.returnConnection(con);
      }
  }
}
