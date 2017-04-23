"use strict"

module.exports = {
  //

  setLectureDao(dao) {
    this.lectureDao = dao
  },

  setManagerDao(dao) {
    this.managerDao = dao
  },
  //
  // setClassroomDao(dao) {
  //   this.classroomDao = dao
  // },

  list(pageNo, success, error) {
    var obj = this
    this.lectureDao.selectList(pageNo, function(lectures) {
      obj.lectureDao.countAll(function(result) {
        success(lectures, result[0].cnt)
      }, error)
    }, error)
  },

  // nameList(function(results) {
  //   this.managerDao.nameList(success, error)
  // }, error),

  // detail(no, success, error) {
  //   this.lectureDao.selectOne(no, success, error)
  // },
  detail(no, success, error) {
    var obj = this
    this.managerDao.nameList(function(managers) {
      obj.lectureDao.selectOne(no, function(result) {
        console.log(managers)
        success(result, managers)
      }, error)
    }, error)
  },

  insert(lecture, success, error) {
    this.lectureDao.insert(lecture, function(result) {
      lecture.no = result.insertId
      success()
    }, error)
  },

/*
매니저 이름
select m.name
  from memb m join mgr mr on m.mno=mrno;
*/

  // update(lecture, success, error) {
  //   var obj = this
  //   this.lectureDao.update(lecture, function(result) {
  //     obj.lectureDao.update(lecture, success, error)
  //   }, error)
  // },
  update(lecture, success, error) {
    this.lectureDao.update(lecture, success, error)
  },

  delete(no, success, error) {
    this.lectureDao.delete(no, success, error)
  }

  // delete(no, success, error) {
  //   var obj = this
  //   this.lectureDao.delete(no, function(result) {
  //     obj.memberDao.delete(no, success, error)
  //   }, error)
  // } // delete()
} // exports
