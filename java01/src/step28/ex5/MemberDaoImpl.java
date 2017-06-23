package step28.ex5;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImpl implements MemberDao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public List<Member> selectList(int pageNo, int pageSize, String search, String value) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("search", search);
      valueMap.put("value", value);
      
      return sqlSession.selectList("step28.ex5.MemberDao.selectList", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectListByNames(int pageNo, int pageSize, String[] names) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("names", names);
      
      return sqlSession.selectList("step28.ex5.MemberDao.selectListByNames", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // sqlSession.selectOne()을 실행할 때는 반드시 결과를 한개만 만드는 sql을 지정해야한다.
      return sqlSession.selectOne("step28.ex5.MemberDao.selectOne", no);
      /* 이 자리엔 Object가 들어간다. 지금상황에서는 오토박싱되어 된다. new Integer(no) */
      
    } finally {
      sqlSession.close();
    }
  }

  public Member selectOneByEmailPassword(String email, String password) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("email", email);
      valueMap.put("password", password);
      
      return sqlSession.selectOne("step28.ex5.MemberDao.selectOneByEmailPassword", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.insert("step28.ex5.MemberDao.insert", member);
      
      // insert(), update(), delete() 한 후에는 
      // DBMS에 최종적으로 확정하는 명령을 보내야 실행이 완료된다.
      sqlSession.commit();
      return count;
      // 이걸 자동으로 하고 싶다? 
      // => SqlSession을 얻을 때 미리 설정해야한다. 
      // 코드 : SqlSession sqlSession = sqlSessionFactory.openSession(true);
      // 실무에서는 이렇게 하지 않는다.
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("step28.ex5.MemberDao.delete", no);
      
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("step28.ex5.MemberDao.update", member);
      
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
}
