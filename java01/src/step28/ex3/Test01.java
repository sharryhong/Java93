/* Mybatis 퍼시스턴스 프레임워크 : 동적 SQL을 만드는 법 */
package step28.ex3;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex3/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    // where절 없을 때 출력위한 코드. 전체 출력
    List<Member> list = memberDao.selectList(1, 100, null, null);
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("-------------------------------------------");
    
    list = memberDao.selectList(1, 100, "email", "hs@test.com");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("-------------------------------------------");
    
    list = memberDao.selectList(1, 100, "name", "홍길동");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("-------------------------------------------");
    
    list = memberDao.selectList(1, 100, "tel", "1111-1111");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
  }

}
