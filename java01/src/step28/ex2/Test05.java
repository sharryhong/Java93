/* Mybatis 퍼시스턴스(지속성) 프레임워크 도입 */
package step28.ex2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex2/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    Member m = new Member();
    m.setNo(151);
    m.setName("홍이님최고");
    m.setEmail("hs@test.com");
    m.setTel("1111");
    m.setPassword("1111");
    
    System.out.println(memberDao.update(m));
    
  }

}
