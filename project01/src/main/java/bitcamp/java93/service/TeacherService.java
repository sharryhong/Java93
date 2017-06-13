package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TeacherDao;
import bitcamp.java93.domain.Teacher;

public class TeacherService {
  MemberDao memberDao;
  TeacherDao teacherDao;
  
  // 값을 설정하는 메서드인 setter만 추가한다. 
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  public void setTeacherDao(TeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }
  
  // 이 경우 중간에 중계만 하고 이 서비스에서는 하는 일은 없다. 
  public List<Teacher> list(int pageNo, int pageSize) throws Exception {
    return teacherDao.selectList(pageNo, pageSize);
  }
  
  public Teacher get(int no) throws Exception {
    return teacherDao.selectOne(no);
  }
  
  public void add(Teacher teacher) throws Exception {
    memberDao.insert(teacher);
    teacherDao.insert(teacher);
  }
  
  public void update(Teacher teacher) throws Exception {
    int count = memberDao.update(teacher);
    if (count < 1) {
      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
    }
    count = teacherDao.update(teacher);
    if (count < 1) {
      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
    }
  }
  
  public void remove(int no) throws Exception {
    int count = teacherDao.delete(no);
    
    if (count < 1) {
      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
    }
    
    try {
      count = memberDao.delete(no);
    } catch (Exception e) {}
    
  }
}
