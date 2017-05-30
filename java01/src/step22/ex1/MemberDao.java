/* 역할 :
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스
 */
package step22.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDao {
  Connection con;
  
  public MemberDao(String driver, String url, String username, String password) throws Exception {
    con = DriverManager.getConnection(url, username, password);
    Class.forName(driver);
  }

  // step20/Test04_2참고
  public void selectList() {
    try ( // 얘네들이 호출당한다. java.lang.AutoClosable규칙에 따라
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");) {
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
  
  public void insert(String name, String tel, String email, String password) {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");
      ) {
        stmt.setString(1, name);
        stmt.setString(2, tel);
        stmt.setString(3, email);
        stmt.setString(4, password);
        int count = stmt.executeUpdate();
        System.out.println(count);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  public void delete(int no) {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "delete from memb where mno=?");) {
        stmt.setInt(1, no);
        int count = stmt.executeUpdate();
        System.out.println(count);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  public void update(int no, String name, String tel, String email, String password) {
    try (
        PreparedStatement stmt = con.prepareStatement(
            "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");
      ) {
        stmt.setString(1, name);
        stmt.setString(2, tel);
        stmt.setString(3, email);
        stmt.setString(4, password);
        stmt.setInt(5, no);
        int count = stmt.executeUpdate();
        System.out.println(count);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
