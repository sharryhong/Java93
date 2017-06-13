package bitcamp.java93.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java93.domain.Member;
import bitcamp.java93.domain.Teacher;
import bitcamp.java93.utill.DBConnectionPool;

public class TeacherDao {
  
  DBConnectionPool conPool;
  
  public TeacherDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }

  public List<Teacher> selectList(int pageNo, int pageSize) throws Exception { 
    // 
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement(
        "select m.mno, m.name, m.tel, m.email, t.hmpg"
        + " from tcher t inner join memb m on t.tno=m.mno"
        + " order by m.name asc limit ?, ?");) {
      
      stmt.setInt(1, (pageNo - 1) * pageSize);
      stmt.setInt(2, pageSize); 
      
      ArrayList<Teacher> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery();) {
        Teacher teacher = null;
        while (rs.next()) { 
          teacher = new Teacher(); 
          teacher.setNo(rs.getInt("mno")); 
          teacher.setName(rs.getString("name"));
          teacher.setTel(rs.getString("tel"));
          teacher.setEmail(rs.getString("email"));
          teacher.setHomepage(rs.getString("hmpg"));
          
          list.add(teacher); 
        }
        return list;
      }
      
    } finally {  
      conPool.returnConnection(con);
    }
  }
  
  // 상세정보 보기 
  public Teacher selectOne(int no) throws Exception { 
    Connection con = conPool.getConnection();
    try ( 
      PreparedStatement stmt = con.prepareStatement(
        "select m.mno, m.name, m.tel, m.email, t.hmpg, t.fcbk, t.twit"
        + " from tcher t inner join memb m on t.tno=m.mno where t.tno=?");) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) {
          return null;
        }
        Teacher teacher = new Teacher(); 
        teacher.setNo(rs.getInt("mno"));
        teacher.setName(rs.getString("name"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setHomepage(rs.getString("hmpg"));
        teacher.setFacebook(rs.getString("fcbk"));
        teacher.setTwitter(rs.getString("twit"));
        return teacher;
      }
      
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public Teacher selectOneByEmailPassword(String email, String password) throws Exception { 
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
        "select m.mno, m.name, m.tel, m.email, t.hmpg, t.fcbk, t.twit"
        + " from tcher t inner join memb m on t.tno=m.mno"
        + " where email=? and pwd=password(?)");) {
      
      stmt.setString(1, email);
      stmt.setString(2, password);
      
      try (ResultSet rs = stmt.executeQuery();) { 
        if (!rs.next()) {
          return null;
        }
        Teacher teacher = new Teacher(); 
        teacher.setNo(rs.getInt("mno"));
        teacher.setName(rs.getString("name"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setHomepage(rs.getString("hmpg"));
        teacher.setFacebook(rs.getString("fcbk"));
        teacher.setTwitter(rs.getString("twit"));
        return teacher;
      }
      
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Teacher teacher) throws Exception {  
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into tcher(tno,hmpg,fcbk,twit) values(?,?,?,?)"); 
      ) {
        stmt.setInt(1, teacher.getNo());
        stmt.setString(2, teacher.getHomepage());
        stmt.setString(3, teacher.getFacebook());
        stmt.setString(4, teacher.getTwitter());
        return stmt.executeUpdate();
      } finally {  
        conPool.returnConnection(con);
      }
  }
  
  public int delete(int no) throws Exception { // 1) 삭제할 데이터의 넘버를 받아서 
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from tcher where tno=?");) { // 2) sql문의 인파라미터에 넣고, delete를 실행한 후
        stmt.setInt(1, no); // 3) 그 번호에 해당하는 
        return stmt.executeUpdate(); // 4) delete된 갯수를 리턴한다
      } finally {  
        conPool.returnConnection(con);
      }
  }
  
  public int update(Teacher teacher) throws Exception {
    Connection con = conPool.getConnection();
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update tcher set hmpg=?, fcbk=?, twit=? where tno=?");
      ) {
        stmt.setString(1, teacher.getHomepage());
        stmt.setString(2, teacher.getFacebook());
        stmt.setString(3, teacher.getTwitter());
        stmt.setInt(4, teacher.getNo());
        return stmt.executeUpdate();
      } finally {  
        conPool.returnConnection(con);
      }
  }
}
