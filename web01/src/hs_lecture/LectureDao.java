/* 역할 : "High Cohesion" (응집력을 높게 유지하라)
 * => 출력하는 역할은 호출자에게 맡기자. 
 * DAO는 return만 하자.
 * => 커넥션 
 */
package hs_lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LectureDao {
  
  DBConnectionPool conPool;
  
  public LectureDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }

  public List<Lecture> selectList(int pageNo, int pageSize) throws Exception { 
 
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement(
        "select lno, titl, date_format(sdt,'%Y-%m-%d') sdt , date_format(edt,'%Y-%m-%d') edt, qty, thrs, pric from lect order by sdt desc limit ?, ?");) {
      
      stmt.setInt(1, (pageNo - 1) * pageSize); 
      stmt.setInt(2, pageSize); 
      
      ArrayList<Lecture> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Lecture lecture = null;
        while (rs.next()) { 
          lecture = new Lecture();
          lecture.setNo(rs.getInt("lno"));
          lecture.setTitle(rs.getString("titl"));
          lecture.setStartDate(rs.getString("sdt"));
          lecture.setEndDate(rs.getString("edt"));
          lecture.setQuantity(rs.getInt("qty"));
          lecture.setPrice(rs.getInt("pric"));
          lecture.setThrs(rs.getInt("thrs"));
          
          list.add(lecture);  // ArrayList에 주소 저장
        }
        return list; // 모두 정상적으로 했으면 리턴
      }
      
    } finally { // 다 쓴 커넥션 반납위해 필요하다. finally는 try블록을 벗어나기 전에 반드시 실행되므로.. try문에서 return문장 실행전에 실행된다. 
      conPool.returnConnection(con);
    }
  }
  
  // 상세정보 보기 
  public Lecture selectOne(int no) throws Exception { 
    Connection con = conPool.getConnection();
    try (  // try()괄호 안에는 객체를 준비하는 코드만 들어갈 수 있다.
      PreparedStatement stmt = con.prepareStatement(
        "select lno, titl, dscp, date_format(sdt,'%Y-%m-%d') sdt, "
        + "date_format(edt,'%Y-%m-%d') edt, qty, pric, thrs, crmno, mrno from lect where lno=?");) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) { // 자동으로 close()하라고 try()안에 넣은것
        if (!rs.next()) {
          return null;
        }
        Lecture lecture = new Lecture(); 
        lecture.setNo(rs.getInt("lno"));
        lecture.setCrmno(rs.getInt("crmno"));
        lecture.setMrno(rs.getInt("mrno"));
        lecture.setTitle(rs.getString("titl"));
        lecture.setDescription(rs.getString("dscp"));
        lecture.setStartDate(rs.getString("sdt"));
        lecture.setEndDate(rs.getString("edt"));
        lecture.setQuantity(rs.getInt("qty"));
        lecture.setPrice(rs.getInt("pric"));
        lecture.setThrs(rs.getInt("thrs"));
        return lecture;
      }
      
    } finally { // 다 쓴 커넥션 반납위해 필요하다. finally는 try블록을 벗어나기 전에 반드시 실행되므로.. try문에서 return문장 실행전에 실행된다. 
      conPool.returnConnection(con);
    }
  }
//  
////아예 lecture lecture에 담아서 온다.
//  public int insert(Lecture lecture) throws Exception { // 1) lecture lecture 인스턴스 주소를 받아서 
//    Connection con = conPool.getConnection();
//    try (
//        PreparedStatement stmt = con.prepareStatement(
//            "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");
//      ) {
//        stmt.setString(1, lecture.getTitle());
//        stmt.setString(2, lecture.getDescription());
//        stmt.setString(3, lecture.getStartDate());
//        stmt.setString(4, lecture.getPassword());
//        return stmt.executeUpdate(); // 4) insert실행  
//      } finally {  
//        conPool.returnConnection(con);
//      }
//  }
//  
//  public int delete(int no) throws Exception { // 1) 삭제할 데이터의 넘버를 받아서 
//    Connection con = conPool.getConnection();
//    try (
//        PreparedStatement stmt = con.prepareStatement(
//            "delete from memb where mno=?");) { // 2) sql문의 인파라미터에 넣고, delete를 실행한 후
//        stmt.setInt(1, no); // 3) 그 번호에 해당하는 
//        return stmt.executeUpdate(); // 4) delete된 갯수를 리턴한다
//      } finally {  
//        conPool.returnConnection(con);
//      }
//  }
//  
//  public int update(Lecture lecture) throws Exception {
//    Connection con = conPool.getConnection();
//    try (
//        PreparedStatement stmt = con.prepareStatement(
//            "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");
//      ) {
//        stmt.setString(1, lecture.getName());
//        stmt.setString(2, lecture.getTel());
//        stmt.setString(3, lecture.getEmail());
//        stmt.setString(4, lecture.getPassword());
//        stmt.setInt(5, lecture.getNo());
//        return stmt.executeUpdate();
//      } finally {  
//        conPool.returnConnection(con);
//      }
//  }
}
