"use strict"

module.exports = {
  //

  setLectureDao(dao) {
    this.lectureDao = dao
  },

  // setManagerDao(dao) {
  //   this.managerDao = dao
  // },
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

  detail(no, success, error) {
    this.lectureDao.selectOne(no, success, error)
  },

  insert(lecture, success, error) {
    var obj = this
    this.lectureDao.insert(lecture, function(result) {
      lecture.no = result.insertId
      obj.lectureDao.insert(lecture, success, error)
    }, error)
  },

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
