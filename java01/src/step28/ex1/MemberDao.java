package step28.ex1;
import java.util.List;

public interface MemberDao {
  public List<Member> selectList(int pageNo, int pageSize) throws Exception;
  public Member selectOne(int no) throws Exception;
  public Member selectOneByEmailPassword(String email, String password) throws Exception;
  public int insert(Member member) throws Exception;
  public int delete(int no) throws Exception;
  public int update(Member member) throws Exception;
}
