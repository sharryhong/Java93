package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Teacher;

public interface TeacherDao {
  List<Teacher> selectList(Map<String,Object> valueMap);
  Teacher selectOne(int no) throws Exception;
  Teacher selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(Teacher teacher) throws Exception;
  int delete(int no) throws Exception;
  int update(Teacher teacher) throws Exception;
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int teacherNo);
  void deletePhoto(int teacherNo);
}