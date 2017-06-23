package step28.ex2;
import java.util.List;

public interface MemberDao {
  List<Member> selectListByEmail(int pageNo, int pageSize, String email) throws Exception;
  List<Member> selectListByName(int pageNo, int pageSize, String name) throws Exception;
  List<Member> selectListByTel(int pageNo, int pageSize, String tel) throws Exception;
  public List<Member> selectList(int pageNo, int pageSize) throws Exception;
  public Member selectOne(int no) throws Exception;
  public Member selectOneByEmailPassword(String email, String password) throws Exception;
  public int insert(Member member) throws Exception;
  public int delete(int no) throws Exception;
  public int update(Member member) throws Exception;
}
