package step28.ex6;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
  List<Teacher> selectList(Map<String,Object> valueMap) throws Exception;
  Teacher selectOne(int no) throws Exception;
  int insert(Teacher teacher) throws Exception;
}