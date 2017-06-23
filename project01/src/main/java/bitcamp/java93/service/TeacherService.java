package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Teacher;

public interface TeacherService {
  public List<Teacher> list(int pageNo, int pageSize) throws Exception;
  public Teacher get(int no) throws Exception;
  public Teacher getByEmailPassword(String email, String password) throws Exception;
  public void add(Teacher teacher) throws Exception;
  public void update(Teacher teacher) throws Exception;
  public void remove(int no) throws Exception;
}







