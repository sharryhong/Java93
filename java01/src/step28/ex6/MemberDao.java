package step28.ex6;
import java.util.List;
import java.util.Map;

public interface MemberDao {
  // mybatis에서 dao구현체를 자동으로 만들게하려면, 메서드의 파라미터타입이 
  // sql맵퍼에 선언된 parameterType속성의 값과 같아야한다. 
  List<Member> selectList(Map<String,Object> valueMap) throws Exception;
  List<Member> selectListByNames(Map<String,Object> valueMap) throws Exception;
  Member selectOne(int no) throws Exception;
  Member selectOneByEmailPassword(Map<String,Object> valueMap) throws Exception;
  int insert(Member member) throws Exception;
  int delete(int no) throws Exception;
  int update(Member member) throws Exception;
}
