/* Business Layer. Service 담당.
   dao들을 호출만 한다.
*/
"use strict"

module.exports = {
  // studentDao 객체에 담긴 함수 등을 this.studentDao 담는다.
  setStudentDao(dao) {
    this.studentDao = dao
  },

  // memberDao 객체에 담긴 함수 등을 this.memberDao에 담는다.
  setMemberDao(dao) {
    this.memberDao = dao
  },

  list(pageNo, success, error) {
    var obj = this
    this.studentDao.selectList(pageNo, function(students) {
      // row갯수가 result로 들어온다.
      obj.studentDao.countAll(function(result) {
        // 매개변수인 success함수의 아규먼트로 보낸다.
        // students엔 쿼리 결과값이 담겨있다.
        success(students, result[0].cnt)
      }, error)
    }, error)
  },

  detail(no, success, error) {
    this.studentDao.selectOne(no, success, error)
  },
  insert(student, success, error) {
    var obj = this
    this.memberDao.insert(student, function(result) {
      // result.insertId엔 mno가 자동증가한 값이 들어있다.
      student.no = result.insertId
      obj.studentDao.insert(student, success, error)
    }, error)
  },

  update(student, success, error) {
    var obj = this
    this.memberDao.update(student, function(result) {
      obj.studentDao.update(student, success, error)
    }, error)
  },

  delete(no, success, error) {
    var obj = this
    this.studentDao.delete(no, function(result) {
      obj.memberDao.delete(no, success, error)
    }, error)
  } // delete()
} // exports
