"use strict"

function createStudentService(memberDao, studentDao) {
  return {
    /* list(pageNo, success, error) 스펙
    => pageNo: 가져올 페이지의 번호
    => success: 데이터 가져오는데 성공했을 때 호출될 함수
        success(학생데이터배열, 전체개수)
    => error: 데이터 가져오는데 실패했을 때 호출될 함수
        error(오류객체)
    */
    list(pageNo, success, error) {
      studentDao.selectList(pageNo, function(students) {
        studentDao.countAll(function(result) {
          success(students, result[0].cnt)
          console.log(result[0])
        }, error)
      }, error)
    },
    detail(no, success, error) {
      // 바이패스.. 이건 조작이 없다. 나중에 조작할 삽입 가능성이 있기때문에
      // 중간에 서비스를 경유하게 하는 것이다.
      studentDao.selectOne(no, success, error)
    },
    insert(student, success, error) {
      // 멤버에 insert하기
      memberDao.insert(student, function(result) {
        // 학생에 insert하기전에 필요한 값
        student.no = result.insertId
        studentDao.insert(student, success, error)
      }, error)
    },
    update(student, success, error) {
      memberDao.update(student, function(result) {
        studentDao.update(student, success, error)
      }, error)
    },
    delete(no, success, error) {
      studentDao.delete(no, function(result) {
        // 성공했으면 얘네한테 넘겨 
        memberDao.delete(no, success, error)
      }, error)
    }
  }
}
